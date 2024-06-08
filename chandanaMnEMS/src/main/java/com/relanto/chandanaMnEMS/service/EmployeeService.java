package com.relanto.chandanaMnEMS.service;
import com.relanto.chandanaMnEMS.entity.City;
import com.relanto.chandanaMnEMS.entity.Department;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.relanto.chandanaMnEMS.entity.Department;
import com.relanto.chandanaMnEMS.entity.Employee;
import com.relanto.chandanaMnEMS.repository.EmployeeRepository;
 
import java.util.List;
import java.util.Optional;
 
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CityService cityService;
    @Autowired
    private DepartmentService departmentService;
    // Create
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
 
    // Read
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    // Update
   public Employee updateEmployee(Long id, Employee employee) {
        if (employeeRepository.existsById(id)) {
        	
        	employee.setEmployeeId(id);
        }
        return employeeRepository.save(employee);
    }
    // Delete
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
  
// Search by mobile
//    public List<Employee> findByEmployeeMobile(String employeeMobile) {
//        return employeeRepository.findByEmployeeMobile(employeeMobile);
//    }
    public List<Employee> findByEmployeeMobile(String employeeMobile) {
        List<Employee> employees = employeeRepository.findByEmployeeMobile(employeeMobile);
        for (Employee employee : employees) {
            City city = cityService.getCityById(employee.getEmployeeCityId()); // Get city information
            Department department=departmentService.getDepartmentById(employee.getEmployeeDepartmentId());
            employee.setCityName(city.getCityName()); // Set city name
            employee.setCityCode(city.getCityCode()); // Set city code
            employee.setDepartmentName(department.getDepartmentName());
        }
        return employees;
    }
    
    // Search by email
    public List<Employee> findByEmployeeEmail(String employeeEmail) {
       return employeeRepository.findByEmployeeEmail(employeeEmail);
//    	 List<Employee> employees = employeeRepository.findByEmployeeMobile(employeeEmail);
//         for (Employee employee : employees) {
//             City city = cityService.getCityById(employee.getEmployeeCityId()); // Get city information
//             Department department=departmentService.getDepartmentById(employee.getEmployeeDepartmentId());
//             if (city != null) {
//                 employee.setCityName(city.getCityName());
//                 employee.setCityCode(city.getCityCode());
//             }
//             if (department != null) {
//                 employee.setDepartmentName(department.getDepartmentName());
//             }
//         }
//         return employees;
    }
    
    // Search by department name
    public List<Employee> findByDepartmentName(String departmentName) {
       return employeeRepository.findByDepartmentName(departmentName);
//    	List<Employee> employees = employeeRepository.findByEmployeeMobile(departmentName);
//        for (Employee employee : employees) {
//            City city = cityService.getCityById(employee.getEmployeeCityId()); // Get city information
//            Department department=departmentService.getDepartmentById(employee.getEmployeeDepartmentId());
//            employee.setCityName(city.getCityName()); // Set city name
//            employee.setCityCode(city.getCityCode()); // Set city code
//            employee.setDepartmentName(department.getDepartmentName());
//        }
//        return employees;
    }
    
    // Search by city name
    public List<Employee> findByCityName(String cityName) {
        return employeeRepository.findByCityName(cityName);
    }
    
}