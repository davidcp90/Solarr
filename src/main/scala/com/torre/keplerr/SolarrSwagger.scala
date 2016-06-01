/**
  * Created by david on 6/1/16.
  */
package com.torre.keplerr

import org.scalatra.ScalatraServlet
import org.scalatra.swagger.{ApiInfo, NativeSwaggerBase, Swagger}


class ResourcesApp(implicit val swagger: Swagger) extends ScalatraServlet with NativeSwaggerBase

object SolarrApiInfo extends ApiInfo(
  "The Solarr API",
  "Docs for the Solarr API",
  "http://solarr.torre",
  "solarr@torre.co",
  "MIT",
  "http://opensource.org/licenses/MIT")

class SolarrSwagger extends Swagger(Swagger.SpecVersion, "1.0.0", SolarrApiInfo)
