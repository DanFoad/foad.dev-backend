package controllers

import (
	"fmt"
	"io/ioutil"

	"github.com/danfoad/foad.dev-backend/models"

	"net/http"

	"github.com/gin-gonic/gin"
)

// APILabelsGET return latest labels for app
func APILabelsGET(c *gin.Context) {
	labels, err := ioutil.ReadFile("./assets/labels.json")

	if err != nil {
		var response models.ErrorResponse

		fmt.Println(err)
		response.Code = http.StatusInternalServerError
		response.Message = err.Error()
		c.JSON(http.StatusInternalServerError, response)
	}

	c.Data(http.StatusOK, "application/json", labels)
}
