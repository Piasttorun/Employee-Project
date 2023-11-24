package com.sparta.jupiter;

import com.sparta.jupiterJazz.Employee;
import com.sparta.jupiterJazz.Validator.EmployeeValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class EmployeeValidationTest {

    @Test
    @DisplayName("Test invalid employee ID")
    public void testInvalidEmployeeID() {
        Employee employee = new Employee(
                "123456789", "Mr.",
                "Harry", 'E',
                "Smith", 'M',
                "harrysmith@yahoo.com",
                new Date(1999/9/10), new Date(2022/6), 24000);
        Assertions.assertFalse(EmployeeValidation.validateEmployee(employee));
    }

    @Test
    @DisplayName("Test valid employee ID")
    public void testValidEmployeeID() {
        Employee employee = new Employee(
                "12345678", "Mr.",
                "Harry", 'E',
                "Smith", 'M',
                "harrysmith@yahoo.com",
                new Date(1999/9/10), new Date(2022/6), 24000);
        Assertions.assertTrue(EmployeeValidation.validateEmployee(employee));
    }

    @Test
    @DisplayName("Test invalid first name")
    public void testInvalidFirstName(){
        Employee employee = new Employee("12345677",
                "Mrs", "", 'A',
                "Smith", 'F',
                "bbh@yahoo.com", new Date(1993/5/23), new Date(2002/3/11), 40500);
        Assertions.assertFalse(EmployeeValidation.validateEmployee(employee));
    }

    @Test
    @DisplayName("Test valid first name")
    public void testValidFirstName(){
        Employee employee = new Employee("12345677",
                "Mrs", "Marie", 'A',
                "Smith", 'F',
                "bbh@yahoo.com", new Date(1993/5/23), new Date(2002/3/11), 40500);
        Assertions.assertTrue(EmployeeValidation.validateEmployee(employee));
    }

    @Test
    @DisplayName("Test invalid middle name initial")
    public void testInvalidMiddleNameInitial(){
        Employee employee = new Employee("12345677",
                "Mrs", "Marie", '2',
                "Branha", 'F',
                "bbh@yahoo.com", new Date(1993/5/23), new Date(2002/3/11), 40500);
        Assertions.assertFalse(EmployeeValidation.validateEmployee(employee));
    }

    @Test
    @DisplayName("Test valid middle name initial")
    public void testValidMiddleNameInitial(){
        Employee employee = new Employee("12345677",
                "Mrs", "Marie", 'A',
                "Branha", 'F',
                "bbh@yahoo.com", new Date(1993/5/23), new Date(2002/3/11), 40500);
        Assertions.assertTrue(EmployeeValidation.validateEmployee(employee));
    }

    @Test
    @DisplayName("Test invalid last name")
    public void testNullLastName(){
        Employee employee = new Employee("12345677",
                "Mrs", "Marie", 'A',
                "", 'F',
                "bbh@yahoo.com", new Date(1993/5/23), new Date(2002/3/11), 40500);
        Assertions.assertFalse(EmployeeValidation.validateEmployee(employee));
    }

    @Test
    @DisplayName("Test valid last name")
    public void testLastName(){
        Employee employee = new Employee("12345677",
                "Mrs", "Marie", 'A',
                "Branha", 'F',
                "bbh@yahoo.com", new Date(1993/5/23), new Date(2002/3/11), 40500);
        Assertions.assertTrue(EmployeeValidation.validateEmployee(employee));
    }

    @Test
    @DisplayName("Test invalid employee gender")
    public void testInvalidEmployeeGender() {
        Employee employee = new Employee(
                "12345678", "Mr.",
                "Harry", 'E',
                "Smith", 'B',
                "harrysmith@yahoo.com",
                new Date(1999/9/10), new Date(2022/6), 24000);
        Assertions.assertFalse(EmployeeValidation.validateEmployee(employee));
    }

    @Test
    @DisplayName("Test valid employee gender")
    public void testValidEmployeeGender() {
        Employee employee = new Employee(
                "12345678", "Mr.",
                "Harry", 'E',
                "Smith", 'M',
                "harrysmith@yahoo.com",
                new Date(1999/9/10), new Date(2022/6), 24000);
        Assertions.assertTrue(EmployeeValidation.validateEmployee(employee));
    }

    @Test
    @DisplayName("Test invalid email")
    public void testInvalidEmail(){
        Employee employee = new Employee("12345678",
                "Miss", "Andra", 'S',
                "Abell", 'F',
                "andradayahoo.com", new Date(1987/3/12), new Date(1999/10/2), 40000);
        Assertions.assertFalse(EmployeeValidation.validateEmployee(employee));
    }

    @Test
    @DisplayName("Test valid email")
    public void testValidEmployee(){
        Employee employee = new Employee("12345678",
                "Miss", "Andra", 'S',
                "Abell", 'F',
                "an.drada@yahoo.com", new Date(1987/3/12), new Date(1999/10/2), 40000);
        Assertions.assertTrue(EmployeeValidation.validateEmployee(employee));
    }

    @Test
    @DisplayName("Test invalid DOB")
    public void testInvalidDOB() {
        Employee employee = new Employee(
                "12345678", "Mr.",
                "Harry", 'E',
                "Smith", 'M',
                "harrysmith@yahoo.com",
                new Date(), new Date(2022/6), 24000);
        Assertions.assertFalse(EmployeeValidation.validateEmployee(employee));
    }

    @Test
    @DisplayName("Test valid employee gender")
    public void testValidDOB() {
        Employee employee = new Employee(
                "12345678", "Mr.",
                "Harry", 'E',
                "Smith", 'M',
                "harrysmith@yahoo.com",
                new Date(1999/9/10), new Date(2022/6), 24000);
        Assertions.assertTrue(EmployeeValidation.validateEmployee(employee));
    }

    @Test
    @DisplayName("Test invalid DOJ")
    public void testInvalidDOJ() {
        Employee employee = new Employee(
                "12345678", "Mr.",
                "Harry", 'E',
                "Smith", 'M',
                "harrysmith@yahoo.com",
                new Date(1999/9/10), new Date(), 0);
        Assertions.assertFalse(EmployeeValidation.validateEmployee(employee));
    }

    @Test
    @DisplayName("Test invalid employee DOJ")
    public void testValidDOJ() {
        Employee employee = new Employee(
                "12345678", "Mr.",
                "Harry", 'E',
                "Smith", 'M',
                "harrysmith@yahoo.com",
                new Date(1999/9/10), new Date(2022/6), 24000);
        Assertions.assertTrue(EmployeeValidation.validateEmployee(employee));
    }

    @Test
    @DisplayName("Test invalid employee salary")
    public void testInvalidEmployeeSalary() {
        Employee employee = new Employee(
                "12345678", "Mr.",
                "Harry", 'E',
                "Smith", 'M',
                "harrysmith@yahoo.com",
                new Date(1999/9/10), new Date(2022/6), -20);
        Assertions.assertFalse(EmployeeValidation.validateEmployee(employee));
    }

    @Test
    @DisplayName("Test valid employee salary")
    public void testValidEmployeeSalary() {
        Employee employee = new Employee(
                "12345678", "Mr.",
                "Harry", 'E',
                "Smith", 'M',
                "harrysmith@yahoo.com",
                new Date(1999/9/10), new Date(2022/6), 24000);
        Assertions.assertTrue(EmployeeValidation.validateEmployee(employee));
    }

    @Test
    @DisplayName("Test invalid employee born before job")
    public void testInvalidEmployeeBornBeforeJob() {
        Employee employee = new Employee(
                "12345678", "Mr.",
                "Harry", 'E',
                "Smith", 'M',
                "harrysmith@yahoo.com",
                new Date(2022/9/10), new Date(2022/6/23), 24000);
        Assertions.assertFalse(EmployeeValidation.validateEmployee(employee));
    }

}
