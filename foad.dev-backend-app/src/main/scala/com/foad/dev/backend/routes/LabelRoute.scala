package com.foad.dev.backend.routes

import akka.http.scaladsl.marshalling.Marshal
import akka.http.scaladsl.model.{HttpResponse, ResponseEntity}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.Materializer
import com.foad.dev.backend.model.Label
import com.foad.dev.backend.service.LabelService
import com.foad.dev.backend.common.http.Helpers._
import io.swagger.annotations.{Api, ApiOperation }
import de.heikoseeberger.akkahttpcirce.ErrorAccumulatingCirceSupport._
import javax.ws.rs.{GET, Path}

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}

/**
  * GET   /api/labels
  */

@Path("/api/labels")
@Api(value = "/api/labels", produces = "application/json")
class LabelRoute(labelService: LabelService)(implicit ec: ExecutionContext, mat: Materializer) {

  @GET
  @Path("/")
  @ApiOperation(
    httpMethod = "GET",
    response = classOf[Map[String, String]],
    responseContainer = "List",
    value = "Returns a list of labels"
  )
  def findAll: Route = (get & pathEndOrSingleSlash) {
    onComplete(labelService.findAll()) {
      case Success(labels) =>
        complete(Marshal(labels).to[ResponseEntity].map { e => HttpResponse(entity = e) })
      case Failure(e) =>
        complete(handleFailure(e.getMessage))
    }
  }

  val routes: Route = pathPrefix("api" / "labels") {
    findAll
  }
}