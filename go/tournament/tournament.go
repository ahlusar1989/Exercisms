package tournament

import (
	"bufio"
	"errors"
	"fmt"
	"io"
	"sort"
	"strings"
)

type team struct {
	name                string
	wins, losses, draws int
}

type sortWinners []*team

func Tally(input io.Reader, out io.Writer) error {
	var teams = map[string]*team{}

	scanner := bufio.NewScanner(input)

	for scanner.Scan() {
		currentLine := scanner.Text()
		team1, team2, result, err := parseCurrentLine(currentLine)
		if err != nil {
			return err
		}
		if result == "invalid" {
			continue
		}

		var t1, t2 *team
		var validData bool

		if t1, validData = teams[team1]; !validData {
			t1 = &team{name: team1}
			teams[team1] = t1
		}
		if t2, validData = teams[team2]; !validData {
			t2 = &team{name: team2}
			teams[team2] = t2
		}

		switch result {
		case "win":
			t1.wins++
			t2.losses++
		case "loss":
			t1.losses++
			t2.wins++
		case "draw":
			t2.draws++
			t1.draws++
		default:
			return errors.New("Malformed input")
		}

	}

	writeOutResults(teams, out)
	return nil
}

func (winRef sortWinners) Len() int {
	return len(winRef)
}

func (t sortWinners) Swap(i, j int) {
	t[i], t[j] = t[j], t[i]
}

func (t sortWinners) Less(i, j int) bool {
	if t[i].wins != t[j].wins {
		return t[i].wins > t[j].wins
	} else if t[i].getPoints() != t[j].getPoints() {
		return t[i].getPoints() > t[j].getPoints()
	}
	return t[i].name < t[j].name
}

func writeOutResults(teams map[string]*team, out io.Writer) error {
	pointers := []*team{}
	header := "Team                           | MP |  W |  D |  L |  P\n"

	for _, dataPoint := range teams {
		pointers = append(pointers, dataPoint)
	}
	sort.Sort(sortWinners(pointers))

	out.Write([]byte(header))
	for _, team := range pointers {
		currentTeam := fmt.Sprintf("%-30s | %2d | %2d | %2d | %2d | %2d\n", team.name,
			team.gamesPlayed(),
			team.wins, team.draws, team.losses,
			team.getPoints())
		out.Write([]byte(currentTeam))
	}
	return nil
}

func (t *team) gamesPlayed() int {
	return t.wins + t.draws + t.losses
}

func (t *team) getPoints() int {
	return (t.wins * 3) + (t.draws)
}

func parseCurrentLine(line string) (string, string, string, error) {
	if line == "" || line[0] == '#' {
		return "", "", "invalid", nil
	}
	dataFields := strings.Split(line, ";")

	if len(dataFields) != 3 {
		return "", "", "", errors.New("Incomplete/Malformed line in this data")
	}
	if dataFields[0] == "" {
		return "", "", "invalid", nil
	}
	return dataFields[0], dataFields[1], dataFields[2], nil
}
