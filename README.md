# typeface(Backend)
1. The typeface app is built using JAVA, Maven, and SpringBoot framework, Thymeleaf(for UI).
2. FileSystem is used as a Database to store all relevant information.

#  How to run
1. Install Java
2. Install Maven
3. Build the spring-boot app using the command **mvn clean install**
4. Run the spring boot app using the command **mvn spring-boot:run -Dspring-boot.run.arguments=--upload.directory={DirectoryAbsolutePath}**
5. Pass the file directory absolute path in 4th step where you want to store the local file system.
6. App will be available at http://localhost:8080
