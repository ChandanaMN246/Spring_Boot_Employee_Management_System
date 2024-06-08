package com.relanto.chandanaMnEMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relanto.chandanaMnEMS.entity.Department;
import com.relanto.chandanaMnEMS.repository.DepartmentRepository;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department departmentDetails) {
        Department department = departmentRepository.findById(id).orElse(null);
        if (department != null) {
            department.setDepartmentName(departmentDetails.getDepartmentName());
            return departmentRepository.save(department);
        }
        return null;
    }

    public boolean deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id).orElse(null);
        if (department != null) {
            departmentRepository.delete(department);
            return true;
        }
        return false;
    }

    public List<Department> searchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }
}
