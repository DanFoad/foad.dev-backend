package com.foad.dev.backend.service

import com.foad.dev.backend.repository.LabelRepository

import scala.concurrent.Future

class LabelService(labelRepository: LabelRepository) {
  def findAll(): Future[Map[String, String]] = {
    labelRepository.queryAll()
  }
}
