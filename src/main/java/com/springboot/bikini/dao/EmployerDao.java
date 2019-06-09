package com.springboot.bikini.dao;

import com.springboot.bikini.model.EmployerDomain;
import com.springboot.bikini.model.PositionDomain;
import com.springboot.bikini.sql.EmployerSqlProvider;
import com.springboot.bikini.sql.PositionSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface EmployerDao {
    @InsertProvider(type= EmployerSqlProvider.class, method = "insertEmployer")
    public int insertEmployer(EmployerDomain employerDomain);

    public int deleteEmployer(@Param("employerId")int EmployerId);

    public int updateEmployer(EmployerDomain employerDomain);

    @SelectProvider(type = EmployerSqlProvider.class, method = "selectByEmployerTel")
    EmployerDomain selectByEmployerTel(@Param("employerTel")String employerTel);

    public List<EmployerDomain> selectAllEmployer();

    @SelectProvider(type = EmployerSqlProvider.class, method = "selectCountEmployerByTel")
    int selectCountEmployerByTel(@Param("employerTel") String employerTel);

    @SelectProvider(type=EmployerSqlProvider.class,method="selectCompanyIdByCompanyName")
    int selectCompanyIdByCompanyName(@Param("name") String name);

    @UpdateProvider(type=EmployerSqlProvider.class,method="updateEmployerCompanyId")
    void updateEmployerCompanyId(@Param("id") int id,@Param("tel") String tel);

    @SelectProvider(type= EmployerSqlProvider.class,method = "selectAllPositionById")
    List<PositionDomain> selectAllPositionById(@Param("employerId") int employerId);

    @DeleteProvider(type= EmployerSqlProvider.class,method = "deletePositionByPositionId")
    void deletePositionByPositionId(@Param("positionId") int PositionId);
}
