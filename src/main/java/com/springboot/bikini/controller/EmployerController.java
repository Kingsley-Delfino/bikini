package com.springboot.bikini.controller;

import com.springboot.bikini.model.CompanyDomain;
import com.springboot.bikini.model.EmployerDomain;
import com.springboot.bikini.model.JSONResult;
import com.springboot.bikini.service.CompanyService;
import com.springboot.bikini.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/employer")
public class EmployerController {
    @Autowired
    private EmployerService employerService;
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/employerLog")
    public JSONResult employerLogin(@RequestBody EmployerDomain employerDomain){
        employerService.login(employerDomain);
        return new JSONResult("success");
    }
    @RequestMapping("/employerReg")
    public JSONResult employerRegister(@RequestBody EmployerDomain employerDomain){
        employerService.register(employerDomain);
        return new JSONResult("success");
    }
    @RequestMapping("/companyReg")
    public JSONResult companyRegister(HttpServletRequest request,@RequestBody CompanyDomain companyDomain){
        companyService.insertCompany(companyDomain);
        HttpSession session=request.getSession();
        String tel=(String)session.getAttribute("employerTel");
        employerService.setEmployerCompanyId(tel,companyDomain);
        return new JSONResult("success");
    }

    /**
     *@description: 得到employer信息
     *@param: employerTel
     *@return: employerDomain
    */
    @ResponseBody
    @RequestMapping("/employerSelectInfo")
    public JSONResult employerSelectInfo(HttpServletRequest request){
        HttpSession session=request.getSession();
        String tel=(String)session.getAttribute("employerTel");
        EmployerDomain employerDomain=employerService.selectInfoByTel(tel);
        return new JSONResult(employerDomain);
    }

    /**
     *@description: 修改employer信息
     *@param: EmployerDomain，tel不可修改
     *@return: void
    */
    @RequestMapping("/employerAlter")
    public JSONResult employerAlter(@RequestBody EmployerDomain employerDomain){
        employerService.updateEmployer(employerDomain);
        return new JSONResult("success");
    }
    /**
     *@description: 查看申请职位的应聘者
     *@param: employertel
     *@return: list<HashMap>(其中包含应聘者的所有个人信息)
    */
    @ResponseBody
    @RequestMapping("/selectAllEmployeeHaveCv")
    public JSONResult selectAllEmployEEHaveCv(HttpServletRequest request){
        HttpSession session=request.getSession();
        String tel=(String)session.getAttribute("employerTel");
        List<HashMap> list=employerService.selectAllEmployeeHaveCv(tel);
        return new JSONResult(list);
    }
}
