package org.example.sqlconnection;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    void saveDepartment(Department department);
    void updateDepartment(Department department);
    void deleteDepartment(Department department);
}
