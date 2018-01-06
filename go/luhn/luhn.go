package luhn

import (
	"strconv"
	"strings"
)

func Valid(luhnInput string) bool {

	var sum int64

	if len(luhnInput) <= 1 {
		return false
	}
	if len(luhnInput) == 2 && strings.HasPrefix(luhnInput, " ") {
		return false
	}

	luhnInput = strings.Replace(luhnInput, " ", "", -1)
	numberContainer := []int64{}

	for _, letter := range luhnInput {
		num, err := strconv.ParseInt(string(letter), 10, 64)
		if err != nil {
			return false
		}
		numberContainer = append(numberContainer, num)
	}

	for i := len(numberContainer) - 2; i >= 0; i -= 2 {
		digitProduct := numberContainer[i] * 2
		if digitProduct > 9 {
			digitProduct -= 9
		}
		numberContainer[i] = digitProduct
	}

	for _, numeral := range numberContainer {
		sum += numeral
	}

	return sum%10 == 0
}
