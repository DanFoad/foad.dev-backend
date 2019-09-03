package com.foad.dev.backend.model

import com.foad.dev.backend.common.model.Entity
import io.circe.Decoder.Result
import io.circe.{Decoder, Encoder, HCursor, Json}
import io.swagger.annotations.{ApiModel, ApiModelProperty}
import org.bson.codecs.configuration.CodecProvider
import org.mongodb.scala.bson.codecs.Macros
import io.circe.syntax._

import scala.annotation.meta.field

@ApiModel(description = "A label object")
case class Label(
   @(ApiModelProperty @field)(value = "Label key for programmatic access")
   override val _id: String,
   @(ApiModelProperty @field)(value = "Label translation value")
   value: String
 ) extends Entity(_id)

object Label {
  implicit val encoder: Encoder[Label] = new Encoder[Label] {
    override def apply(l: Label): Json = Json.obj(
      "id" -> l._id.asJson,
      "value" -> l.value.asJson
    )
  }

  implicit val decoder: Decoder[Label] = new Decoder[Label] {
    override def apply(c: HCursor): Result[Label] = for {
      id <- c.downField("id").as[Option[String]]
      value <- c.downField("value").as[Option[String]]
    } yield Label(id.getOrElse(""), value.getOrElse(""))
  }
  val labelCodecProvider: CodecProvider = Macros.createCodecProviderIgnoreNone[Label]()
}
