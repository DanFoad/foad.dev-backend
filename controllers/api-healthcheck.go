package controllers

import (
	"net/http"

	"github.com/gin-gonic/gin"

	"github.com/danfoad/foad.dev-backend/models"
)

// APIHealthcheckGET return default data for backend home
func APIHealthcheckGET(c *gin.Context) {
	var response models.HealthcheckResponse
	response.Status = http.StatusOK

	c.JSON(http.StatusOK, response)
}
