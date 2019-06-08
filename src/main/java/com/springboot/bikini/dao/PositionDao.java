package com.springboot.bikini.dao;

import com.springboot.bikini.model.PositionDomain;
import com.springboot.bikini.sql.PositionSqlProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PositionDao {

    @InsertProvider(type= PositionSqlProvider.class,method = "insertPosition")
    public int insertPosition(PositionDomain positionDomain);

    @SelectProvider(type= PositionSqlProvider.class,method="selectPositionIdByTel")
    public int selectPositionIdByTel(String tel);

    @SelectProvider(type= PositionSqlProvider.class,method="selectPositionByPosition")
    public List<PositionDomain> selectPositionByPosition(PositionDomain positionDomain,int page,int limit);

    public int deletePosition(int PositionId);
    public int updatePosition(PositionDomain positionDomain);
    public PositionDomain selectByPositionId(int PositionId);
    public List<PositionDomain> selectAllPosition();
}
