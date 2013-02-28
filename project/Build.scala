import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "diztorted"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
       javaCore, javaJdbc, javaEbean
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      // Add your own project settings here      
    )

}
