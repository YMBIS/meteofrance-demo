# meteofrance-demo

This small project is partially based on code from mvpjava.com.

As I was searching for the latest lightweight Java-JSON implementation, I came across a blog showing how to request Random.org API in Java.
This code has been re-used, because it filled perfectly the objective without being overkill, and because it was already using SpringBoot, like I aimed to.
It performs the HTTP Post calls, and the Json mapping.
Credits go to http://mvpjava.com/java-atmospheric-random/


For the Swing part : the class MeteoFranceDemo.java holds the view construction, and the timer.

The application.properties holds the Random.org service URI and the api-key (free for developers for 1k requests/day)


JRE 8 is required to execute the jar : from the project root directory, use : java -jar target/meteofrance-demo-0.0.1-SNAPSHOT.jar
(The console logs the HTTP responses and the random integer obtained.)

Maven is required to build the project.
