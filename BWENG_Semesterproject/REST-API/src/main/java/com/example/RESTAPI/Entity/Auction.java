package com.example.RESTAPI.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Auction {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String name;

    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "auction_id",referencedColumnName = "id")
    private List<Product> products;
}