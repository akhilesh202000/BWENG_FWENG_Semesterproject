package com.example.RESTAPI.Repository;

import com.example.RESTAPI.Entity.Auction;
import org.springframework.data.repository.CrudRepository;

public interface AuctionRepository extends CrudRepository<Auction, Integer> {
}