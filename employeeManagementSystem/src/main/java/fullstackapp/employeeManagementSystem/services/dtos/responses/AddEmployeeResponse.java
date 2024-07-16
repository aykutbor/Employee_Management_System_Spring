package fullstackapp.employeeManagementSystem.services.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeResponse {

    private int id;
    private String firstName;
    private String lastName;
    private double salary;
}
