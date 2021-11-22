package com.acme.openworldapi.appointment.resource;

import com.acme.openworldapi.appointment.domain.model.entity.enums.Status;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@With
public class CreateReservationResource {
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
    @Enumerated(EnumType.ORDINAL)
    private Status status;

}
