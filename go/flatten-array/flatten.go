package flatten


func Flatten(listOfinterfaces interface{}) []interface{} {
	switch listOfinterfaces.(type){
	case []interface{}:
		result := []interface{}{}
		for _, item := range listOfinterfaces.([]interface{}){
			for _, element := range Flatten(item){
				result = append(result, element)
			}
		}
		return result;
	case nil: 
		return []interface{}{}

	}
	return []interface{}{listOfinterfaces}
}