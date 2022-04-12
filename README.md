# Food4U

App for ordering takeaway food

# Screenshots
![1](https://user-images.githubusercontent.com/36209711/163037933-e4de9428-a5eb-4b6e-8b23-d67d71b387a5.PNG)
![2](https://user-images.githubusercontent.com/36209711/163037975-7e270233-c3ca-4656-b07c-a23b8001f7cc.PNG)
![3](https://user-images.githubusercontent.com/36209711/163037982-a1fe1f4d-aedc-489f-8a4e-39a43838b5b9.PNG)

# System abilities
* Display available dishes to order.
* Placing orders
* Panel for Employees to display orders 
* Displaying orders based on the order status
* Change the status of an order

# Database - H2
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
