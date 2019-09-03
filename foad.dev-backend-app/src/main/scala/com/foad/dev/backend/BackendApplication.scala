package com.foad.dev.backend

import akka.http.scaladsl.server.Directives._

object BackendApplication extends Module {
  startApplication(labelRoutes.routes ~ swaggerRoutes)
}
