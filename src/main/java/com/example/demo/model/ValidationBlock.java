package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class ValidationBlock {
    public List<String> signatures;

    public ValidationBlock() {
        signatures = new ArrayList<>();
    }

    public ValidationBlock(List<String> signatures) {
        this.signatures = new ArrayList<>();
        if(signatures != null)
            this.signatures.addAll(signatures);
    }

    public ValidationBlock(ValidationBlock validationBlock) {
        this.signatures = new ArrayList<>();
        if(validationBlock != null) {
            this.signatures.addAll(validationBlock.signatures);
        }
    }

    public String calculateHash() {
        return StringUtil.applySha256(
                signatures.toString()
        );
    }
}
