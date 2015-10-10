name := "Create_Web_Application"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  filters
)

play.Project.playJavaSettings

playAssetsDirectories <+= baseDirectory / "user"

