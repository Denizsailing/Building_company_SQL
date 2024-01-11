package org.example.sqlconnection;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

@Mapper
public interface DepartmentDAO extends DepartmentMapper {

    @Override
    @Select("SELECT * FROM Department WHERE department_id = #{id}")
    Department findById(@Param("id") int id);

    @Override
    @Select("SELECT * FROM Department")
    List<Department> findAll();

    @Override
    @Insert("INSERT INTO Department (department_id, department_name) VALUES (#{departmentId}, #{departmentName})")
    void save(Department department);

    @Override
    @Update("UPDATE Department SET department_name = #{departmentName} WHERE department_id = #{departmentId}")
    void update(Department department);

    @Override
    @Delete("DELETE FROM Department WHERE department_id = #{departmentId}")
    void delete(Department department);
}
