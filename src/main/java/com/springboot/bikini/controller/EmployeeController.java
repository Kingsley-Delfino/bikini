package com.springboot.bikini.controller;

import com.springboot.bikini.model.EmployeeDomain;
import com.springboot.bikini.model.JSONResult;
import com.springboot.bikini.model.PositionDomain;
import com.springboot.bikini.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping("/login")
    public String login(){
        return "employeeLogin";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/employeeShow")
    public String employeeShow(){
        return "employeeShow";
    }
    /**
     *@description: 登录功能
     *@param: employeeTel,password
     *@return: null
    */
    @RequestMapping("/employeeLogin")
    @ResponseBody
    public JSONResult employeeLogin(@RequestBody EmployeeDomain employeeDomain){
        System.out.println(employeeDomain.getEmployeePassword()+"!!!!!!!!!!!!!!!!!!");
        employeeService.login(employeeDomain);

        return new JSONResult("success");
    }
    /**
     *@description: 注册功能
     *@param: employeedomain
     *@return: null
    */
    @RequestMapping("/employeeRegister")
    public JSONResult employerRegister(@RequestBody EmployeeDomain employeeDomain){
        employeeService.register(employeeDomain);
        return new JSONResult("success");
    }
    /**
     *@description: 修改employee信息，电话不可修改
     *@param: employeedomain
     *@return: null
    */
    @RequestMapping("/employeeAlter")
    public JSONResult employeeAlter(@RequestBody EmployeeDomain employeeDomain){
        employeeService.updateEmployee(employeeDomain);
        return new JSONResult("success");
    }

}
