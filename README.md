# Fruit price microservices

## Fruit price service

This service talks directly to the database to get the monthly price per kg of a fruit.

- Get all fruits:
  - `/fruit-price/fruits`
  - returns an array of fruit names. 

- Get monthly fruit price per kg: 
  - `/fruit-price/fruit/{fruit}/month/{3-letter month abbreviation}`
  - returns `{"id":1000,"fruit":"apricot","month":"jan","fmp":"8.51", "environment":"8000"}`.


## Fruit total service

This service calculates the total price of an order based on the monthly price fetched from the fruit price service and the quantity requested.

- Get price of fruit order:
  - `/fruit-total/fruit/{fruit}/month/{3-letter month abbreviation}/quantity/{number of kgs}`
  - returns `{"id":1000,"fruit":"apricot","month":"jan","fmp":8.51,"quantity":5,"total":"42.55","environment":"8100"}`

## Local Development

### Using maven and spring-boot.

1. cd `fruit-month-price-service`
2. `./mvnw spring-boot:rungit status`
3. Access the service on localhost using port 8000

1. cd `fruit-total-price-service`
2. `./mvnw spring-boot:rungit status`
3. Access the service on localhost using port 8100

### Using Docker Compose

1. `docker-compose up --build -d`
2. Access the services on localhost using ports 8000 and 8100

### Optional frontend

Two ways to run the frontend:
- By simply opening the `./frontend/index.html` file directly in a browser.
- Through docker `docker-compose up --build -d frontend`.
