Personal Finance and Budget Tracking Application (Cash Flow/ Budget)
Adding personal habits for user spending. Hourly vs Salary Income. spring boot for Java with mobile app.


Phase 1: Problem Identification
Problem Statement
Many individuals struggle to track income, expenses, and savings in one place. Existing tools are often too complex, lack transparency, or do not provide meaningful insights into spending habits. This leads to poor budgeting, overspending, and financial stress.
Opportunity
Develop a user-friendly personal finance application that allows users to:
•	Track income and expenses
•	Create and manage budgets
•	View spending summaries
•	Securely store financial data
Target Users
•	College students
•	Working adults
•	Individuals managing personal or household finances


Phase 2: Project Requirements
Functional Requirements
•	User registration and login
•	Secure authentication (hashed passwords)
•	Add, edit, and delete income and expense entries
•	Categorize expenses (rent, food, utilities, etc.)
•	Monthly budget creation
•	Summary views (totals, remaining budget)
•	Basic charts or reports
•	In-app help/documentation section
Non-Functional Requirements
•	Secure data storage
•	Clear, intuitive UI
•	Reasonable performance with small-to-medium datasets
•	Code readability and modular design
Technology Stack (Proposed)
Platforms (Client–Server)
•	Client: Web or mobile front-end  (Android Studio Kotlin)
•	Server: Backend API (Java Spring boot)
Programming & Architecture
•	Object-Oriented Programming (classes for User, Budget, Expense, Income)
•	client-server communication
Storage
•	Relational database (MySQL)
•	OR file-based storage for backups
Security
•	Password hashing using SHA-256 or bcrypt
•	User authentication with sessions or tokens
Additional Features
•	Context-sensitive help tooltips
•	Help/About page explaining app usage
Testing Plan
Unit Testing
•	Test individual classes (User, Expense, Budget calculations)
System Testing
•	Full workflow testing (login → add expense → update budget)
Interface Testing
•	Client-server communication
•	Database read/write operations
User Testing
•	Usability testing with sample users
•	Feedback on navigation and clarity


Phase 3: Implementation
Core Modules
•	Authentication Module
•	Budget Management Module
•	Expense & Income Tracking Module
•	Reporting Module
•	Help & Documentation Module
Code Standards
•	Descriptive class and variable names
•	Clear comments where needed
•	Organized folder/package structure


Phase 4: Testing
Testing Results Documentation
•	Test cases executed
•	Pass/fail results
•	Bugs found and fixes applied
•	Any requirement changes and explanations


Phase 5: Presentation
Presentation Content
•	Problem overview
•	System architecture diagram
•	Technology choices and justification
•	Live demo of the application
•	Security implementation explanation
•	Testing summary
•	Lessons learned
GitHub & Weekly Logs
•	GitHub repository with:
o	Source code
o	Requirements documentation
o	Test plans and results
•	Weekly progress logs include:
o	Work completed
o	Challenges
o	Adjustments to timeline or scope


