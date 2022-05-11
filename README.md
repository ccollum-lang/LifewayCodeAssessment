#  LifeWay Christian Resources Code Assessment

## Table of Contents:
* Prompt
* How to Install and Run the Project

### Prompt
1. Create a REST service with a single endpoint that accepts a json message with two
fields, "id" and "message". (example: {"id": "123", "message": "Hello, World!})

2. The endpoint should return a json document with a single field "count" that contains the
total number of words contained in all the messages received to that point.

3. The service should ignore messages with duplicate IDs. (i.e. IDs that have already been processed)

### My Approach
Using the Spring Framework, I was able to set up a REST service that can be accessed using `curl` commands or a service like Insomnia or Postman.
As for the approach to storage, I chose the H2 Database, as it is an in-memory database that can also be configured to not close on termination of service.


### How to Use the Project
To run the project, simply run the Spring Boot Application using an IDE or command prompt using Maven`mvn spring-boot:run`
or Gradle `gradlew bootRun`. This will launch the REST service. (**PLEASE NOTE**: the application MUST be running in
order to access it via `curl` or Insomnia/Postman)
* Please note  that if you build it using the command prompt, you must be in the LifewayCodeAssessment directory.

Once the Web Service is running, use a program like Insomnia or Postman, or `curl` to send GET and POST
requests to the following web page: [http://localhost:8080/message](http://localhost:8080/message)
* **IMPORTANT NOTE** When sending a POST, ensure the "message" portion of the JSON message contains
 less than 255 characters , as this is the limitation of the H2 Database.
