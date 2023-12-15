package com.example.easymytrip;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class oyo {
    @GetMapping("/myoyo")
    public String getData() {
        return "Please book your hhhh Flight ticket, Choose Your Fav Hotel"; }
}