package fullstackapp.employeeManagementSystem.services.dtos.responses;

import fullstackapp.employeeManagementSystem.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeResponse {

    private int id;
    private String firstName;
    private String lastName;
    private double salary;
}
