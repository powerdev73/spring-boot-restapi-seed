package com.workershigh.web.domain.consultation;

import com.workershigh.web.domain.consultation.enums.SpaceType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "tb_consultation")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private SpaceType space;

    @Column(length = 200, name = "company")
    private String company;

    @Column(length = 20, nullable = false, name = "phone")
    private String phone;

    @Column(length = 100, nullable = false, name = "email")
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createAt;
}
