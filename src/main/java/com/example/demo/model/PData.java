package com.example.demo.model;

public class PData {
    private String pId;
    private String pName;
    private long productExpirationDate;
    private String toSignTid;
    private String signedPData;

    public PData(String pId, String pName, long productExpirationDate, String toSignTid, String signedPData) {
        this.pId = pId;
        this.pName = pName;
        this.productExpirationDate = productExpirationDate;
        this.toSignTid = toSignTid;
        this.signedPData = signedPData;
    }

    public PData(PData pdata) {
        this.pId = pdata.pId;
        this.pName = pdata.pName;
        this.productExpirationDate = pdata.productExpirationDate;
        this.toSignTid = pdata.toSignTid;
        this.signedPData = pdata.signedPData;
    }


    public String calculateHash() {
        return StringUtil.applySha256(
                pId + pName + Long.toString(productExpirationDate) + toSignTid + signedPData
        );
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public long getProductExpirationDate() {
        return productExpirationDate;
    }

    public void setProductExpirationDate(long productExpirationDate) {
        this.productExpirationDate = productExpirationDate;
    }

    public String getToSignTid() {
        return toSignTid;
    }

    public void setToSignTid(String toSignTid) {
        this.toSignTid = toSignTid;
    }

    public String getSignedPData() {
        return signedPData;
    }

    public void setSignedPData(String signedPData) {
        this.signedPData = signedPData;
    }
}
