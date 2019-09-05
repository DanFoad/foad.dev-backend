package com.foad.dev.backend.repository

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class LabelRepository {
  def queryAll(): Future[Map[String, String]] = {
    Future(
      Map(
        "app.name" -> "foad.dev",
        "general.name" -> "Dan Foad",
        "general.role" -> "Associate Software Developer",
        "general.aboutMe" -> "About Me",
        "general.featuredProject" -> "Featured Project",
        "home.header.subline" -> "Currently working with NowTV",
        "home.header.contact" -> "Contact Me",
        "app.nav.links.home" -> "Home",
        "app.nav.links.projects" -> "Projects",
        "app.nav.links.cv" -> "CV",
        "app.nav.links.blog" -> "Blog",
        "app.nav.links.contact" -> "Contact Me"
      )
    )
  }
}
