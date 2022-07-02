package pro.sky.skyprohomew7;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<Employee, Integer> contacts = new HashMap<>();
    private int i;


    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (contacts.containsKey(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        contacts.put(employee, i);
        i++;
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (contacts.containsKey(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (contacts.containsKey(employee)) {
            contacts.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Map<Employee, Integer> printTotal() {
        return new HashMap<Employee, Integer>(contacts);
    }

}