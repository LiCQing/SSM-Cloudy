package com.jsu.pojo;

public class TbFileMapper {
    private Integer mId;

    private String mMd5;

    private String mPath;

    private Long mSize;

    private Integer mSatus;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmMd5() {
        return mMd5;
    }

    public void setmMd5(String mMd5) {
        this.mMd5 = mMd5 == null ? null : mMd5.trim();
    }

    public String getmPath() {
        return mPath;
    }

    public void setmPath(String mPath) {
        this.mPath = mPath == null ? null : mPath.trim();
    }

    public Long getmSize() {
        return mSize;
    }

    public void setmSize(Long mSize) {
        this.mSize = mSize;
    }

    public Integer getmSatus() {
        return mSatus;
    }

    public void setmSatus(Integer mSatus) {
        this.mSatus = mSatus;
    }
}