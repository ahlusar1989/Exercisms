package isogram

import (
	"strings"
	"unicode"
)

func IsIsogram(word string) bool {
	var wordSplit []string = strings.Split(word, "-")
	var joined string = strings.Join(wordSplit, "")
	var loweredWord = strings.ToLower(joined)

	wordFreq := make(map[rune]int)

	if len(loweredWord) == 0 {
		return true
	}

	for _, letter := range loweredWord {
		if !(unicode.IsSpace(letter)) {
			_, checkExists := wordFreq[letter]
			if checkExists == true {
				wordFreq[letter] += 1
			} else {
				wordFreq[letter] = 1
			}
		} else {
			continue
		}
	}

	for k := range wordFreq {
		if wordFreq[k] > 1 {
			return false
		}
	}

	return true

}
