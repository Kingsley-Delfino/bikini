package com.springboot.bikini.dao;

import com.springboot.bikini.model.CompanyDomain;
import com.springboot.bikini.service.servicesImpl.CompanyServiceImpl;
import com.springboot.bikini.sql.CompanySqlProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface CompanyDao {
    @InsertProvider(type= CompanySqlProvider.class,method ="insertCompany")
    public int insertCompany(CompanyDomain record);
    public int deleteCompany(int companyId);
    public int updateCompany(CompanyDomain companyDomain);
    public CompanyDomain selectByCompanyId(int companyId);
    public List<CompanyDomain> selectAllCompany();
}
