# MDF Bank - Microservice demo app

 > Work in progress...

 How to:

 First clone all repos
 
 next install mongodb on docker
 
 `$ docker run --name mongo -p 32768:27017 -d mongo`
 
 and run:

 `$ cd mdfBank/`

 `$ ./runLocal.sh start`

 to stop run:

 `$ ./runLocal.sh stop`

 You can also reload module

 `$ ./runLocal.sh down moduleName`

 `$ ./runLocal.sh up moduleName`

 or just reload

 `$ ./runLocal.sh reload moduleName`

 To launch in browser use example url:

 [localhost:8080/customer/data/1](http://localhost:8080/customer/data/1)

 To see Eureka panel use:

 [Eureka](http://localhost:8761)
