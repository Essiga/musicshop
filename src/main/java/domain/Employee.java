package domain;

import domain.valueobjects.EmployeeId;
import lombok.Getter;

@Getter
public class Employee {

    private long id;
    private EmployeeId employeeId;
    private String name;
    private String username;

    protected Employee() {
    }

    public Employee(EmployeeId employeeId, String name, String username) {
        this.employeeId = employeeId;
        this.name = name;
        this.username = username;
    }
}
