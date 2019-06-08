package com.springboot.bikini.dao;

import com.springboot.bikini.model.EmployerDomain;
import com.springboot.bikini.sql.EmployerSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface EmployerDao {
    @InsertProvider(type= EmployerSqlProvider.class, method = "insertEmployer")
    public int insertEmployer(EmployerDomain employerDomain);

    public int deleteEmployer(int EmployerId);

    public int updateEmployer(EmployerDomain employerDomain);

    @SelectProvider(type = EmployerSqlProvider.class, method = "selectByEmployerTel")
    EmployerDomain selectByEmployerTel(String employerTel);

    public List<EmployerDomain> selectAllEmployer();

    @SelectProvider(type = EmployerSqlProvider.class, method = "selectCountEmployerByTel")
    int selectCountEmployerByTel(String employerTel);

    @SelectProvider(type=EmployerSqlProvider.class,method="selectCompanyIdByCompanyName")
    int selectCompanyIdByCompanyName(String name);

    @UpdateProvider(type=EmployerSqlProvider.class,method="updateEmployerCompanyId")
    void updateEmployerCompanyId(int id,String tel);
}
