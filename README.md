# MDF Bank - Microservice demo app

 > Work in progress...
 
Components:

- Discovery with Eureka
- Spring Boot Admin
- Hystrix 
- HystrixDashboard (inside SBA)
- Turbine (inside SBA)
- Swagger
- Spring RestTemplate with Ribbon
- Spring boot/cloud on every app with actuator


 How to run:

 First clone repo
 
 next install mongodb on docker
 
 `$ docker run --name mongo -p 32768:27017 -d mongo`
 
 and run:
 
 inside Intellij Idea
 
 or

 `$ cd mdfBank/`

 `$ ./runLocal.sh start`

 to stop run:

 `$ ./runLocal.sh stop`

 You can also reload module

 `$ ./runLocal.sh down moduleName`

 `$ ./runLocal.sh up moduleName`

 or just reload

 `$ ./runLocal.sh reload moduleName`

 To launch in browser use swagger url:

 [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
 
 To see Eureka panel use:

 [Go to Eureka](http://localhost:8761)
 
 To see Spring boot admin
  
 [Spring boot admin](http://localhost:8090)
 
