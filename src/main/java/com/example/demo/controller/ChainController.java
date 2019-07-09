package com.example.demo.controller;

import com.example.demo.model.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChainController {

    private static BlockChain blockchain = new BlockChain();


    @GetMapping(value = "/chain", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Block> getChain() {
        return blockchain.getBlockChain();
    }

    @PostMapping("/chain")
    String addToChain(@RequestBody AppendBlockData newBlock) {
        blockchain.add(new Block(newBlock));
        return "SUCCESS";
    }

    @PostMapping("/init")
    String initializeChain(@RequestBody InitialBlockData newBlock) {
        if(blockchain.add(newBlock)) {
            return "SUCCESS";
        } else {
            return "FAILED";
        }
    }

/*    @PostMapping("/init")
    String initializeChain() {
        blockchain.add(new Block(new AppendBlockData(new HeaderBlock("", 0, 50, 0, ""), new ValidationBlock(new ArrayList<>()), new DataBlock(new PData("pID", "pName", 0000, "to Sign TID", "SIGNED DATA"), "src", "Shipping Address", 0))));
        return "SUCCESS";
    }*/

    @GetMapping("/chain/verify")
    public Boolean isChainValid() {
        return blockchain.isChainValid();
    }

}
