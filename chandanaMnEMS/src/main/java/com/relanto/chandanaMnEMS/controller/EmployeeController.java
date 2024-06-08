package com.relanto.chandanaMnEMS.controller;
import com.relanto.chandanaMnEMS.entity.City;
import com.relanto.chandanaMnEMS.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import com.relanto.chandanaMnEMS.entity.Employee;
import com.relanto.chandanaMnEMS.service.EmployeeService;
 
import java.util.List;
import com.relanto.chandanaMnEMS.entity.City;
import com.relanto.chandanaMnEMS.service.CityService;
import com.relanto.chandanaMnEMS.entity.Department;
import com.relanto.chandanaMnEMS.service.DepartmentService;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CityService cityService;
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/hellow")
	public String hellow (){
		return "Hello World!";
	}
 
    // Create
    @PostMapping("/create-employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
 
    // Read
    @GetMapping("/list-employee")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
 
   // Update
   @PutMapping("/update-employee/{id}")
   public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
	   return employeeService.updateEmployee(id, employee);
   }
    // Delete
    @DeleteMapping("delete-employee/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
    @GetMapping("/search-by-mobile/{mobile}")
//    public List<Employee> searchByMobile(@PathVariable String mobile) {
//        return employeeService.findByEmployeeMobile(mobile);
//    }
    public List<Employee> searchByMobile(@PathVariable String mobile) {
        List<Employee> employees = employeeService.findByEmployeeMobile(mobile);
        for (Employee employee : employees) {
            City city = cityService.getCityById(employee.getEmployeeCityId());// Get city information
            Department department=departmentService.getDepartmentById(employee.getEmployeeDepartmentId());
            employee.setCityName(city.getCityName()); // Set city name
            employee.setCityCode(city.getCityCode()); // Set city code
            employee.setDepartmentName(department.getDepartmentName());
        }
        return employees;
    }
 
    // Search by email
    @GetMapping("/search-by-email/{email}")
    public List<Employee> searchByEmail(@PathVariable String email) {
      return employeeService.findByEmployeeEmail(email);
//    	List<Employee> employees = employeeService.findByEmployeeMobile(email);
//        for (Employee employee : employees) {
//            City city = cityService.getCityById(employee.getEmployeeCityId());// Get city information
//            Department department=departmentService.getDepartmentById(employee.getEmployeeDepartmentId());
//            employee.setCityName(city.getCityName()); // Set city name
//            employee.setCityCode(city.getCityCode()); // Set city code
//            employee.setDepartmentName(department.getDepartmentName());
//        }
//        return employees;
    }
    
    // Search by department name
    @GetMapping("/search-by-department/{departmentName}")
    public List<Employee> searchByDepartmentName(@PathVariable String departmentName) {
      return employeeService.findByDepartmentName(departmentName);
//    	List<Employee> employees = employeeService.findByEmployeeMobile(departmentName);
//        for (Employee employee : employees) {
//            City city = cityService.getCityById(employee.getEmployeeCityId());// Get city information
//            Department department=departmentService.getDepartmentById(employee.getEmployeeDepartmentId());
//            employee.setCityName(city.getCityName()); // Set city name
//            employee.setCityCode(city.getCityCode()); // Set city code
//            employee.setDepartmentName(department.getDepartmentName());
//        }
//        return employees;
    }
    
    // Search by city name
    @GetMapping("/search-by-city/{cityName}")
    public List<Employee> searchByCityName(@PathVariable String cityName) {
        return employeeService.findByCityName(cityName);
    }
}