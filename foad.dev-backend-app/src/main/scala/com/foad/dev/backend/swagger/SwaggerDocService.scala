package com.foad.dev.backend.swagger

import com.github.swagger.akka.SwaggerHttpService
import com.github.swagger.akka.model.Info
import com.foad.dev.backend.routes.LabelRoute

object SwaggerDocService extends SwaggerHttpService {
  override val apiClasses: Set[Class[_]]= Set(classOf[LabelRoute])
  override val host = "localhost:8080"
  override val apiDocsPath = "api-docs"
  override val info = Info(title="foad.dev backend API", description="API for foad.dev backend", version = "1.0")
}
