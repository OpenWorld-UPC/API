package com.acme.openworldapi.appointment.resource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
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
    private Boolean status;
}
