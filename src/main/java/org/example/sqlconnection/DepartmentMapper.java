package org.example.sqlconnection;

import java.util.List;

public interface DepartmentMapper {
    Department findById(int id);
    List<Department> findAll();
    void save(Department department);
    void update(Department department);
    void delete(Department department);
}
