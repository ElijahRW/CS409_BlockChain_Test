package com.example.demo.model;

public class AppendBlockData {

    public HeaderBlock headerBlock;
    public ValidationBlock validationBlock;
    public DataBlock dataBlock;

    public AppendBlockData(HeaderBlock headerBlock, ValidationBlock validationBlock, DataBlock dataBlock) {
        this.headerBlock = headerBlock;
        this.validationBlock = validationBlock;
        this.dataBlock = dataBlock;
    }
}
