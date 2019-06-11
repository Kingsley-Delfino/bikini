package com.springboot.bikini;

import com.springboot.bikini.model.CompanyDomain;
import com.springboot.bikini.model.EmployeeDomain;
import com.springboot.bikini.model.EmployerDomain;
import com.springboot.bikini.model.PositionDomain;
import com.springboot.bikini.service.CompanyService;
import com.springboot.bikini.service.EmployeeService;
import com.springboot.bikini.service.EmployerService;
import com.springboot.bikini.service.PositionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class BikiniApplicationTests {
    @Autowired
    private EmployerService employerService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private PositionService positionService;

    private Logger logger=LoggerFactory.getLogger(getClass());
    @Test
    public void contextLoads() {
    }

    @Test
    public void login(){
        logger= LoggerFactory.getLogger(getClass());
        EmployeeDomain employeeDomain=new EmployeeDomain();
        //employerDomain.setEmployerId(2);
        employeeDomain.setEmployeeTel("110");
        employeeDomain.setEmployeePassword("123456");
        logger.info("success");
        logger.info(employeeDomain.getEmployeeTel()+employeeDomain.getEmployeePassword());
        employeeService.login(employeeDomain);
        logger.info("登录成功！");

    }

    @Test
    public void register(){
        EmployerDomain employerDomain=new EmployerDomain();
        employerDomain.setEmployerName("zakary");
        employerDomain.setEmployerTel("12345678");
        employerDomain.setEmployerPasswd("123456");
        employerDomain.setEmployerPhotoAddress("123");
        employerDomain.setEmployerCompanyId(11);
        employerService.register(employerDomain);
    }
    @Test
    public void registerEmployee(){
        EmployeeDomain employeeDomain=new EmployeeDomain();
        employeeDomain.setEmployeeName("zakary");
        employeeDomain.setEmployeeTel("12345678");
        employeeDomain.setEmployeePassword("123456");
        employeeDomain.setEmployeePhotoAddress("123");
        employeeDomain.setEmployeeEmail("123");
        employeeDomain.setEmployeeCvAddress("123");
        employeeDomain.setEmployeeGender("男");
        employeeDomain.setEmployeeUniversity("dhu");
        employeeService.register(employeeDomain);
    }
    @Test
    public void companyRegister(){
        CompanyDomain companyDomain=new CompanyDomain();
        companyDomain.setCompanyName("dhu");
        companyDomain.setCompanyAddress("shanghai");
        companyDomain.setCompanyDescription("211");
        companyDomain.setCompanyStaffNum(100);
        companyDomain.setCompanyType("IT");
        companyService.insertCompany(companyDomain);
        logger.info("success");
    }

    @Test
    public void companyRegisterNext(){
        CompanyDomain companyDomain=new CompanyDomain();
        companyDomain.setCompanyName("dhuuuuu");
        companyDomain.setCompanyAddress("shanghai");
        companyDomain.setCompanyDescription("211");
        companyDomain.setCompanyStaffNum(100);
        companyDomain.setCompanyType("IT");
        companyService.insertCompany(companyDomain);
        String tel="12345678";
        employerService.setEmployerCompanyId(tel,companyDomain);
        logger.info("success");
    }

    @Test
    public void positionRealease(){
        PositionDomain positionDomain=new PositionDomain();
        Date date = new Date("2000/01/01");
        positionDomain.setPositionName("java开发");
        positionDomain.setPositionDeadline(date);
        positionDomain.setPositionEducation("本科");
        positionDomain.setPositionType("IT");
        positionDomain.setPositionSalaryLow(1000);
        positionDomain.setPositionSalaryTop(10000);
        positionDomain.setPositionExperience("五年");
        positionDomain.setPositionDescription("ITITITIT");
        String tel="123456";
        int id=positionService.getEmployerId(tel);
        positionDomain.setPositionEmployerId(id);
        positionService.insertPosition(positionDomain);
    }
    
    @Test
    public void employeeUpdate(){
        EmployeeDomain employeeDomain=new EmployeeDomain();
        employeeDomain.setEmployeeUniversity("东大");
        employeeDomain.setEmployeeEmail("123@qq.com");
        employeeDomain.setEmployeeTel("12345678");
        employeeService.updateEmployee(employeeDomain);
    }

    @Test
    public void selectP() {
        logger= LoggerFactory.getLogger(getClass());
        PositionDomain positionDomain = new PositionDomain();
        int pageNum=1;
        int limit=30;
        List<HashMap> positionDomains =positionService.employeeSelectPosition(positionDomain);

        for (HashMap i:positionDomains) {
            logger.info(i.toString());
        }
    }

    @Test
    public void sendCv(){
        int position_employer_id=3;
        String tel="110";
        positionService.sendCv(tel,position_employer_id);
    }

    @Test
    public void selectAllP(){
        String employerTel="123456";
        List<PositionDomain> list=positionService.selectAllPosition(employerTel);
        for (PositionDomain i:
             list) {
            logger.info(i.toString());
        }
    }
    @Test
    public void deletePosition(){
        int positionId=7;
        positionService.deletePosition(positionId);
    }
    @Test
    public void queryfirst(){
        PositionDomain positionDomain=new PositionDomain();
        positionDomain.setPositionName("Java开发");
        positionDomain.setPositionSalaryLow(0);
        positionDomain.setPositionSalaryTop(1000000);
        List<HashMap> positionDomains =positionService.employeeSelectPosition(positionDomain);
        for (HashMap i:
                positionDomains) {
            logger.info(i.toString());
        }
    }


}
