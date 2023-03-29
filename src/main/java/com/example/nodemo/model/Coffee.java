package com.example.nodemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Entity(name = "coffees")
@Getter
@Setter
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer quantity;
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
/*    @ManyToMany
    private List<Order> coffeeOrders;*/
    @ManyToOne
    @JoinColumn (name = "favorites_id")
    private Favorites favorites;
//    @OneToMany
//    @JoinColumn (name = "rating_id")
//    private List<Rating> rating;
//    @CreationTimestamp
//    private ZonedDateTime createdDate;
//    @UpdateTimestamp
//    private ZonedDateTime updatedDate;

}
