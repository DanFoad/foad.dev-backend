package controllers

import (
	"net/http"

	"github.com/danfoad/foad.dev-backend/models"
	"github.com/gin-gonic/gin"
)

// NoRoute 404 handler
func NoRoute(c *gin.Context) {
	var response models.ErrorResponse
	response.Code = http.StatusNotFound
	response.Message = "The requested route could not be found, please refer to the API documentation"

	c.JSON(http.StatusNotFound, response)
}
