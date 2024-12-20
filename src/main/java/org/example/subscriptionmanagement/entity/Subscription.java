package org.example.subscriptionmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tier;
    private Double price;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Subscription() {}

    public Subscription(String tier, Double price, LocalDate startDate, LocalDate endDate, User user) {
        this.tier = tier;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
    }
}
