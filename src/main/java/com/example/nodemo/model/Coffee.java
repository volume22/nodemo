package com.example.nodemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

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
    @ManyToMany
    private List<Order> coffeeOrders;
    @ManyToOne
    @JoinColumn(name = "like_id")
    private Like like;
//    @CreationTimestamp
//    private ZonedDateTime createdDate;
//    @UpdateTimestamp
//    private ZonedDateTime updatedDate;

}
