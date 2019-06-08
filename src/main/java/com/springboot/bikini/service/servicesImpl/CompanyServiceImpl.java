package com.springboot.bikini.service.servicesImpl;

import com.springboot.bikini.dao.CompanyDao;
import com.springboot.bikini.exp.BusinessException;
import com.springboot.bikini.model.CompanyDomain;
import com.springboot.bikini.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional

public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;

    @Override
    public void insertCompany(CompanyDomain companyDomain){
        if(companyDomain.getCompanyName()==null||("").equals(companyDomain.getCompanyName())
            ||companyDomain.getCompanyType()==null||("").equals(companyDomain.getCompanyType())
            ||companyDomain.getCompanyAddress()==null||("").equals(companyDomain.getCompanyAddress())
            ||companyDomain.getCompanyDescription()==null||("").equals(companyDomain.getCompanyDescription())
            ||companyDomain.getCompanyStaffNum()==0){
            throw new BusinessException("必要参数为空");
        }
        companyDao.insertCompany(companyDomain);
    }
}
