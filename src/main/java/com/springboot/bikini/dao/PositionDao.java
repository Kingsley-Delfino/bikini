package com.springboot.bikini.dao;

import com.springboot.bikini.model.PositionDomain;
import com.springboot.bikini.sql.EmployerSqlProvider;
import com.springboot.bikini.sql.PositionSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository
public interface PositionDao {

    @InsertProvider(type= PositionSqlProvider.class,method = "insertPosition")
    public int insertPosition(PositionDomain positionDomain);

    @SelectProvider(type= PositionSqlProvider.class,method="selectPositionIdByTel")
    public int selectPositionIdByTel(@Param("tel") String tel);

    @SelectProvider(type= PositionSqlProvider.class,method="selectPositionByPosition")
    public List<HashMap> selectPositionByPosition(PositionDomain positionDomain);

    @SelectProvider(type= PositionSqlProvider.class,method = "selectCompanyInfoByPositionId")
    public HashMap selectCompanyInfoByPositionId(@Param("positionId") int positionId);

    @InsertProvider(type=PositionSqlProvider.class,method = "insertSendCv")
    public void insertSendCv(@Param("employeeId") int employeeId,@Param("employerId") int employerId,@Param("CVAddress") String CVAddress);

    @SelectProvider(type=PositionSqlProvider.class,method = "selectCompanyIdByTel")
    public int selectCompanyIdByTel(@Param("tel")String tel);
    public int deletePosition(int PositionId);
    public int updatePosition(PositionDomain positionDomain);
    public PositionDomain selectByPositionId(int PositionId);
    public List<PositionDomain> selectAllPosition();
}
