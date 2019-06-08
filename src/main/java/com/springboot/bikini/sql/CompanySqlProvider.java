package com.springboot.bikini.sql;

import com.springboot.bikini.model.CompanyDomain;

public class CompanySqlProvider {
    public String insertCompany(CompanyDomain companyDomain){
        return "insert into company(COMPANY_NAME, COMPANY_TYPE, COMPANY_STAFF_NUM, COMPANY_ADDRESS, COMPANY_DESCRIPTION)\n" +
                "values (#{companyName},#{companyType},#{companyStaffNum},#{companyAddress},#{companyDescription})";
    }
}
