package anagram

import (
	"reflect"
	"sort"
	"strings"
)

//letters creates an array of characters in a string for sorting
type letters []rune

func (s letters) Len() int           { return len(s) }
func (s letters) Swap(i, j int)      { s[i], s[j] = s[j], s[i] }
func (s letters) Less(i, j int) bool { return s[i] < s[j] }

func Detect(subject string, candidates []string) []string {
	word := strings.ToLower(subject)
	wordLetters := letters(word) //runes
	sort.Sort(wordLetters)
	var anagrams []string
	for _, candidate := range candidates {
		candidateLetters := letters(candidate) // runes
		sort.Sort(candidateLetters)
		if reflect.DeepEqual(candidateLetters, wordLetters) &&
			word != candidate {
			anagrams = append(anagrams, candidate)
		}

	}
	return anagrams
}
