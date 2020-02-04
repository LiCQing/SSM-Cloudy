package com.jsu.pojo;

import java.util.Date;

public class TbFile {
    private Integer fId;

    private String fName;

    private Long fSize;

    private Date fCreateTime;

    private Integer fCate;  //文件分类
    

    private Date fDeleteTime;

    private Integer fStatus;

    private Integer isDir;

    private Integer pId;

    private Integer uId;

    private Integer mId;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName == null ? null : fName.trim();
    }

    public Long getfSize() {
        return fSize;
    }

    public void setfSize(Long fSize) {
        this.fSize = fSize;
    }

    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public Integer getfCate() {
        return fCate;
    }

    public void setfCate(Integer fCate) {
        this.fCate = fCate;
    }

    public Date getfDeleteTime() {
        return fDeleteTime;
    }

    public void setfDeleteTime(Date fDeleteTime) {
        this.fDeleteTime = fDeleteTime;
    }

    public Integer getfStatus() {
        return fStatus;
    }

    public void setfStatus(Integer fStatus) {
        this.fStatus = fStatus;
    }

    public Integer getIsDir() {
        return isDir;
    }

    public void setIsDir(Integer isDir) {
        this.isDir = isDir;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }
}