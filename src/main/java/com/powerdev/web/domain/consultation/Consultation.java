package com.powerdev.web.domain.consultation;

import com.powerdev.web.domain.BaseEntity;
import com.powerdev.web.domain.consultation.enums.SpaceType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@Entity
@Table(name = "tb_consultation")
public class Consultation extends BaseEntity {
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
}
