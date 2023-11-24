# Employee Project

Purpose of the probject is to via OOP methods and design principles, create a program thart reads employees from an CSV file and outputs them if they meet certain valdiation criteria. 

## Valdiation crtieria:
  - `Emp ID`(up to 8 digits)
  - `Prefix` 
  - `First Name` 
  - `Middle Initial`  
  - `Last Name`
  - `Gender` (stored as M or F)
  - `E Mail` (in standard email format)
  - `Date of Birth` (`YYYY-MM-DD` calendar date format)
  - `Date of Joining` (`YYYY-MM-DD` calendar date format)  
  - `Salary` 

## You can search employees by:
  - Search for employee by `Emp ID`
  - Search for employees by `Last Name` (partial match)
  - Search for employees hired within a date range
  - Search for employees by age range

## Employee project classes include:

  - Employee
  - EmployeeDAO
  - EmployeeDTO
  - EmployeeValidator
  - EmployeeDTOCreator
  - EmployeeFactor
  - EmployeeMappedUtility
  - App (main)


## Employee
## EmployeeDAO
Consists of methods in order to collect data from the DTO assuming that the data fits certain validation criteria specified by the user.
## EmployeeDTO
Consists of getters and setters to fulfill the requirements of the DTO design pattern.
## EmployeeValidator
The code has methods, including validateEmployee, that ensure various criteria for employee attributes, like proper ID format, non-empty names, valid gender, correct email format, non-null birth and joining dates, positive salary, and chronological date order, using the Employee class and Date class for date operations.
## EmployeeDTOCreator
Designed to create an ArrayList of validated Employee objects. It utilizes the EmployeeValidation class to ensure that the employee data is accurate and follows specified criteria.
## EmployeeFactor
## EmployeeMappedUtility
## App (main)
Below the class diagram is presented:
Link: https://app.diagrams.net/#G1an8QKqXIvLaBYm3ER8LPloE6rAN1OMA0
![image](https://github.com/Piasttorun/Employee-Project/assets/91672079/2c740fad-b8fe-41d1-8fb4-6e3e1a0b852f)


  
