package com.springboot.bikini.service;

import com.springboot.bikini.model.EmployeeDomain;

import java.util.List;

public interface EmployeeService {
//    public int insertEmployee(EmployeeDomain record);
//    public int deleteEmployee(int EmployerId);
    public int updateEmployee(EmployeeDomain employeeDomain);
//    public EmployeeDomain selectByEmployeeId(int employeeId);
//    public List<EmployeeDomain> selectAllEmployee();
    public void login(EmployeeDomain employeeDomain);
    public void register(EmployeeDomain employerDomain);
    public EmployeeDomain selectByTel(String tel);

}
