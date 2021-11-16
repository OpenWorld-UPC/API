package com.acme.openworldapi.appointment.resource;


import com.acme.openworldapi.appointment.domain.model.entity.enums.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationResource {
    private Long id;
    private String title;
    private String content;
    private String meetUrl;
    private String meetDate;
    private Status status;
}
