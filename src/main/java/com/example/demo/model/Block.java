package com.example.demo.model;

public class Block {


    private String hash = "";
//    private String data; //our data will be a simple message.

    private HeaderBlock headerBlock;
    private ValidationBlock validationBlock;
    private DataBlock dataBlock;

    //TODO: Remove
    public Block() {
        this.hash = calculateHash(); //Making sure we do this after we set the other values.
    }
    public Block(AppendBlockData appendBlockData)
    {
        headerBlock = new HeaderBlock(appendBlockData.headerBlock);
        validationBlock = new ValidationBlock(appendBlockData.validationBlock);
        dataBlock = new DataBlock(appendBlockData.dataBlock);

        hash = calculateHash();

    }

    public Block(InitialBlockData initialBlockData) {
        headerBlock = new HeaderBlock(initialBlockData);
        validationBlock = new ValidationBlock(initialBlockData.getValidationSignatures());
        dataBlock = new DataBlock(initialBlockData);

        hash = calculateHash();
    }

    public Block(HeaderBlock headerBlock, ValidationBlock validationBlock, DataBlock dataBlock) {
        this.headerBlock = headerBlock;
        this.validationBlock = validationBlock;
        this.dataBlock = dataBlock;

        this.hash = calculateHash(); //Making sure we do this after we set the other values.

    }

    //Calculate new hash based on blocks contents
    public String calculateHash() {
        return StringUtil.applySha256(
                headerBlock.calculateHash() + dataBlock.calculateHash() + validationBlock.calculateHash()
        );
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return this.headerBlock.previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.headerBlock.previousHash = previousHash;
    }

    public HeaderBlock getHeaderBlock() {
        return headerBlock;
    }

    public void setHeaderBlock(HeaderBlock headerBlock) {
        this.headerBlock = headerBlock;
    }

    public ValidationBlock getValidationBlock() {
        return validationBlock;
    }

    public void setValidationBlock(ValidationBlock validationBlock) {
        this.validationBlock = validationBlock;
    }

    public DataBlock getDataBlock() {
        return dataBlock;
    }

    public void setDataBlock(DataBlock dataBlock) {
        this.dataBlock = dataBlock;
    }
}