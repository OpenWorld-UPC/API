package com.acme.openworldapi.appointment.domain.model.entity;

import com.acme.openworldapi.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "reservations")
public class Reservation extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String title;

    @NotNull
    @Lob
    private String content;

    @NotNull
    @NotBlank
    @Size(max = 1000)
    private String meetUrl;

    @NotNull
    @NotBlank
    @Size(max = 1000)
    private String meetDate;

    @NotNull
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
}
