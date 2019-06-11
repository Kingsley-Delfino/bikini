package com.springboot.bikini.service.servicesImpl;

import com.springboot.bikini.dao.EmployeeDao;
import com.springboot.bikini.exp.BusinessException;
import com.springboot.bikini.model.EmployeeDomain;
import com.springboot.bikini.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void login(EmployeeDomain employeeDomain){
        if(("").equals(employeeDomain.getEmployeeTel())||employeeDomain.getEmployeeTel()==null
                ||("").equals(employeeDomain.getEmployeePassword())||employeeDomain.getEmployeePassword()==null){
            throw new BusinessException("必要参数为空");
        }
        EmployeeDomain employeeDomain1= employeeDao.selectByEmployeeTel(employeeDomain.getEmployeeTel());
        logger.info("result:"+employeeDomain1.toString());
//        if(!(employerDomain.getEmployerPasswd().equals((employerDomain1.getEmployerPasswd())))){
//            throw new BusinessException("密码错误");
//        }
        //用校验过的参数去调用equals
        if(!employeeDomain.getEmployeePassword().equals(employeeDomain1.getEmployeePassword())){
            throw new BusinessException("账号或密码错误");
        }
    }
    @Override
    public void register(EmployeeDomain employeeDomain){
        if(employeeDomain.getEmployeeName()==null||"".equals(employeeDomain.getEmployeeName())
                ||employeeDomain.getEmployeeTel()==null||"".equals((employeeDomain.getEmployeeTel()))
                ||employeeDomain.getEmployeePassword()==null||"".equals(employeeDomain.getEmployeePassword())){
            throw new BusinessException("必要参数为空");
        }
        if(employeeDao.selectCountEmployeeByTel(employeeDomain.getEmployeeTel())!=0){
            throw new BusinessException("此电话在数据库中已经存在");
        }
        employeeDao.insertEmployee(employeeDomain);
    }

    @Override
    public int updateEmployee(EmployeeDomain employeeDomain){
        return employeeDao.updateEmployee(employeeDomain);
    }

    @Override
    public EmployeeDomain selectByTel(String tel){
        return employeeDao.selectByEmployeeTel(tel);
    };
}
