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

- Create Stock
URL: http://localhost:8080/api/stocks
Method: POST
Body: 
