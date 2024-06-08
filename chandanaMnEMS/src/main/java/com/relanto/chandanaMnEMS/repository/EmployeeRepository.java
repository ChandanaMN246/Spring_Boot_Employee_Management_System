package com.relanto.chandanaMnEMS.repository;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
 
import com.relanto.chandanaMnEMS.entity.Employee;
 
//EmployeeRepository.java
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
		List<Employee> findByEmployeeMobile(String employeeMobile);
    // Search by employee email
    List<Employee> findByEmployeeEmail(String employeeEmail);
    
    // Search by department name
    @Query("SELECT e FROM Employee e JOIN Department d ON e.employeeDepartmentId = d.departmentId WHERE d.departmentName = :departmentName")
    List<Employee> findByDepartmentName(@Param("departmentName") String departmentName);
    
    // Search by city name
    @Query("SELECT e FROM Employee e JOIN City c ON e.employeeCityId = c.cityId WHERE c.cityName = :cityName")
    List<Employee> findByCityName(@Param("cityName") String cityName);
}