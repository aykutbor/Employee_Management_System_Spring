package fullstackapp.employeeManagementSystem.services.abstracts;

import fullstackapp.employeeManagementSystem.entities.Employee;
import fullstackapp.employeeManagementSystem.services.dtos.requests.AddEmployeeRequest;
import fullstackapp.employeeManagementSystem.services.dtos.requests.UpdateEmployeeRequest;
import fullstackapp.employeeManagementSystem.services.dtos.responses.AddEmployeeResponse;
import fullstackapp.employeeManagementSystem.services.dtos.responses.GetEmployeeResponse;
import fullstackapp.employeeManagementSystem.services.dtos.responses.UpdateEmployeeResponse;

import java.util.List;

public interface EmployeeService {

    List<GetEmployeeResponse> getAllEmployees();

    AddEmployeeResponse addEmployee(AddEmployeeRequest request);

    GetEmployeeResponse getEmployeeById(Long employeeId);

    UpdateEmployeeResponse updateEmployee(Long employeeId, UpdateEmployeeRequest request);

    Employee getEmployeeExistById(Long employeeId);

    void deleteEmployee(Long employeeId);


}
