package com.springboot.bikini.dao;

import com.springboot.bikini.model.EmployeeDomain;
import com.springboot.bikini.sql.EmployeeSqlProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
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

    public EmployeeDomain selectByEmployeeId(int employeeId);
    public List<EmployeeDomain> selectAllEmployee();

    @SelectProvider(type = EmployeeSqlProvider.class, method = "selectByEmployeeTel")
    public EmployeeDomain selectByEmployeeTel(String employeeTel);

    @SelectProvider(type = EmployeeSqlProvider.class, method = "selectCountEmployeeByTel")
    int selectCountEmployeeByTel(String employeeTel);
}
