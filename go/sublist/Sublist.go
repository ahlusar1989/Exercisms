package sublist

import "reflect"

type Relation string

func Sublist(a, b []int) Relation {
	diff := len(a) - len(b)
	if diff == 0 && reflect.DeepEqual(a, b) {
		return "equal"
	} else if diff > 0 && Compare(a, b) {
		return "superlist"
	} else if diff < 0 && Compare(b, a) {
		return "sublist"
	}
	return "unequal"
}

func Compare(list1, list2 []int) bool {
	for i, _ := range list1 { //iterate over the larger one
		match := true // set boolean scoped on the length of the array
		for j, item := range list2 { // compare each index item with the next one in the list
			if item != list1[i+j] {
				match = false
				break
			}
		}
		if match { //return true after running through the second array we still surface a true
			return true
		}
	}
	return false
}