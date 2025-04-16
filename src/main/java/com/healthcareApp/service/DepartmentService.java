package com.healthcareApp.service;


import com.healthcareApp.model.Department;
import com.healthcareApp.repository.DepartmentRepository;

import java.sql.SQLException;
import java.util.List;

public class DepartmentService {

    private static final DepartmentRepository departmentRepository = new DepartmentRepository();

    public boolean insertDepartment(Department department) throws SQLException {
        return departmentRepository.createDepartment(department);
    }

    public List<Department> displayDepartment() throws SQLException {
        return departmentRepository.displayDepartment();
    }

    public boolean updateDepartment(int deptId,String deptName) throws SQLException {
        return departmentRepository.updateDepartment(deptId,deptName);
    }

    public boolean deleteDepartment(int deptId) throws SQLException {
        return departmentRepository.deleteDepartment(deptId);
    }
}
