package com.powerdev.web.domain.consultation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.powerdev.web.domain.consultation.enums.SpaceType;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createAt;
}
