package com.example.demo.model;

public class HeaderBlock {
    public String blockChainId;
    public int height;
    public int fee;
    public long time;
    public String previousHash;

    public HeaderBlock(InitialBlockData initialBlockData) {
        this.blockChainId = initialBlockData.getId();
        this.height = 0;
        this.fee = initialBlockData.getFee();
        this.time = System.currentTimeMillis();
        this.previousHash = "";
    }

    public HeaderBlock(String blockChainId, int height, int fee, long time, String previousHash) {
        this.blockChainId = blockChainId;
        this.height = height;
        this.fee = fee;
        this.time = time;
        this.previousHash = previousHash;
    }

    public HeaderBlock(HeaderBlock headerBlock) {
        this.blockChainId = headerBlock.blockChainId;
        this.height = headerBlock.height;
        this.fee = headerBlock.fee;
        this.time = headerBlock.time;
        this.previousHash = headerBlock.previousHash;
    }

    public String calculateHash() {
        return StringUtil.applySha256(
                blockChainId + height + fee + time + previousHash
        );
    }
}
