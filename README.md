Finance and Budgeting Database
Overview
This application is a full-stack mobile app built with a Spring Boot backend, a MySQL database, and an Android (Kotlin) frontend. The app allows users to track income, manage expenses, and organize personal financial data for budgeting purposes.
________________________________________
Tech Stack
•	Backend: Java, Spring Boot (IntelliJ)
•	Database: MySQL
•	Frontend: Android Studio (Kotlin)
•	Version Control: GitHub
________________________________________
Prerequisites
Make sure the following are installed:
•	Java JDK 21 
•	IntelliJ IDEA (recommended for backend)
•	MySQL (or MAMP/XAMPP)
•	Android Studio
•	Git
________________________________________
Project Setup Instructions
1. Clone the Repository
git clone https://github.com/vinfaldetta/CSIS3126_FALDETTA.git 
cd FinanceProject
________________________________________
2. Set Up the Database
1.	Start MySQL
2.	Create a new database:
CREATE DATABASE financeandbudgetingdb ;
3.	Import the SQL dump file provided in the repository:
mysql -u root -p financeandbudgetingdb < financeandbudgetingdb.sql
OR use a GUI like phpMyAdmin or MySQL Workbench:
•	Open the database
•	Import. Financeandbudgetingdb.sql
________________________________________
3. Configure Backend (Spring Boot)
Navigate to the backend project folder and open it in IntelliJ.
Update application.properties (or application.yml)
spring.datasource.url=jdbc:mysql://localhost:3306/myapp
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
server.port=8080
________________________________________
4. Run the Backend Server
In IntelliJ:
•	Open the Spring Boot project
•	Locate the main class (with @SpringBootApplication)
•	Click Run
OR via terminal:
./mvnw spring-boot:run
Backend will run at:
http://localhost:8080
________________________________________
5. Run the Android App
1.	Open Android Studio
2.	Select Open Project
3.	Choose the mobile (or Android) folder
4.	Let Gradle sync complete
Connect to Backend
In your Kotlin code, ensure the base API URL is set:
•	Emulator:
http://10.0.2.2:8080
•	Real Android device:
http://<your-computer-ip>:8080
________________________________________
Run the App
•	Start an emulator OR connect a physical device
•	Click Run in Android Studio
________________________________________
Important Notes
•	The backend must be running before launching the Android app
•	The database must be set up before starting the backend
•	API URLs must match your environment (emulator vs real device)
________________________________________
Troubleshooting
Backend won’t start
•	Check Java version higher than 21 jdk version didn’t run with spring boot
•	Ensure dependencies are installed (Maven/Gradle)
Database connection error
•	Verify database exists
•	Check username/password in application.properties
Android app cannot connect
•	Ensure backend is running
________________________________________
Files Included
•	Full source code (backend + Android app)
•	financeandbudgetingdb.sql (database schema and data)


