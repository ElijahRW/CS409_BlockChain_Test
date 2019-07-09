package com.example.demo.model;

import java.util.ArrayList;

public class InitialBlockData {
    //Header Values
    private String id;
    private int fee;

    //Validation Values
    private ArrayList<String> validationSignatures;

    private PData pData;
    private String sourceAddress;
    private String destinationAddress;
//    int readCount; // there is no need for a read count


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public ArrayList<String> getValidationSignatures() {
        return validationSignatures;
    }

    public void setValidationSignatures(ArrayList<String> validationSignatures) {
        this.validationSignatures = validationSignatures;
    }

    public PData getpData() {
        return pData;
    }

    public void setpData(PData pData) {
        this.pData = pData;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }
}
