# Food4U

App for ordering takeaway food

# System abilities
* Display available dishes to order.
* Placing orders
* Panel for Employees to display orders 
* Displaying orders based on the order status
* Change the status of an order

#Database - H2
Database works on `localhost:8080/h2-console` and JDBC URL: `jdbc:h2:mem:test`
User name: `sa` and no password
All configurations with the database are in the `application.properties` file.
Data are loaded from data.sql

# Setup
Clone this repo to your desktop. Run applications using Spring Boot. You will then be able to access it at `localhost:8080`.

# Project is created with
* Java 11
* Spring Boot
* Spring Data JPA
* Spring Web
* Thymeleaf
* Maven
* H2
* Bootstrap
