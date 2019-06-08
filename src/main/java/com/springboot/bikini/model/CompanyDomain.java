package com.springboot.bikini.model;

public class CompanyDomain {
    private int companyId;
    private String companyName;
    private String companyType;
    private int companyStaffNum;
    private String companyAddress;
    private String companyDescription;
    private int companyCvNum;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public int getCompanyStaffNum() {
        return companyStaffNum;
    }

    public void setCompanyStaffNum(int companyStaffNum) {
        this.companyStaffNum = companyStaffNum;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public int getCompanyCvNum() {
        return companyCvNum;
    }

    public void setCompanyCvNum(int companyCvNum) {
        this.companyCvNum = companyCvNum;
    }
}
