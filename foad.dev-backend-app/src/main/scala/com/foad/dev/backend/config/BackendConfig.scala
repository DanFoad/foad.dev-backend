package com.foad.dev.backend.config

import com.foad.dev.backend.common.config.ApplicationConfig
import com.typesafe.config.Config
import net.ceedubs.ficus.Ficus._
import net.ceedubs.ficus.readers.ArbitraryTypeReader._

trait AppConfig {
  def config: Config
  def applicationConfig: ApplicationConfig = config.as[ApplicationConfig]("app")
}

class BackendConfig(val config: Config) extends AppConfig

object BackendConfig {
  def apply(config: Config): BackendConfig = {
    new BackendConfig(config)
  }
}
