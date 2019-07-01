package com.example.demo.model;

public class DataBlock {
    PData pdata;
    String src;
    String shippingAddress;
    int readCount;

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

    public String calculateHash() {
        return StringUtil.applySha256(
                pdata.toString() + src + shippingAddress + Integer.toString(readCount)
        );
    }
}
