package com.hrnchshn.finance.models;

import javax.persistence.Entity;

@
public class AUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
