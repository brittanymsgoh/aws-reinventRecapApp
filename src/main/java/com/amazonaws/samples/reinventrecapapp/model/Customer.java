package com.amazonaws.samples.reinventrecapapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "customers")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;

}