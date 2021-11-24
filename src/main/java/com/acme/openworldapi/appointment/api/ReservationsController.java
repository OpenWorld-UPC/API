package com.acme.openworldapi.appointment.api;

import com.acme.openworldapi.appointment.domain.service.ReservationService;
import com.acme.openworldapi.appointment.mapping.ReservationMapper;
import com.acme.openworldapi.appointment.resource.CreateReservationResource;
import com.acme.openworldapi.appointment.resource.ReservationResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/doctors/{doctorId}/reservations")
@CrossOrigin(origins = "http://localhost:8080")
public class ReservationsController {

    private final ReservationService reservationService;

    private final ReservationMapper mapper;

    public ReservationsController(ReservationService reservationService, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.mapper = reservationMapper;
    }

    @GetMapping
    public Page<ReservationResource> getAllReservationsByDoctorId(@PathVariable Long doctorId, Pageable pageable) {
        return mapper.modelListToPage(reservationService.getAllByDoctorId(doctorId), pageable);
    }

    @PostMapping
    public ReservationResource createReservation(@PathVariable Long doctorId,
                                         @RequestBody CreateReservationResource request) {
        return mapper.toResource(reservationService.create(doctorId, mapper.toModel(request)));
    }
}
