package com.springboot.bikini.controller;

import com.springboot.bikini.model.CompanyDomain;
import com.springboot.bikini.model.EmployerDomain;
import com.springboot.bikini.model.JSONResult;
import com.springboot.bikini.service.CompanyService;
import com.springboot.bikini.service.EmployerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class EmployerController {
    private EmployerService employerService;
    private CompanyService companyService;

    @RequestMapping("/employerLogin")
    public JSONResult employerLogin(EmployerDomain employerDomain){
        employerService.login(employerDomain);
        return new JSONResult("success");
    }
    @RequestMapping("/employerRegister")
    public JSONResult employerRegister(EmployerDomain employerDomain){
        employerService.register(employerDomain);
        return new JSONResult("success");
    }
    @RequestMapping("/companyRegister")
    public JSONResult companyRegister(HttpServletRequest request,CompanyDomain companyDomain){
        companyService.insertCompany(companyDomain);
        HttpSession session=request.getSession();
        String tel=(String)session.getAttribute("employerTel");
        employerService.setEmployerCompanyId(tel,companyDomain);
        return new JSONResult("success");
    }
}
