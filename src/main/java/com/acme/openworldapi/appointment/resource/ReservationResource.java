package com.acme.openworldapi.appointment.resource;

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
    private Boolean status;
}
