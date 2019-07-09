package com.example.demo.model;

public class DataBlock {
    private PData pdata;
    private String src;
    private String shippingAddress;
    private int readCount;

    public DataBlock(PData pdata, String src, String shippingAddress, int readCount) {
        this.pdata = new PData(pdata);
        this.src = src;
        this.shippingAddress = shippingAddress;
        this.readCount = readCount;
    }

    public DataBlock(DataBlock dataBlock) {
        this.pdata = new PData(dataBlock.pdata);
        this.src = dataBlock.src;
        this.shippingAddress = dataBlock.shippingAddress;
        this.readCount = dataBlock.readCount;
    }

    public DataBlock(InitialBlockData initialBlockData) {
        this.pdata = initialBlockData.getpData();
        this.src = initialBlockData.getSourceAddress();
        this.shippingAddress = initialBlockData.getDestinationAddress();
        this.readCount = 0; // Note: It is assumed that the label has not been scanned yet.
    }

    public String calculateHash() {
        return StringUtil.applySha256(
                pdata.toString() + src + shippingAddress + Integer.toString(readCount)
        );
    }

    public PData getPdata() {
        return pdata;
    }

    public void setPdata(PData pdata) {
        this.pdata = pdata;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }
}
