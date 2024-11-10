package com.practice.dsa.lld.airlinesystem.entities;

import java.util.List;

public class Passenger {
    int id;
    String name;
    String email;
    String phnNumber;
    List<Belongings>  belongings;

    public Passenger(int id, String name, String email, String phnNumber, List<Belongings> belongings) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phnNumber = phnNumber;
        this.belongings = belongings;
    }
}
