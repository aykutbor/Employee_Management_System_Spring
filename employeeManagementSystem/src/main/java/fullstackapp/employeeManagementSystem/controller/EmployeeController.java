package fullstackapp.employeeManagementSystem.controller;

import fullstackapp.employeeManagementSystem.entities.Employee;
import fullstackapp.employeeManagementSystem.repositories.EmployeeRepository;
import fullstackapp.employeeManagementSystem.services.abstracts.EmployeeService;
import fullstackapp.employeeManagementSystem.services.dtos.requests.AddEmployeeRequest;
import fullstackapp.employeeManagementSystem.services.dtos.requests.UpdateEmployeeRequest;
import fullstackapp.employeeManagementSystem.services.dtos.responses.AddEmployeeResponse;
import fullstackapp.employeeManagementSystem.services.dtos.responses.GetEmployeeResponse;
import fullstackapp.employeeManagementSystem.services.dtos.responses.UpdateEmployeeResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping
    public ResponseEntity<List<GetEmployeeResponse>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<AddEmployeeResponse> addEmployee(@RequestBody AddEmployeeRequest request) {
        AddEmployeeResponse response = employeeService.addEmployee(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping("{employeeId}")
    public ResponseEntity<GetEmployeeResponse> getEmployeeById(@PathVariable Long employeeId) {
        return new ResponseEntity<>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

    @PutMapping("{employeeId}")
    public ResponseEntity<UpdateEmployeeResponse> updateEmployee(@PathVariable Long employeeId, @RequestBody UpdateEmployeeRequest request) {
        return new ResponseEntity<>(employeeService.updateEmployee(employeeId, request), HttpStatus.OK);
    }

    @DeleteMapping("{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }


}
