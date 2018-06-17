package transpose



func Transpose(inputGrid []string) []string {
	
	largestStringSize := computeMaxStringLength(inputGrid)

	outputResult := make([]string, largestStringSize)

	if len(inputGrid) == 0{
		return outputResult
	}
	for i, word := range inputGrid {
		for j, char := range word {
			outputResult[j] += string(char)
		}
		nextLineLength := computeMaxStringLength(inputGrid[i:])
		for k := len(word); k < nextLineLength; k++ {
			outputResult[k] += " "
		}		

	}

	return outputResult
}

func computeMaxStringLength(input []string) (outputLength int){
	outputLength = 0
	for _, strings := range input {
		if len(strings) > outputLength {
			outputLength = len(strings)
		}
	}
	return outputLength
}
