package com.javalec.dto;

import java.sql.Timestamp;

public class BoardDto {

    long bId;
    String bName;
    String bTitle;
    String bContent;
    Timestamp bDate;
    int bHit;
    int bGroup;
    int bStep;
    int bIndent;
    int deleteFlag;

    public BoardDto() {

    }

    public BoardDto(long bId, String bName, String bTitle, String bContent, Timestamp bDate, int bHit, int bGroup,
            int bStep, int bIndent, int deleteFlag) {
        this.bId = bId;
        this.bName = bName;
        this.bTitle = bTitle;
        this.bContent = bContent;
        this.bDate = bDate;
        this.bHit = bHit;
        this.bGroup = bGroup;
        this.bStep = bStep;
        this.bIndent = bIndent;
        this.deleteFlag = deleteFlag;

    }
    
    public BoardDto(String bName, String bTitle, String bContent, Timestamp bDate, int bHit, int bGroup,
            int bStep, int bIndent) {
        
        this.bName = bName;
        this.bTitle = bTitle;
        this.bContent = bContent;
        this.bDate = bDate;
        this.bHit = bHit;
        this.bGroup = bGroup;
        this.bStep = bStep;
        this.bIndent = bIndent;

    }

    public long getbId() {
        return bId;
    }

    public void setbId(long bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbTitle() {
        return bTitle;
    }

    public void setbTitle(String bTitle) {
        this.bTitle = bTitle;
    }

    public String getbContent() {
        return bContent;
    }

    public void setbContent(String bContent) {
        this.bContent = bContent;
    }

    public Timestamp getbDate() {
        return bDate;
    }

    public void setbDate(Timestamp bDate) {
        this.bDate = bDate;
    }

    public int getbHit() {
        return bHit;
    }

    public void setbHit(int bHit) {
        this.bHit = bHit;
    }

    public int getbGroup() {
        return bGroup;
    }

    public void setbGroup(int bGroup) {
        this.bGroup = bGroup;
    }

    public int getbStep() {
        return bStep;
    }

    public void setbStep(int bStep) {
        this.bStep = bStep;
    }

    public int getbIndent() {
        return bIndent;
    }

    public void setbIndent(int bIndent) {
        this.bIndent = bIndent;
    }

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    
}
