package fullstackapp.employeeManagementSystem.services.mappers;

import fullstackapp.employeeManagementSystem.entities.Employee;
import fullstackapp.employeeManagementSystem.services.dtos.requests.AddEmployeeRequest;
import fullstackapp.employeeManagementSystem.services.dtos.requests.UpdateEmployeeRequest;
import fullstackapp.employeeManagementSystem.services.dtos.responses.AddEmployeeResponse;
import fullstackapp.employeeManagementSystem.services.dtos.responses.GetEmployeeResponse;
import fullstackapp.employeeManagementSystem.services.dtos.responses.UpdateEmployeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
    GetEmployeeResponse getResponseFromEmployee(Employee employee);

    Employee employeeFromAddRequest(AddEmployeeRequest request);

    AddEmployeeResponse addEmployeeResponse(Employee employee);

    List<GetEmployeeResponse> getResponseListFromEmployees(List<Employee> employees);

    Employee employeeFromUpdateRequest(UpdateEmployeeRequest request);

    UpdateEmployeeResponse updateResponseFromEmployee(Employee employee);
}
