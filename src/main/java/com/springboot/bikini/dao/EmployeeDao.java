package com.springboot.bikini.dao;

import com.springboot.bikini.model.EmployeeDomain;
import com.springboot.bikini.sql.EmployeeSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface EmployeeDao {
    @InsertProvider(type= EmployeeSqlProvider.class, method = "insertEmployee")
    public int insertEmployee(EmployeeDomain record);

    public int deleteEmployee(int EmployeeId);

    @UpdateProvider(type=EmployeeSqlProvider.class,method="updateEmployee")
    public int updateEmployee(EmployeeDomain employeeDomain);

    public EmployeeDomain selectByEmployeeId(@Param("employeeId") int employeeId);
    public List<EmployeeDomain> selectAllEmployee();

    @SelectProvider(type = EmployeeSqlProvider.class, method = "selectByEmployeeTel")
    public EmployeeDomain selectByEmployeeTel(@Param("employeeTel") String employeeTel);

    @SelectProvider(type = EmployeeSqlProvider.class, method = "selectCountEmployeeByTel")
    int selectCountEmployeeByTel(@Param("employeeTel") String employeeTel);
}
