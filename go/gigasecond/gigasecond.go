package gigasecond

// import path for the time package from the standard library
import "time"

const GigaSecond time.Duration = 1000000000 * time.Second

func AddGigasecond(t time.Time) time.Time {
	return t.Add(GigaSecond)
}
