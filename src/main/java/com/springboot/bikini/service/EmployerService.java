package com.springboot.bikini.service;

import com.springboot.bikini.model.CompanyDomain;
import com.springboot.bikini.model.EmployerDomain;
import org.springframework.stereotype.Service;

import java.util.List;
public interface EmployerService {
    //public int insertEmployer(EmployerDomain record);
    //public int deleteEmployer(int EmployerId);
    //public int updateEmployer(EmployerDomain employerDomain);
    //public EmployerDomain selectByEmployerId(int employerId);
    //public List<EmployerDomain> selectAllEmployer();
    void login(EmployerDomain employerDomain);
    void register(EmployerDomain employerDomain);
    void setEmployerCompanyId(String tel, CompanyDomain companyDomain);
}
