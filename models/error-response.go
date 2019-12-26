package models

// ErrorResponse in the event of an error, return this response
type ErrorResponse struct {
	Code    int    `json:"code"`
	Message string `json:"message"`
}
