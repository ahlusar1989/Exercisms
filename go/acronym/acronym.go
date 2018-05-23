// This is a "stub" file.  It's a little start on your solution.
// It's not a complete solution though; you have to write some code.

// Package acronym should have a package comment that summarizes what it's about.
// https://golang.org/doc/effective_go.html#commentary
package acronym

import (
	"strings"
)

// Abbreviate should have a comment documenting it.
func Abbreviate(s string) string {
	result := ""
	words := strings.Split(s, " ")
	for _, word := range words {
		if strings.ContainsAny(word, "-") {
			dashedTemp := strings.Split(word, "-")
			for _, dashedTemp := range dashedTemp {
				result += string([]rune(dashedTemp)[0])
			}
		} else {
			result += string([]rune(word)[0])
		}

	}
	return strings.ToUpper(result)
}
