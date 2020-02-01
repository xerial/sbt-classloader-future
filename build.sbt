lazy val root = 
  project
  .in(file("."))
  .settings(
    name := "example",
    // Uncomment one of these settings to avoid the class loader issue inside Future
    // classLoaderLayeringStrategy in run := ClassLoaderLayeringStrategy.Flat,
    // fork in run := true,
  )
