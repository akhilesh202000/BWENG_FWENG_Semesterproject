package com.example.RESTAPI.Controller;

import com.example.RESTAPI.Repository.AuctionRepository;
import com.example.RESTAPI.Entity.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AuctionController {
    @Autowired
    private final AuctionRepository auctionRepository;

    public AuctionController(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @CrossOrigin
    @GetMapping("/auctions")
    public @ResponseBody Iterable<Auction> getAuctions() {
        return auctionRepository.findAll();
    }

    @CrossOrigin
    @PostMapping("/auctions")
    public @ResponseBody Auction postAuction(@RequestBody @Valid Auction newAuction) {
        return auctionRepository.save(newAuction);
    }

}