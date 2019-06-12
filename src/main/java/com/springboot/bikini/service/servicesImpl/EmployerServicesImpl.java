package com.springboot.bikini.service.servicesImpl;

import com.springboot.bikini.dao.EmployerDao;
import com.springboot.bikini.exp.BusinessException;
import com.springboot.bikini.model.CompanyDomain;
import com.springboot.bikini.model.EmployerDomain;
import com.springboot.bikini.model.JSONResult;
import com.springboot.bikini.service.EmployerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class EmployerServicesImpl implements EmployerService {

    @Autowired
    private EmployerDao employerDao;

    private Logger logger = LoggerFactory.getLogger(getClass());;
    @Override

    public void login(EmployerDomain employerDomain){
        if(("").equals(employerDomain.getEmployerTel())||employerDomain.getEmployerTel()==null
            ||("").equals(employerDomain.getEmployerPasswd())||employerDomain.getEmployerPasswd()==null){
            throw new BusinessException("必要参数为空");
        }
        EmployerDomain employerDomain1= employerDao.selectByEmployerTel(employerDomain.getEmployerTel());
        logger.info("result:"+employerDomain1);
//        if(!(employerDomain.getEmployerPasswd().equals((employerDomain1.getEmployerPasswd())))){
//            throw new BusinessException("密码错误");
//        }
        //用校验过的参数去调用equals
        if(!employerDomain.equals(employerDomain1)){
            throw new BusinessException("账号或密码错误");
        }
    }

    @Override
    public void register(EmployerDomain employerDomain){
        if(employerDomain.getEmployerName()==null||"".equals(employerDomain.getEmployerName())
                ||employerDomain.getEmployerTel()==null||"".equals((employerDomain.getEmployerTel()))
                ||employerDomain.getEmployerPasswd()==null||"".equals(employerDomain.getEmployerPasswd())){
            throw new BusinessException("必要参数为空");
        }
        if(employerDao.selectCountEmployerByTel(employerDomain.getEmployerTel())!=0){
            throw new BusinessException("此电话在数据库中已经存在");
        }
        employerDao.insertEmployer(employerDomain);
    }

    @Override
    public void setEmployerCompanyId(String tel, CompanyDomain companyDomain){
        int company_id=employerDao.selectCompanyIdByCompanyName(companyDomain.getCompanyName());
        employerDao.updateEmployerCompanyId(company_id,tel);
    }

    @Override
    public EmployerDomain  selectInfoByTel(String tel){
        return employerDao.selectByEmployerTel(tel);
    }

    @Override
    public int updateEmployer(EmployerDomain employerDomain){
        return employerDao.updateEmployer(employerDomain);
    }

    @Override
    public List<HashMap> selectAllEmployeeHaveCv(String tel){
        EmployerDomain employerDomain=selectInfoByTel(tel);
        int employerId=employerDomain.getEmployerId();
        return employerDao.selectAllEmployeeByEmployerId(employerId);
    }
}
