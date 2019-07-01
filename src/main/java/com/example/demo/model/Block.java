package com.example.demo.model;

public class Block {


    public String hash;
    public String previousHash;
//    private String data; //our data will be a simple message.

    HeaderBlock headerBlock;
    ValidationBlock validationBlock;
    DataBlock dataBlock;

    //TODO: Remove
    public Block() {

        this.hash = calculateHash(); //Making sure we do this after we set the other values.
    }
    public Block(BlockUpdateModel blockUpdateModel)
    {
        headerBlock = new HeaderBlock(blockUpdateModel.headerBlock);
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
}