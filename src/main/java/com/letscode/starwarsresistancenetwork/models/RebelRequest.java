package com.letscode.starwarsresistancenetwork.models;

import com.letscode.starwarsresistancenetwork.Enums.RebelGender;
import lombok.Data;

import java.util.List;

@Data
public class RebelRequest {

    private String name;
    private int age;
    private RebelGender gender;
    private Location location;
    private List<Item> inventory;
}
