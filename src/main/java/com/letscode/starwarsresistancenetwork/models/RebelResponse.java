package com.letscode.starwarsresistancenetwork.models;

import com.letscode.starwarsresistancenetwork.Enums.RebelGender;
import com.letscode.starwarsresistancenetwork.Enums.RebelStatus;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
public class RebelResponse {

    private Long id;
    private String name;
    private int age;
    private RebelGender gender;
    private Location location;
    private List<Item> inventory;
    private RebelStatus status;

    public static RebelResponse of(Rebel rebel) {
        RebelResponse rebelResponse = new RebelResponse();
        BeanUtils.copyProperties(rebel, rebelResponse);
        return  rebelResponse;
    }
}
