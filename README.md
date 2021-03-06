# Springboot-Webstarter


This repository has an initial configuration and setup to build a springboot mvc app using JPA with a mysql driver, the Freemarker template engine, and foundation 6.

This springboot app is originally intended to be the boilerplate structure needed to build a cms. You will notice some interesting code being used in the webcontroller and in the freemarker functions file. I am creating a hashmap render structure to call the template to render the content and to pass it to a index.ftl template. the index.ftl template doesnt really do much all it does is provide a template for the view being used in the controller method for getting the index. The content is being forced to demonstrate how the rendering works.

to see how the sample website in action, download the jar from https://github.com/ChrisKoivu/Springboot-Webstarter/blob/version-1.0.0/target/springboot-website-starter-1.0.0.jar, and run it with this command: 


`java -jar springboot-website-starter-1.0.0.jar`



> Resources: 
* Foundation: https://get.foundation/sites/docs/installation.html
* Freemarker: https://freemarker.apache.org/
* Good article on the Java Persistence API: https://www.infoworld.com/article/3373652/java-persistence-with-jpa-and-hibernate-part-1-entities-and-relationships.html
* Maven Central Repository: https://mvnrepository.com/repos/central
