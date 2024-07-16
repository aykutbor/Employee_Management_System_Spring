package fullstackapp.employeeManagementSystem.services.concretes;

import fullstackapp.employeeManagementSystem.entities.Employee;
import fullstackapp.employeeManagementSystem.exceptions.ResourceNotFoundException;
import fullstackapp.employeeManagementSystem.repositories.EmployeeRepository;
import fullstackapp.employeeManagementSystem.services.abstracts.EmployeeService;
import fullstackapp.employeeManagementSystem.services.dtos.requests.AddEmployeeRequest;
import fullstackapp.employeeManagementSystem.services.dtos.requests.UpdateEmployeeRequest;
import fullstackapp.employeeManagementSystem.services.dtos.responses.AddEmployeeResponse;
import fullstackapp.employeeManagementSystem.services.dtos.responses.GetEmployeeResponse;
import fullstackapp.employeeManagementSystem.services.dtos.responses.UpdateEmployeeResponse;
import fullstackapp.employeeManagementSystem.services.mappers.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    @Override
    public List<GetEmployeeResponse> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(EmployeeMapper.INSTANCE::getResponseFromEmployee)
                .collect(Collectors.toList());
    }

    @Override
    public AddEmployeeResponse addEmployee(AddEmployeeRequest request) {
        Employee employee = EmployeeMapper.INSTANCE.employeeFromAddRequest(request);

        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.INSTANCE.addEmployeeResponse(savedEmployee);

    }

    @Override
    public GetEmployeeResponse getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id " + employeeId));
        return EmployeeMapper.INSTANCE.getResponseFromEmployee(employee);
    }

    @Override
    public UpdateEmployeeResponse updateEmployee(Long employeeId, UpdateEmployeeRequest request) {
       Employee foundEmployee = getEmployeeExistById(employeeId);
        if (foundEmployee == null || !foundEmployee.getId().equals(employeeId)){
            throw new RuntimeException("Employee not found or ID mismatch");
        }
        //Employee updatedEmployee = EmployeeMapper.INSTANCE.employeeFromUpdateRequest(request);
        foundEmployee.setFirstName(request.getFirstName());
        foundEmployee.setLastName(request.getLastName());
        foundEmployee.setSalary(request.getSalary());
        Employee savedEmployee = employeeRepository.save(foundEmployee);
        return EmployeeMapper.INSTANCE.updateResponseFromEmployee(savedEmployee);

    }

    @Override
    public Employee getEmployeeExistById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(()-> new RuntimeException("Deneme"));
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee foundEmployee = getEmployeeExistById(employeeId);
        if (foundEmployee == null || !foundEmployee.getId().equals(employeeId)){
            throw new RuntimeException("Employee not found or ID mismatch");
        }
        employeeRepository.deleteById(foundEmployee.getId());

    }


}
