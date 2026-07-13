package com.arun.cucumber.stepdefs;

import com.arun.cucumber.employee.Employee;
import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;

import java.util.List;

public class EmployeeSteps implements En {
    public EmployeeSteps() {
        Given("user wants to create an employee with the following attributes", (DataTable dataTable) -> {
            List<Employee> employees = dataTable.asList(Employee.class);
            employees.forEach(employee -> System.out.println(employee.getFirstName()));
        });

        Given("with the following phone numbers", (io.cucumber.datatable.DataTable dataTable) -> {
            // Write code here that turns the phrase above into concrete actions
            // For automatic transformation, change DataTable to one of
            // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
            // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
            // Double, Byte, Short, Long, BigInteger or BigDecimal.
            //
            // For other transformations you can register a DataTableType.
            throw new cucumber.api.PendingException();
        });

        When("user saves the new employee {string}", (String string) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new cucumber.api.PendingException();
        });

        Then("the save {string}", (String string) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new cucumber.api.PendingException();
        });

    }
}
