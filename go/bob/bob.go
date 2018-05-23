package bob

import (
	"strings"
)

const (
	fineBeThatWay    = "Fine. Be that way!"
	chillOut         = "Whoa, chill out!"
	calmDown         = "Calm down, I know what I'm doing!"
	questionResponse = "Sure."
	defaultResponse  = "Whatever."
)

func Hey(remark string) string {
	remark = strings.TrimSpace(remark)
	if len(remark) == 0 {
		return fineBeThatWay
	}
	if strings.ToUpper(remark) == remark && strings.ToLower(remark) != remark && remark[len(remark)-1] == '?' {
		return calmDown
	}
	if strings.ToUpper(remark) == remark && strings.ToLower(remark) != remark {
		return chillOut
	}
	if remark[len(remark)-1] == '?' {
		return questionResponse
	}
	return defaultResponse
}
