package com.jsu.pojo;

import java.util.Date;

public class TbShare {
    private Integer sId;

    private Integer uId;

    private String sContent;

    private Date sCreateTime;

    private Integer sStatus;

    private Integer sValidDay;
    
    private String fName;
    

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getsContent() {
        return sContent;
    }

    public void setsContent(String sContent) {
        this.sContent = sContent == null ? null : sContent.trim();
    }

    public Date getsCreateTime() {
        return sCreateTime;
    }

    public void setsCreateTime(Date sCreateTime) {
        this.sCreateTime = sCreateTime;
    }

    public Integer getsStatus() {
        return sStatus;
    }

    public void setsStatus(Integer sStatus) {
        this.sStatus = sStatus;
    }

    public Integer getsValidDay() {
        return sValidDay;
    }

    public void setsValidDay(Integer sValidDay) {
        this.sValidDay = sValidDay;
    }

	@Override
	public String toString() {
		return "TbShare [sId=" + sId + ", uId=" + uId + ", sContent=" + sContent + ", sCreateTime=" + sCreateTime
				+ ", sStatus=" + sStatus + ", sValidDay=" + sValidDay + "]";
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}
    
    
}