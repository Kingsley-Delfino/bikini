package com.springboot.bikini.sql;

import com.springboot.bikini.model.PositionDomain;

public class PositionSqlProvider {
    public String insertPosition(PositionDomain positionDao){
        return "INSERT position (POSITION_NAME,POSITION_CREATE_DATE,POSITION_DEADLINE,POSITION_EDUCATION,POSITION_EMPLOYER_ID,POSITION_TYPE,POSITION_SALARY_LOW,POSITION_SALARY_TOP,POSITION_EXPERIENCE,POSITION_DESCRIPTION)\n" +
                "VALUES (#{positionName},NOW(),#{positionDeadline},#{positionEducation},#{positionEmployerId},#{positionType},#{positionSalaryLow},#{positionSalaryTop},#{positionExperience},#{positionDescription});";
    }

    public String selectPositionIdByTel(String tel){
        return "SELECT EMPLOYER_ID\n" +
                "FROM employer\n" +
                "WHERE EMPLOYER_TEL=#{tel};";
    }

    public String selectPositionByPosition(PositionDomain positionDomain){
        String str="select position_id,position_name, position_create_date, position_deadline, position_education, position_employer_id, position_type, position_salary_low, position_salary_top, position_experience, position_description\n" +
                "from position\n";
//        if((positionDomain.getPositionName()==null||"".equals(positionDomain.getPositionName()))
//            &&(positionDomain.getPositionExperience()==null||"".equals(positionDomain.getPositionExperience()))
//            &&(positionDomain.getPositionEducation()==null||"".equals(positionDomain.getPositionEducation()))
//            &&positionDomain.getPositionSalaryLow()==0&&positionDomain.getPositionSalaryTop()==1000000){
//        }
//        else{
            str+="where ";
            str+="POSITION_SALARY_LOW>#{positionSalaryLow} and POSITION_SALARY_TOP<#{positionSalaryTop} and ";
            if(positionDomain.getPositionName()!=null&&!"".equals(positionDomain.getPositionName())){
                str+="POSITION_NAME=#{positionName} and ";
            }
            if(positionDomain.getPositionExperience()!=null&&!"".equals(positionDomain.getPositionExperience())){
                str+="POSITION_EXPERIENCE=#{positionExperience} and ";
            }
            if(positionDomain.getPositionEducation()!=null&&!"".equals(positionDomain.getPositionEducation())){
                str+="POSITION_EDUCATION=#{positionEducation} and ";
            }
            if(positionDomain.getPositionType()!=null&&!"".equals(positionDomain.getPositionType())){
                str+="POSITION_TYPE=#{positionType} and ";
            }
            //if(positionDomain.getPositionSalaryLow()!=0&&positionDomain.getPositionSalaryTop()!=1000000){
                //str+="POSITION_SALARY_LOW>#{PositionSalaryLow} and POSITION_SALARY_TOP<#{PositionSalaryTop} and ";
            //}
            str=str.substring(0,str.length()-4);
        //}
        return str;
    }

    public String selectCompanyInfoByPositionId(int positionId) {
        return "select company_id, company_name, company_type, company_staff_num, company_address, company_description, company_cv_num\n" +
                "from company,position,employer\n" +
                "where position.POSITION_ID=#{positionId} and position.POSITION_EMPLOYER_ID=employer.employer_id and employer.EMPLOYER_COMPANY_ID=company.COMPANY_ID\n";
    }
    public String insertSendCv(int employeeId,int employerId,String CVAddress){
        return "insert into sendCv(employee_id, employer_id, cv_adress)\n" +
                "values (#{employeeId},#{employerId},#{CVAddress})";
    }

    public String selectCompanyIdByTel(String tel){
        return "select EMPLOYER_COMPANY_ID\n" +
                "from employer\n" +
                "where EMPLOYER_TEL=#{tel}";
    };

}
