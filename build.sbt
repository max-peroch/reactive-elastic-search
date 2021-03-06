import sbt.Keys._

name := "reactive-elastic-search"

version := "0.0.6-SNAPSHOT"

organization := "io.surfkit"

scalaVersion := "2.11.8"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

lazy val root = project.in(file(".")).settings(
  credentials += Credentials(Path.userHome / ".ivy2" / ".credentials"),
  resolvers += "NextWave Repo" at "https://repository.conversant.im/artifactory/nxtwv-maven/",
  publishTo := Some("NextWave Repo" at "https://repository.conversant.im/artifactory/nxtwv-maven/")
)


libraryDependencies ++= deps

scalaVersion := "2.11.7"

fork := true

lazy val deps = {
  val akkaV = "2.4.8"
  Seq(
    "com.typesafe.akka"       %% "akka-actor"                 % akkaV,
    "com.typesafe.akka"       %% "akka-http-experimental"     % akkaV,
    "com.typesafe.play"       %% "play-json"                  % "2.4.4"
  )
}

dependencyOverrides ++= Set(
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.4.4"
)

