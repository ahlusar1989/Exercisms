package reverse

import (
	"unicode/utf8"
)

func ReverseString(input string) string {

	bytesArr := make([]byte, len(input))
	for i, j := len(input)-1, 0; i >= 0; i-- {
		if utf8.RuneStart(input[i]) {
			r, size := utf8.DecodeRuneInString(input[i:len(input)])
			utf8.EncodeRune(bytesArr[j:j+size], r)
			j += size
		}
	}
	return string(bytesArr)
}
