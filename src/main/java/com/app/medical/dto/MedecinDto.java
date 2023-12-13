package com.app.medical.dto;

import com.app.medical.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedecinDto extends User {
    private String cin;
    private double rate;


    private List<String> specialities;
}
