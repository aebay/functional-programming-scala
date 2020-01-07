import Dependencies._

lazy val commonSettings = Seq(
  version := "0.1",
  scalaVersion := "2.13.1",
  scalaBinaryVersion := "2.13"
)

lazy val root = (project in file("."))
  .settings(
    name := "functional-programming-scala",
    commonSettings,
    libraryDependencies ++= commonDependencies
  )

assemblyMergeStrategy in assembly := {
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}