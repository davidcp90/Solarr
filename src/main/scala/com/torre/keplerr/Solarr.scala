package com.torre.keplerr	
import org.scalatra._
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._
import org.scalatra.swagger._
class Solarr (implicit val swagger: Swagger) extends SolarrStack with NativeJsonSupport with SwaggerSupport {
	protected val applicationDescription = "The Solarr API. It exposes operations for browsing and searching lists of persons, and retrieving single persons."
  protected implicit lazy val jsonFormats: Formats = DefaultFormats
  before() {
    contentType = formats("json")
  }

  case class Person(slug: String, name: String)
  val getPersons =
    (apiOperation[List[Person]]("getPersons")
      summary "Show all persons"
      notes "Shows all the persons in solarr. You can search it too."
      parameter queryParam[Option[String]]("name").description("A name to search for"))

	get("/", operation(getPersons)){
		params.get("name") match {
			case Some(name) => PersonData.all filter (_.name.toLowerCase contains name.toLowerCase())
			case None => PersonData.all
		}
	}
  val findBySlug =
    (apiOperation[Person]("findBySlug")
      summary "Find by slug"
      parameters (
      pathParam[String]("slug").description("Slug of person that needs to be fetched")
      ))
	get("/:slug", operation(findBySlug)) {
		PersonData.all find (_.slug == params("slug")) match {
			case Some(b) => b
			case None => halt(404)
		}
	}
	object PersonData {
		var all = List(
			Person("david-c", "David Camargo"),
			Person("amaury-p", "Amaury Prieto"),
			Person("manuel-m", "Manuel Montes"))
	}
	
}

