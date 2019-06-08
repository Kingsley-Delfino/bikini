package com.springboot.bikini.service;

import com.springboot.bikini.model.PositionDomain;

import java.util.List;

public interface PositionService {
    public void insertPosition(PositionDomain positionDomain);
    public int getEmployerId(String tel);
    public List<PositionDomain> employeeSelectPosition(PositionDomain positionDomain,int pageNum,int limit);
//    public int deletePosition(int PositionId);
//    public int updatePosition(PositionDomain positionDomain);
//    public PositionDomain selectByPositionId(int PositionId);
//    public List<PositionDomain> selectAllPosition();
}
