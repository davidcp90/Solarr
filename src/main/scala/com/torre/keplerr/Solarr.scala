package com.torre.keplerr	
import org.scalatra._
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._

class Solarr extends SolarrStack {
  case class Person(id: Int, name: String)
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

