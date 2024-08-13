package com.example.native_CLI_Application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder @ToString
public class Produit {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;
}
