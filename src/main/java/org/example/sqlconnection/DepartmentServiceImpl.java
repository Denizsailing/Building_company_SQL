package org.example.sqlconnection;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentDAO departmentDAO;

    public DepartmentServiceImpl(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }


    @Override
    public List<Department> getAllDepartments() {
        return departmentDAO.findAll();
    }

    @Override
    public void saveDepartment(Department department) {
        departmentDAO.save(department);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentDAO.update(department);
    }

    @Override
    public void deleteDepartment(Department department) {
        departmentDAO.delete(department);
    }
}
