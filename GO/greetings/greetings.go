package greetings

import "errors"
import "fmt"

func Hello(name string) (string, error) {
	if name == "" {
		return "", errors.New("empty name")
	}
	message := fmt.Sprintf("Hello, %s welcome!", name)
	return message, nil
}
