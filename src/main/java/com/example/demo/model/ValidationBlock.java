package com.example.demo.model;

import java.util.List;

public class ValidationBlock {
    List<String> signature;

    public ValidationBlock(List<String> signature) {
        this.signature = signature;
    }

    public String calculateHash() {
        return StringUtil.applySha256(
                signature.toString()
        );
    }
}
