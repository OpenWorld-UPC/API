package com.acme.openworldapi.appointment.api;

import com.acme.openworldapi.appointment.domain.service.ReservationService;
import com.acme.openworldapi.appointment.mapping.ReservationMapper;
import com.acme.openworldapi.appointment.resource.CreateReservationResource;
import com.acme.openworldapi.appointment.resource.ReservationResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/patients/{patientId}/doctors/{doctorId}/reservations/")
public class ReservationsController {

    private final ReservationService reservationService;

    private final ReservationMapper mapper;

    public ReservationsController(ReservationService reservationService, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.mapper = reservationMapper;
    }

    @CrossOrigin(origins = "https://openworld-77ae7.web.app")
    @GetMapping
    public Page<ReservationResource> getAllReservationsByDoctorId(@PathVariable Long doctorId,
                                                                  @PathVariable Long patientId,
                                                                  Pageable pageable) {
        return mapper.modelListToPage(reservationService.getAllByDoctorIdPatientId(doctorId, patientId), pageable);
    }


    @CrossOrigin(origins = "https://openworld-77ae7.web.app")
    @PostMapping
    public ReservationResource createReservation(@PathVariable Long doctorId,
                                                 @PathVariable Long patientId,
                                                 @Valid  @RequestBody CreateReservationResource request) {
        return mapper.toResource(reservationService.create(doctorId, patientId, mapper.toModel(request)));
    }
}