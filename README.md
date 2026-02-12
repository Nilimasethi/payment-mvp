This is a full-stack payment processing application built using:



Backend: Spring Boot + SQLite



Frontend: Angular



Database: SQLite (file-based)



It supports payment submission with validation and stores records in database.



Technology Stack
--------------------

Backend



Java 17



Spring Boot



Spring Data JPA



Hibernate Validator



SQLite



Lombok



Frontend

\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_



Angular 21



TypeScript



Reactive Forms



HTTP Client



📂 Project Structure

payment-mvp/

&nbsp;├── backend/     → Spring Boot Application

&nbsp;├── frontend/    → Angular Application

&nbsp;└── README.md



&nbsp;Setup Instructions

\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_

1. Backend Setup



Go to backend folder:



cd backend





Run backend:



mvn spring-boot:run or In IntelliJ -> open Terminal \& run maven clean install



Backend runs on:



http://localhost:8080



2\.  Frontend Setup



Go to frontend:



cd frontend





Install dependencies:



npm install





Run Angular:



ng serve





Frontend runs on:



http://localhost:4200



3\. API Documentation

-> Create Payment



POST /api/payment



Request:



{

&nbsp; "name": "John Doe",

&nbsp; "email": "john@gmail.com",

&nbsp; "contact": "9876543210",

&nbsp; "amount": "1500.00"

}





Response (Success):



{

&nbsp; "success": true,

&nbsp; "message": "Payment processed successfully",

&nbsp; "paymentId": 1,

&nbsp; "status": "success"

}



-> Get All Payments



GET /api/payments



Response:



\[

&nbsp; {

&nbsp;   "id": 1,

&nbsp;   "name": "John Doe",

&nbsp;   "email": "john@gmail.com",

&nbsp;   "contact": "9876543210",

&nbsp;   "amount": 1500.00,

&nbsp;   "status": "success"

&nbsp; }

]



-> Validation Errors Example

{

&nbsp; "success": false,

&nbsp; "errors": {

&nbsp;   "name": "Name must be 3 to 50 characters",

&nbsp;   "email": "Invalid email format",

&nbsp;   "contact": "Contact must be exactly 10 digits"

&nbsp; }

}



🗄️ Database Schema



Table: payments



Field	Type	Description

id	Long	Primary Key

name	String	User Name

email	String	Email

contact	String	Phone

amount	Decimal	Amount

status	String	Status

created\_at	Timestamp	Created Time



SQLite file: payments.db



\# Backend Config

=======================

DB\_URL=jdbc:sqlite:payments.db

SERVER\_PORT=8080



\# Frontend

API\_URL=http://localhost:8080/api



-> Security



Input Validation



CORS Enabled



Basic Sanitization



JWT was not implemented it is optional and i was running out of time.





Thank You .

Nilima Sethi



