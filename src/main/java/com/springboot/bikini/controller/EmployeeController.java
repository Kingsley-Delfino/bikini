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


    @RequestMapping("/employeeLogin")
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

    @RequestMapping("/employeeChoose")
    public String employeeChoose(){return "employeeChoose";}

    @RequestMapping("/employeeEdit")
    public String employeeEdit(){return "employeeEdit";}

    @RequestMapping("/employeeJob")
    public String employeeJob(){return "employeeJob";}

    @RequestMapping("/employeeRegister")
    public String employeeRegister(){return "employeeRegister";}

    @RequestMapping("employeeSearch")
    public String employeeSearch(){return "employeeSearch";}

    @RequestMapping("employer")
    public String employer(){return "employer";}

    @RequestMapping("/employerCompany")
    public String employerCompany(){return "employerCompany";}

    @RequestMapping("/employerEdit")
    public String employerEdit(){return "employerEidt";}

    @RequestMapping("/employerEmployee")
    public String employerEmployee(){return "employerEmployee";}

    @RequestMapping("/employerJob")
    public String employerJob(){return "employerJob";}

    @RequestMapping("/employerLogin")
    public String employerLogin(){return "employerLogin";}

    @RequestMapping("/employerPublish")
    public String employerPublish(){return "employerPublish";}

    @RequestMapping("/employerRegister")
    public String employerRegister(){return "employerRegister";}

    @RequestMapping("/employerSearch")
    public String employerSearch(){return "employerSearch";}

    @RequestMapping("/employerShow")
    public String employerShow(){return "employerShow";}

    /**
     *@description: 登录功能
     *@param: employeeTel,password
     *@return: null
    */
    @RequestMapping("/employeeLog")
    @ResponseBody
    public JSONResult employeeLogin(@RequestBody EmployeeDomain employeeDomain){
        //System.out.println(employeeDomain.getEmployeePassword()+"!!!!!!!!!!!!!!!!!!");
        employeeService.login(employeeDomain);

        return new JSONResult("success");
    }
    /**
     *@description: 注册功能
     *@param: employeedomain
     *@return: null
    */
    @RequestMapping("/employeeReg")
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
