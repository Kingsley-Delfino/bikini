package com.springboot.bikini.service;

import com.springboot.bikini.model.PositionDomain;

import java.util.HashMap;
import java.util.List;

public interface PositionService {
    public void insertPosition(PositionDomain positionDomain);
    public int getEmployerId(String tel);
    public List<HashMap> employeeSelectPosition(PositionDomain positionDomain);
    public void sendCv(String tel,int positionEmployeeId);
    public void release(PositionDomain positionDomain,String tel);
    public List<PositionDomain> selectAllPosition(String tel);
    public void deletePosition(int positionId);
    public boolean companyIdIsNull(String tel);
//    public int deletePosition(int PositionId);
//    public int updatePosition(PositionDomain positionDomain);
//    public PositionDomain selectByPositionId(int PositionId);
//    public List<PositionDomain> selectAllPosition();
}
