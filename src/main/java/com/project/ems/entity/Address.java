package com.project.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;

    @Column(length = 255)
    private String addressLine1;
    @Column(length = 255)
    private String addressLine2;
    @Column(length = 100)
    private String city;
    @Column(length = 100)
    private String state;
    @Column(length = 20)
    private String postalCode;
    @Column(length = 100)
    private String country;

}
