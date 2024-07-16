package fullstackapp.employeeManagementSystem.repositories;

import aj.org.objectweb.asm.commons.Remapper;
import fullstackapp.employeeManagementSystem.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {





}
