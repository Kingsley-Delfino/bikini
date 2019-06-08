package com.springboot.bikini.sql;

import com.springboot.bikini.model.EmployerDomain;

/**
 * 生成sql
 */
public class EmployerSqlProvider {
    public String selectByEmployerTel(String employerTel){
        return "select EMPLOYER_ID, EMPLOYER_NAME, EMPLOYER_TEL, EMPLOYER_PASSWD, EMPLOYER_COMPANY_ID, EMPLOYER_AGE, EMPLOYER_GENDER, EMPLOYER_EMAIL, EMPLOYER_PHOTO_ADDRESS\n"+
                "from employer\n"+
                "where EMPLOYER_TEL=#{employerTel}";
    }
    public String insertEmployer(EmployerDomain employerDomain){
        return "insert into employer(EMPLOYER_NAME, EMPLOYER_TEL, EMPLOYER_PASSWD, EMPLOYER_COMPANY_ID, EMPLOYER_AGE, EMPLOYER_GENDER, EMPLOYER_EMAIL, EMPLOYER_PHOTO_ADDRESS)\n" +
                "values (#{employerName},#{employerTel},#{employerPasswd},#{employerCompanyId},#{employerAge},#{employerGender},#{employerEmail},#{employerPhotoAddress})";
    }
    public String selectCountEmployerByTel(String employerTel){
        return "select count(*)\n" +
                "from employer\n" +
                "where EMPLOYER_TEL=#{employerTel}";
    }
    public String selectCompanyIdByCompanyName(String name){
        return "SELECT COMPANY_ID\n" +
                "FROM company\n" +
                "where COMPANY_NAME=#{name};";
    }
    public String updateEmployerCompanyId(int id,String tel){
        return "UPDATE employer\n" +
                "SET EMPLOYER_COMPANY_ID=#{id}\n" +
                "where EMPLOYER_TEL=#{tel};";
    }

}
