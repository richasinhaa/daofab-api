## DAOFAB Hiring Assignment

# Developed using Java, SpringBoot framework, Spring Data, Maven dependency manager and Mysql database

This assignment consists of two accompanying JSON files (Parent.Json and Child.Json) containing JSON data. 

# Task 1 : to create a table to display all the parent transactions (contained in Parent.Json)
Implement a REST API to fetch data build server-side pagination. Each page should display 2 rows (with a pageSize of 2) and be capable of being sorted by the parent id. 

# Task 2 : When the user clicks, Total Paid Amount, display a new page and populate the corresponding children (installment) data. - Only backend Implementation
Implement a REST API to fetch child data. 

## Technology Stack

* Java
* Spring Boot
* Spring-data-jpa
* Maven
* Mysql

### Installation

* Install Java
* Install Maven
* Install Mysql (configuration details : src/main/resources/application.properties)
* Import project in IDE
* Build the project

## Running the application

mvn spring-boot:run

## What happens when the application runs
1. Creates daofab_db1 database if it doesn't exist
2. Creates parent and child if they don't exist
3. Populates parent and child tables

## Rest api end points
  # Task 1 : [http://localhost:8080]/parents/list?pageNo=0&pageSize=2&sortBy=id
  
  <img width="598" alt="Screenshot 2021-07-30 at 1 04 47 PM" src="https://user-images.githubusercontent.com/45893103/127603194-eac12d7e-0362-41aa-978b-d1afa4a35ab9.png">  
  
  # Task 2 : [http://localhost:8080]/children/list

<img width="399" alt="Screenshot 2021-07-30 at 12 52 30 PM" src="https://user-images.githubusercontent.com/45893103/127603211-439b8d0f-ae20-46bf-bfc1-3d5eecc1483c.png">

