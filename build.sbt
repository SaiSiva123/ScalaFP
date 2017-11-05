name := "ScalaFP"
version := "1.0-SNAPSHOT"

description := "ScalaFunctionalProgrammingExamples"

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

scalaVersion := "2.12.1"

// append -deprecation to the options passed to the Scala compiler
scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")

//command line tools
libraryDependencies += "com.typesafe" % "config" % "1.3.1"
libraryDependencies += "com.typesafe.akka" % "akka-actor_2.12" % "2.4.16"


parallelExecution in Test := false
autoScalaLibrary := false

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
resolvers += "Releases" at "http://nexus-dev/content/repositories/releases"
resolvers += "Snapshots" at "http://nexus-dev/content/repositories/snapshots"
resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"

resolvers += Resolver.mavenLocal
