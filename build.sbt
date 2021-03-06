import com.typesafe.startscript.StartScriptPlugin

seq(StartScriptPlugin.startScriptForClassesSettings: _*)

organization := "com.bazoud"

name := "scalastory"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.9.2"

seq(webSettings :_*)

classpathTypes ~= (_ + "orbit")

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.0.6",
  "org.scalatra" % "scalatra" % "2.1.1",
  "org.scalatra" % "scalatra-scalate" % "2.1.1",
  "org.scalatra" % "scalatra-specs2" % "2.1.1" % "test",
  "org.eclipse.jetty" % "jetty-webapp" % "8.1.7.v20120910" % "container;compile;test",
  "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container;provided;test" artifacts (Artifact("javax.servlet", "jar", "jar"))
)
