package com.academic.erp_backend.entity;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
@Entity
@Data
@Builder
public class Employees {

    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int employee_id;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = true)
    private String title;

    @Column(nullable = true)
    private String photograph_path;

    @ManyToOne
    @JoinColumn(name = "department", referencedColumnName = "department_id", nullable = false)
    private Departments department;

    @Column(nullable = false)
    private String password;
}