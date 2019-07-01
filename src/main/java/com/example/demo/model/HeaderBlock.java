package com.example.demo.model;

public class HeaderBlock {
    String blockChainId;
    int height;
    int fee;
    long time;
    String previousHash;

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
