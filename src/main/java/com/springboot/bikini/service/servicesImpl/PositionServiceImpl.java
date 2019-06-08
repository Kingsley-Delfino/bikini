package com.springboot.bikini.service.servicesImpl;

import com.springboot.bikini.dao.PositionDao;
import com.springboot.bikini.exp.BusinessException;
import com.springboot.bikini.model.PositionDomain;
import com.springboot.bikini.service.PositionService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionDao positionDao;

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
    public List<PositionDomain> employeeSelectPosition(PositionDomain positionDomain, int pageNum, int limit){
        return positionDao.selectPositionByPosition(positionDomain,pageNum,limit);
    }
}
