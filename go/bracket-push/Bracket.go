package brackets

//bType demarcates whether incoming rune is opening, closing, or neither
type bType int

const ( // auto-increment trick
	openBracket bType = iota
	closeBracket
	notABracket
)

//bracketPairs are the matching pairs of brackets
var mapping = map[rune]rune{'{': '}', '[': ']', '(': ')'}

func Bracket(inputString string) (bool, error) {
	var queue []rune
	for _, r := range inputString {
		switch getBracketType(r) {
		case openBracket:
			queue = append(queue, mapping[r])
		case closeBracket:
			if 0 < len(queue) && queue[len(queue)-1] == r {
				queue = queue[:len(queue)-1]
			} else {
				return false, nil
			}
		}
	}
	return len(queue) == 0, nil
}

func getBracketType(char rune) bType {
	for k, v := range mapping {
		switch char {
		case k:
			return openBracket
		case v:
			return closeBracket
		}
	}
	return notABracket
}
