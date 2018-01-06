package letter

type FreqMap map[rune]int

func Frequency(s string) FreqMap {
	m := FreqMap{}
	for _, r := range s {
		m[r]++
	}
	return m
}

func ConcurrentFrequency(texts []string) FreqMap {
	c := make(chan FreqMap)
	for _, s := range texts {
		go func(s string) { c <- Frequency(s) }(s)
	}

	totalCountMapping := FreqMap{}
	for range texts {
		for letter, freq := range <-c {
			totalCountMapping[letter] += freq
		}
	}
	return totalCountMapping
}
