package hamming

import "errors"

func Distance(a, b string) (int, error) {

	bLen := []byte(b)
	aLen := []byte(a)

	if(len(aLen) != len(bLen)){
		return 0, errors.New("a, b are not the same length")
	}

	diff := 0

	for i := 0; i < len(aLen); i++{
		byte1 := aLen[i]
		byte2 := bLen[i]
		if(byte1 != byte2){
			diff++
		}
	}


	return diff, nil
}
