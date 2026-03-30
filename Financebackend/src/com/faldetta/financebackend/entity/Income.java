package com.faldetta.financebackend.entity;

import jakarta.persistence.*;

@Entity
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String source;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() { return id; }
    public String getSource() { return source; }
    public double getAmount() { return amount; }
    public User getUser() { return user; }

    public void setId(Long id) { this.id = id; }
    public void setSource(String source) { this.source = source; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setUser(User user) { this.user = user; }
}