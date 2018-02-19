# stocks-manager
Challenge App for Payconiq to demonstrates a stocks manager using Spring Boot, JPA, Web(thymeleaf) and Restful Services.

### Installation

This app requires [Maven](https://maven.apache.org/download.cgi) to build, run and deploy.

Clone this app, install the dependencies and start the server.

```sh
$ git clone https://github.com/rodrigovsilva/stocks-manager.git
$ cd stocks-manager
$ mvn spring-boot:run
```

Open in your browser (http://localhost:8080) to see the Stocks Prices list.


### Stocks API

If you want to access the API resources, use the mapping listed below.

- Get All Stocks  
URL: http://localhost:8080/api/stocks  
Method: GET  

- Find a Stock by id  
URL: http://localhost:8080/api/stocks/{id}  
Method: GET  

- Create Stock  
URL: http://localhost:8080/api/stocks  
Method: POST  
Body: ```
{
	"name":"CSCO",
	"currentPrice": 50.50
}```

- Update Stock Price by Id  
URL: http://localhost:8080/api/stocks/{id}  
Method: PUT  
Body: ```
{
	"currentPrice": 40.54
}```

- Delete Stock by Id  
URL: http://localhost:8080/api/stocks/{id}  
Method: DELETE  


### H2 Database Console

To access h2 console, open the url http://localhost:8080/h2-console/

Driver Class: org.h2.Driver
JDBC Url: jdbc:h2:mem:testdb
User Name: sa
You don't need password to access this database. Let the field empty.


### Contact

If you have some doubts about this project, please send me a message. 

Thanks
