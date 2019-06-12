package com.springboot.bikini.sql;

import com.springboot.bikini.model.EmployeeDomain;

import java.util.ArrayList;

public class EmployeeSqlProvider {
    public String selectByEmployeeTel(String employeeTel) {
        return "select EMPLOYEE_ID, EMPLOYEE_NAME, EMPLOYEE_PASSWORD, EMPLOYEE_TEL, EMPLOYEE_AGE, EMPLOYEE_GENDER, EMPLOYEE_UNIVERSITY, EMPLOYEE_EMAIL, EMPLOYEE_ADDRESS, EMPLOYEE_CV_ADDRESS, EMPLOYEE_PHOTO_ADDRESS\n" +
                "from employee\n" +
                "where EMPLOYEE_TEL=#{employeeTel}";
    }
    public String insertEmployee(EmployeeDomain employeeDomain) {
        return "insert into employee(employee_name, employee_password, employee_tel, employee_age, employee_gender, employee_university, employee_email, employee_address, employee_cv_address, employee_photo_address) \n" +
                "values (#{employeeName},#{employeePassword},#{employeeTel},#{employeeAge},#{employeeGender},#{employeeUniversity},#{employeeEmail},#{employeeAddress},#{employeeCvAddress},#{employeePhotoAddress})";
    }
    public String selectCountEmployeeByTel(String employeeTel) {
        return "select count(*)\n" +
                "from employee\n" +
                "where EMPLOYEE_TEL=#{employeeTel}";
    }
    public String updateEmployee(EmployeeDomain employeeDomain){
        System.out.println(employeeDomain.getEmployeeUniversity());
        String str="UPDATE employee\nset ";
        if(employeeDomain.getEmployeeName()!=null&&!"".equals(employeeDomain.getEmployeeName()))
            str+="EMPLOYEE_NAME=#{employeeName},\n";
        if(employeeDomain.getEmployeeAge()!=0&&!"".equals(employeeDomain.getEmployeeAge()))
            str+="EMPLOYEE_AGE=#{employeeAge},\n";
        if(employeeDomain.getEmployeeGender()!=null&&!"".equals(employeeDomain.getEmployeeGender()))
            str+="EMPLOYEE_GENDER=#{employeeGender},\n";
        if(employeeDomain.getEmployeeUniversity()!=null&&!"".equals(employeeDomain.getEmployeeUniversity()))
            str+="EMPLOYEE_UNIVERSITY=#{employeeUniversity},\n";
        if(employeeDomain.getEmployeeEmail()!=null&&!"".equals(employeeDomain.getEmployeeEmail()))
            str+="EMPLOYEE_EMAIL=#{employeeEmail},\n";
        if(employeeDomain.getEmployeeAddress()!=null&&!"".equals(employeeDomain.getEmployeeAddress()))
            str+="EMPLOYEE_ADDRESS=#{employeeAddress},\n";
        str=str.substring(0,str.length()-2);
        str+="\nWHERE EMPLOYEE_TEL=#{employeeTel};";
        ArrayList<String> m=new ArrayList<>();

        return str;
    }

    public String selectSendCvByEmployeeIdAndEmployerId(int employeeId,int employerId){
        return "select count(*)\n" +
                "from sendCv\n" +
                "where EMPLOYEE_ID=#{employeeId} and EMPLOYER_ID=#{employerId}";
    };
}
