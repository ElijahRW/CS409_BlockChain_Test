package com.example.demo.model;

public class BlockUpdateModel {

    public HeaderBlock headerBlock;
    public ValidationBlock validationBlock;
    public DataBlock dataBlock;

    public BlockUpdateModel(HeaderBlock headerBlock, ValidationBlock validationBlock, DataBlock dataBlock) {
        this.headerBlock = headerBlock;
        this.validationBlock = validationBlock;
        this.dataBlock = dataBlock;
    }
}
