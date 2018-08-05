package diamond

import (
	"errors"
	"strings"
)

func Gen(inputLetter byte) (string, error) {
	if inputLetter < byte('A') || byte('Z') < inputLetter {
		return "", errors.New("Not a valid limit: " + string(inputLetter))
	}
	length := int(inputLetter - byte('A'))
	result := make([]string, 2*length+1)
	for r := 0; r <= length; r++ {
		row := make([]rune, 2*length+1)
		for col, _ := range row {
			letter := ' '
			if length+r == col || length-r == col {
				letter = rune('A' + r)
			}
			row[col] = letter
		}
		result[r] = string(row)
		result[2*length-r] = string(row)
	}
	return strings.Join(result, "\n") + "\n", nil
}
