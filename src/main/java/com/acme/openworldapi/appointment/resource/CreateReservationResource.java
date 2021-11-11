package com.acme.openworldapi.appointment.resource;

import com.acme.openworldapi.appointment.domain.model.entity.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
<<<<<<< HEAD
    @Enumerated(EnumType.ORDINAL)
    private Status status;
=======
    private Boolean status;
>>>>>>> abeedd65e10ad25a65e482785a038b5b0e4a4354
}
