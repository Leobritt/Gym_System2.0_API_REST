package com.br.gymsystem.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Gym_System_DTO {

    private String gym_member_name;

    private String gym_member_sex;

    private Double gym_member_weight;

    private Double gym_member_height;

    private LocalDateTime gym_member_registrationDate;

}
