package main

import (
	"log"
	"time"

	"github.com/gin-contrib/cors"
	"github.com/gin-gonic/autotls"
	"github.com/gin-gonic/gin"

	"github.com/danfoad/foad.dev-backend/controllers"
)

func main() {
	r := gin.Default()
	r.Use(gin.Logger())

	r.Use(cors.New(cors.Config{
		AllowOrigins:     []string{"*"},
		AllowMethods:     []string{"GET", "POST"},
		AllowHeaders:     []string{"Origin"},
		ExposeHeaders:    []string{"Content-Length"},
		AllowCredentials: true,
		MaxAge:           12 * time.Hour,
	}))

	r.GET("/", controllers.APIHealthcheckGET)

	api := r.Group("/api/v1")
	{
		api.GET("/labels", controllers.APILabelsGET)
	}

	r.NoRoute(controllers.NoRoute)

	log.Fatal(autotls.Run(r, "backend.foad.dev"))
}
