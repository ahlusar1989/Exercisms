package cryptosquare

import ( 
	"strings"
	"math"
	"unicode"
)

func Encode(input string) string{

	processedString := ""

	for _, v := range strings.ToLower(input) {
		if unicode.IsLetter(v) || unicode.IsNumber(v){
			processedString += string(v)
		}

	}

	cols := int(math.Ceil(math.Sqrt(float64(len(processedString)))))

	cipherText := make([]string, cols)

	for i := 0 ; i < cols; i++ {
		for j  := i; j < len(processedString); j += cols {
			cipherText[i] += string(processedString[j])
		}
	}


	return strings.Join(cipherText, " ")
}