package com.springboot.bikini.model;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
public class PositionDomain {
    private int positionId;
    private String positionName;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date positionCreateDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date positionDeadline;
    private String positionEducation;
    private int positionEmployerId;
    private String positionType;
    private int positionSalaryLow;
    private int positionSalaryTop;
    private String positionExperience;
    private String positionDescription;

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Date getPositionDeadline() {
        return positionDeadline;
    }

    public void setPositionDeadline(Date positionDeadline) {
        this.positionDeadline = positionDeadline;
    }

    public String getPositionEducation() {
        return positionEducation;
    }

    public void setPositionEducation(String positionEducation) {
        this.positionEducation = positionEducation;
    }

    public int getPositionEmployerId() {
        return positionEmployerId;
    }

    public void setPositionEmployerId(int positionEmployerId) {
        this.positionEmployerId = positionEmployerId;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public int getPositionSalaryLow() {
        return positionSalaryLow;
    }

    public void setPositionSalaryLow(int positionSalaryLow) {
        this.positionSalaryLow = positionSalaryLow;
    }

    public int getPositionSalaryTop() {
        return positionSalaryTop;
    }

    public void setPositionSalaryTop(int positionSalaryTop) {
        this.positionSalaryTop = positionSalaryTop;
    }

    public String getPositionExperience() {
        return positionExperience;
    }

    public void setPositionExperience(String positionExperience) {
        this.positionExperience = positionExperience;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }
}
