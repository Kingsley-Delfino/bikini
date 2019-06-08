package com.springboot.bikini.model;

import java.util.Objects;

public class EmployerDomain{
    private int employerId;
    private String employerName;
    private String employerTel;
    private String employerPasswd;
    private int employerCompanyId;
    private int employerAge;
    private String employerGender;
    private String employerEmail;
    private String employerPhotoAddress;

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getEmployerTel() {
        return employerTel;
    }

    public void setEmployerTel(String employerTel) {
        this.employerTel = employerTel;
    }

    public String getEmployerPasswd() {
        return employerPasswd;
    }

    public void setEmployerPasswd(String employerPasswd) {
        this.employerPasswd = employerPasswd;
    }

    public int getEmployerCompanyId() {
        return employerCompanyId;
    }

    public void setEmployerCompanyId(int employerCompanyId) {
        this.employerCompanyId = employerCompanyId;
    }

    public int getEmployerAge() {
        return employerAge;
    }

    public void setEmployerAge(int employerAge) {
        this.employerAge = employerAge;
    }

    public String getEmployerGender() {
        return employerGender;
    }

    public void setEmployerGender(String employerGender) {
        this.employerGender = employerGender;
    }

    public String getEmployerEmail() {
        return employerEmail;
    }

    public void setEmployerEmail(String employerEmail) {
        this.employerEmail = employerEmail;
    }

    public String getEmployerPhotoAddress() {
        return employerPhotoAddress;
    }

    public void setEmployerPhotoAddress(String employerPhotoAddress) {
        this.employerPhotoAddress = employerPhotoAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployerDomain that = (EmployerDomain) o;
        return Objects.equals(employerTel, that.employerTel) &&
                Objects.equals(employerPasswd, that.employerPasswd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employerTel, employerPasswd);
    }

    @Override
    public String toString() {
        return "EmployerDomain{" +
                "employerId=" + employerId +
                ", employerName='" + employerName + '\'' +
                ", employerTel='" + employerTel + '\'' +
                ", employerPasswd='" + employerPasswd + '\'' +
                ", employerCompanyId=" + employerCompanyId +
                ", employerAge=" + employerAge +
                ", employerGender='" + employerGender + '\'' +
                ", employerEmail='" + employerEmail + '\'' +
                ", employerPhotoAddress='" + employerPhotoAddress + '\'' +
                '}';
    }
}
