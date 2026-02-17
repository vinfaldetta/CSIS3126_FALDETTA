package com.Faldetta.finacebackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/api")
public class TransactionController {

    @GetMapping("/transactions")
    public List<String> transactions() {
        return List.of("Food", "Rent", "Gas");
    }
}

