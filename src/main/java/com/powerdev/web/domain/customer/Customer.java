package com.powerdev.web.domain.customer;

import com.powerdev.web.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@Entity
@Table(name = "tb_customer")
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    Integer id;

    @Column(length = 30, nullable = false, unique = true, name = "customer_code")
    String customerCode;

    @Column(length = 20, nullable = false, name = "name")
    String name;

    @Column(length = 100, nullable = false, name = "email")
    String email;

    @Column(length = 20, nullable = false, name = "phone")
    String phone;

    @Column(length = 1, name = "gender")
    String gender;

    @Column(length = 8, name = "age")
    String age;
}
