package encode

import "strconv"

func RunLengthDecode(encoded string) (decoded string){
	if encoded == ""{
		return encoded
	} else {
		count := 0

		for _, char := range encoded {
			if num, err := strconv.Atoi(string(char)); err == nil {
				count *= 10
				count += num
			} else {
				if count == 0 {
					count =0
				}
			}
			count = 0
		}
	}
	return
}

func RunLengthEncode(decoded string) (encoded string){
	if decoded == ""{
		return decoded
	}

	return
}