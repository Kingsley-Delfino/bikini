package com.springboot.bikini.controller;

import com.springboot.bikini.model.EmployeeDomain;
import com.springboot.bikini.model.JSONResult;
import com.springboot.bikini.model.PositionDomain;
import com.springboot.bikini.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;


    @RequestMapping("/login")
    public String login(){
        return "employeeLogin";
    }
    
    /**
     *@description: 登录功能
     *@param: employeeTel,password
     *@return: null
    */
    @RequestMapping("/employeeLogin")
    public JSONResult employeeLogin(EmployeeDomain employeeDomain){
        employeeService.login(employeeDomain);
        return new JSONResult("success");
    }
    /**
     *@description: 注册功能
     *@param: employeedomain
     *@return: null
    */
    @RequestMapping("/employeeRegister")
    public JSONResult employerRegister(EmployeeDomain employeeDomain){
        employeeService.register(employeeDomain);
        return new JSONResult("success");
    }
    /**
     *@description: 修改employee信息，电话不可修改
     *@param: employeedomain
     *@return: null
    */
    @RequestMapping("/employeeAlter")
    public JSONResult employeeAlter(EmployeeDomain employeeDomain){
        employeeService.updateEmployee(employeeDomain);
        return new JSONResult("success");
    }

}
