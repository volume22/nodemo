package com.example.nodemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ratings")
@Getter
@Setter
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double remark;
    @ManyToOne
    @JoinColumn (name = "coffee_id")
    private Coffee coffee;
}
