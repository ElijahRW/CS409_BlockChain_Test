package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {

    private ArrayList<Block> blockchain = new ArrayList<>();
    private int difficulty = 5; //TODO: Replace with config value

    //This should ONLY be called after an initial block has been inserted.
    public boolean add(Block block) {
        if (blockchain.size() <= 0)
            return false;
        Block lastBlock = blockchain.get(blockchain.size() - 1);
        block.setPreviousHash(lastBlock.calculateHash());
        block.getHeaderBlock().height = lastBlock.getHeaderBlock().height + 1;
        block.setHash(block.calculateHash());
        blockchain.add(block);
        return true;
    }

    //Function will add the initial
    public boolean add(InitialBlockData initialBlock) {
        if (blockchain.size() >= 1) {
            return false;
        }
        Block insertionBlock = new Block(initialBlock);
        blockchain.add(insertionBlock);
        return true;
    }

    public List<Block> getBlockChain() {
        return blockchain;
    }

    public Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        //loop through blockchain to check hashes:
        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);
            //compare registered hash and calculated hash:
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }
}
