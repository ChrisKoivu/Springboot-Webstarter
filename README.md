# Springboot-Webstarter


This repository has an initial configuration and setup to build a springboot mvc app using JPA with a mysql driver, the Freemarker template engine, and foundation 6.

This springboot app is originally intended to be the boilerplate structure needed to build a cms. You will notice some interesting code being used in the webcontroller and in the freemarker functions file. I am creating a hashmap render structure to call the template to render the content and to pass it to a index.ftl template. the index.ftl template doesnt really do much all it does is provide a template for the view being used in the controller method for getting the index. The content is being forced to demonstrate how the rendering works. 
