package com.yahoo.tillyqb.springboot.magic_card_deck_tracker.controller;

import com.yahoo.tillyqb.springboot.magic_card_deck_tracker.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController
{
    @PostMapping
    public User createUser(@Valid User user)
    {
        //put your code here
        return null;
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable String userName)
    {
        //put your code here
        return null;
    }
}
