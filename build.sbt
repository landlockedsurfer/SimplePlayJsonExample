name := "simple-play-json-example"

version := "1.0"

scalaVersion := "2.11.4"

resolvers ++= Seq(
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % "2.3.6",
  "com.typesafe.play" %% "play-ws" % "2.3.6"
)
