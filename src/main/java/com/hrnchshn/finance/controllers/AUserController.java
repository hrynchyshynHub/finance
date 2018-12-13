package com.hrnchshn.finance.controllers;

import com.hrnchshn.finance.models.AUser;

import java.util.List;

@RestController
@RequestMapping()
public class AUserController {
    @GetMapping
    public List<AUser> getUsers(){

    }
}
