# order-management

PS. 1) It's assumed that the sql server will be run as a container.
    2) if the application is run on localhost  (not as a container), open application.properties -> uncomment the spring.datasource.url that has localhost as the server, and comment the other one having environment variable ${SERVER_NAME}
    3) if the application is run as a container, then rememeber to define the environment variable, and both of the containers should be run on the same custom network within docker to permit DNS. 'details are shown moving forward in the readme file'.
    4) the sql server should always be started before the application and contain the database called 'project_hasan'.

* Application Build:
  the application can be build using maven tool after making sure that the app includes all dependencies needed and there isn't obvious errors by using:
  mvn clean package
  - which actually cleans any previous builds in order to start new fresh build for the app.
  - the package includes doing the compilation, tests and opackages the app into JAR file.

* Docker image creation - push - running:
  the following lines were used as the docker file in order to containerize the application:
  1) FROM eclipse-temurin:17-jdk-focal : this imports the base image for the container, it includes the JDK 17.
  2) VOLUME /tmp : to create a mount point within the container for sharing data between the host and the container  'it wasn't used in this application'
  3) WORKDIR /special : to specify a directory within the container in order to execute the following commands in the docker file in the specified directory which is 'special' in this case.
  4) COPY .mvn/ .mvn : it copies the content within the mvn file to special/.mvn within the directory.
  5) COPY mvnw pom.xml ./ : it also copies the files mvnw and pom.xml to the /special directory within the conainer. 'mvnw is used to make maven builds without the need of maven tool locally'
  6) RUN apt-get update && apt-get install -y dos2unix: dos2unix is actually a tool that converts the text files between windows and Linux. the command updates the packages list and installs dos2unix in the container.
  7) RUN dos2unix mvnw: this tool makes sure that the emdings of the lines in mvnw file are unix compatible.
  8) RUN ./mvnw dependency:go-offline : this command downloads all needed dependencies to make the application runnable offline, it has drawback as it enlarges the image size.
  9) COPY src ./src : this command copies all the src folder to the /special directory.
  10) CMD ["./mvnw", "spring-boot:run"] : this command is run when the container starts and it starts the application within the container.

  *Then in order to build the container: docker build -t hasanalrimawi/ordermanagement:v1.1 .
  *And in order to push the image to the dockerhub: docker push hasanalrimawi/order-management:v1.1
  *And in order to run the image -> container, after making a network within docker so that the two containers of the app and the database container can communicate: docker run --name order-management -d -e SERVER_NAME=sqlServerV --network=com -p 8080:8080 hasanalrimawi/order-management:v1.1
  *But before it, an instance of mysql container should be up and running, the following command can be used:
    "docker run --name sqlServerV -p 3306:3306 --network=com -e MYSQL_ROOT_PASSWORD=guest --mount source=myDB,target=/var/liv/mysql mysql"
  then these commands:
  "docker exec -it sqlServerV bash"
  "mysql --user=root --password=guest"
  "create database project_hasan;"



  # Usage:
  1) first you need to register a new customer.
  2) You need to authenticate the user to get the token.
  3) the preceding two points APIs are included in the postman collection
  4) The customer has been given the privilege to enter all endpoints, the better scenario is to include a manager to access the stock and products and customers management, but the UML was followed and it didn't include manager.
  5) Adding a manager entity will lead to configuring the HttpMatcher within the security configuration using the hasAuthority, and then the customer will just be given the access to register, authenticate and productOrder and order APIs only. The access to stock, product and Customer APIs should be exclusive to the manager.
