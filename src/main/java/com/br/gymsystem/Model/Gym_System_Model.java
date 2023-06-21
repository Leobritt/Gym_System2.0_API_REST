package com.br.gymsystem.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.tool.schema.internal.Helper;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "gym_system_records")
public class Gym_System_Model implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = false, length = 120)
    private String gym_member_name;

    @Column(nullable = false, unique = false, length = 60)
    private String gym_member_sex;

    @Column(nullable = false)
    private Double gym_member_weight;

    @Column(nullable = false)
    private Double gym_member_height;

    @Column(nullable = false)
    private LocalDateTime gym_member_registrationDate;

}
