package com.foad.dev.backend

import akka.http.scaladsl.server.Directives.{getFromResourceDirectory, _}
import com.foad.dev.backend.swagger.SwaggerDocService
import com.foad.dev.backend.model.Label.labelCodecProvider
import com.foad.dev.backend.repository.LabelRepository
import com.foad.dev.backend.routes.LabelRoute
import com.foad.dev.backend.service.LabelService
import org.bson.codecs.configuration.CodecRegistries.{fromProviders, fromRegistries}
import org.bson.codecs.configuration.CodecRegistry
import org.mongodb.scala.bson.codecs.DEFAULT_CODEC_REGISTRY

trait Module extends Application {
  import com.softwaremill.macwire._

  val codecRegistry: CodecRegistry = fromRegistries(
    fromProviders(labelCodecProvider),
    DEFAULT_CODEC_REGISTRY
  )
  lazy val labelRepository = wire[LabelRepository]
  lazy val labelService= wire[LabelService]
  lazy val labelRoutes = wire[LabelRoute]

  lazy val swaggerRoutes = SwaggerDocService.routes ~ getFromResourceDirectory("swagger-ui")
}
