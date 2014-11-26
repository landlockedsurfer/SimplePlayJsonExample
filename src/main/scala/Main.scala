package main

import play.api.libs.json._

case class Person(name: String, age: Int, nobelPrize: Option[Boolean])

object Main extends App {

  // Create JSON object from JSON string
  // Json.parse throws exception if string isn't valid JSON
  val jsonPerson = Json.parse(
    """{
      |  "name" : "Martin Fleischmann",
      |  "age" : 85
      |}
    """.stripMargin
  )

  // Create Reads to map JSON to Person case class
  // See also: https://www.playframework.com/documentation/2.3.x/ScalaJsonInception
  implicit val personReads = Json.reads[Person]

  // Try to see if jsonPerson "fits" into case class Person
  val maybePerson = jsonPerson.validate[Person]

  maybePerson match {
    case JsSuccess(p,_) => println("Sucessfully parsed Person:\n" + p)
    case JsError(errors) => {
      println("Given JSON is not a person.")
    }
  }
}
