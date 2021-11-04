package com.acme.openworldapi.reserving.domain.model.entity;

import com.acme.openworldapi.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "doctors")
public class Doctor extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(unique = true)
    private String name;

    @NotNull
    @NotBlank
    private int age;

    @NotNull
    @NotBlank
    @Size(max = 1000)
    private String photoUrl;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String description;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String workplace;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String specialty;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String qualification;
}
