package com.foad.dev.backend.repository

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class LabelRepository {
  def queryAll(): Future[Map[String, String]] = {
    Future(Map("app.name" -> "foad.dev"))
  }
}
