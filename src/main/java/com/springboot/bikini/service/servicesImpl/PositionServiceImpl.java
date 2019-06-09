package com.springboot.bikini.service.servicesImpl;

import com.springboot.bikini.dao.EmployeeDao;
import com.springboot.bikini.dao.EmployerDao;
import com.springboot.bikini.dao.PositionDao;
import com.springboot.bikini.exp.BusinessException;
import com.springboot.bikini.model.CompanyDomain;
import com.springboot.bikini.model.EmployeeDomain;
import com.springboot.bikini.model.EmployerDomain;
import com.springboot.bikini.model.PositionDomain;
import com.springboot.bikini.service.PositionService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Transactional
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionDao positionDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private EmployerDao employerDao;

    @Override
    public void insertPosition(PositionDomain positionDomain){
        if(positionDomain.getPositionName()==null||"".equals(positionDomain.getPositionName())
            ||positionDomain.getPositionDeadline()==null||"".equals(positionDomain.getPositionDeadline())
            ||positionDomain.getPositionEducation()==null||"".equals(positionDomain.getPositionEducation())
            ||positionDomain.getPositionType()==null||"".equals(positionDomain.getPositionType())
            ||positionDomain.getPositionSalaryLow()==0||"".equals(positionDomain.getPositionSalaryTop()==0)
            ||positionDomain.getPositionExperience()==null||"".equals(positionDomain.getPositionExperience())
            ||positionDomain.getPositionDescription()==null||"".equals(positionDomain.getPositionDescription())){
            throw new BusinessException("必要参数为空");
        }
        positionDao.insertPosition(positionDomain);
    }

    @Override
    public int getEmployerId(String tel){
        return positionDao.selectPositionIdByTel(tel);
    }

    @Override
    public List<HashMap> employeeSelectPosition(PositionDomain positionDomain){
        List<HashMap> list=positionDao.selectPositionByPosition(positionDomain);
        int len=list.size();
        for (HashMap i:list) {
            System.out.println(i.get("position_id")+"!!!!!!!!");
            HashMap hashMap=positionDao.selectCompanyInfoByPositionId(Integer.valueOf(i.get("position_id").toString()));
            i.putAll(hashMap);
        }
        return list;
    }

    @Override
    public void sendCv(String tel,int position_employer_id){
        EmployeeDomain employeeDomain=employeeDao.selectByEmployeeTel(tel);
        positionDao.insertSendCv(employeeDomain.getEmployeeId(),position_employer_id,employeeDomain.getEmployeeCvAddress());
    }

    @Override
    public void release(PositionDomain positionDomain,String tel){
        EmployerDomain employeeDomain=employerDao.selectByEmployerTel(tel);
        positionDomain.setPositionEmployerId(employeeDomain.getEmployerId());
        positionDao.insertPosition(positionDomain);
    }

    @Override
    public List<PositionDomain> selectAllPosition(String tel){
        EmployerDomain employerDomain=employerDao.selectByEmployerTel(tel);
        return employerDao.selectAllPositionById(employerDomain.getEmployerId());
    }

    @Override
    public void deletePosition(int positionId){
        employerDao.deletePositionByPositionId(positionId);
    }


}
