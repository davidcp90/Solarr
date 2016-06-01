package com.torre.keplerr	
import org.scalatra._
import org.scalatra.json._
import org.json4s.{DefaultFormats, Formats}

class Solarr extends SolarrStack with JacksonJsonSupport {
	case class Person(id: Int, name: String)
	//filter to make the content type json
	before() {
    		contentType = formats("json")
 	 }
	 get("/"){
  		PersonData.all
	}	
	object PersonData {
		var all = List(
			Person(1, "David Camargo"),
			Person(2, "Amaury Prieto"),
			Person(3, "Manuel Montes"))
	}
	
}
// Sets up automatic case class to JSON output serialization, required by
// the JValueResult trait.
protected implicit val jsonFormats: Formats = DefaultFormats

