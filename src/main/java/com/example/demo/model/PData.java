package com.example.demo.model;

public class PData {
    String pId;
    String pName;
    long productExpirationDate;
    String toSignTid;
    String signedPData;

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
}
