name := "ScalazTaskVsFuture"

version := "1.0"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
    "org.scalaz" %% "scalaz-core" % "7.2.16",
    "org.scalaz" %% "scalaz-concurrent" % "7.2.16"
)

scalacOptions += "-deprecation"


