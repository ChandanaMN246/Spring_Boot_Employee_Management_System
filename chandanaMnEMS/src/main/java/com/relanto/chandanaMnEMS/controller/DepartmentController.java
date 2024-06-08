package com.relanto.chandanaMnEMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.relanto.chandanaMnEMS.entity.Department;
import com.relanto.chandanaMnEMS.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    
    @GetMapping("/hellow")
   	public String hellow (){
   		return "Hello World!";
   	}


    @GetMapping("/list-department")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/create-department")
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("/update-department/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) {
        return departmentService.updateDepartment(id, departmentDetails);
    }

    @DeleteMapping("/delete-department/{id}")
    public boolean deleteDepartment(@PathVariable Long id) {
        return departmentService.deleteDepartment(id);
    }

    @GetMapping("/search/{departmentName}")
    public List<Department> searchDepartmentByName(@PathVariable String departmentName) {
        return departmentService.searchDepartmentByName(departmentName);
    }
}
