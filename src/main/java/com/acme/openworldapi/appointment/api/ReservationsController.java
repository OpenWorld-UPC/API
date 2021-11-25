package com.acme.openworldapi.appointment.api;

import com.acme.openworldapi.appointment.domain.model.entity.Reservation;
import com.acme.openworldapi.appointment.domain.service.ReservationService;
import com.acme.openworldapi.appointment.mapping.ReservationMapper;
import com.acme.openworldapi.appointment.resource.CreateDoctorResource;
import com.acme.openworldapi.appointment.resource.CreateReservationResource;
import com.acme.openworldapi.appointment.resource.DoctorResource;
import com.acme.openworldapi.appointment.resource.ReservationResource;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class ReservationsController {

    private final ReservationService reservationService;

    private final ReservationMapper mapper;

    public ReservationsController(ReservationService reservationService, ReservationMapper reservationMapper) {
        this.reservationService = reservationService;
        this.mapper = reservationMapper;
    }


    @CrossOrigin(origins = "https://openworld-77ae7.web.app")
    @PostMapping("/reservations")
    public ReservationResource createReservation(@Valid @RequestBody CreateReservationResource resource) {
        return mapper.toResource(reservationService.create(mapper.toModel(resource)));
    }

    @CrossOrigin(origins = "https://openworld-77ae7.web.app")
    @GetMapping("/patients/{patientId}/reservations/")
    public List<Reservation> getAllReservationsByPatientId(@PathVariable Long patientId){
        return reservationService.getAllReservationsByPatientId(patientId);
    }

    @CrossOrigin(origins = "https://openworld-77ae7.web.app")
    @GetMapping("/patients/{patientId}/doctors/{doctorId}/reservations/{reservationId}")
    public List<Reservation> getReservationByDoctorId(@PathVariable Long doctorId, @PathVariable Long patientId, @PathVariable Long reservationId){
        return reservationService.getReservationByDoctorIdAndPatientIdAndReservationId(doctorId, patientId, reservationId);
    }

    @CrossOrigin(origins = "https://openworld-77ae7.web.app")
    @GetMapping("/patients/{patientId}/doctors/{doctorId}/reservations")
    public List<Reservation> getReservationByDoctorId(@PathVariable Long doctorId, @PathVariable Long patientId){
        return reservationService.getAllReservationsByDoctorIdAndPatientId(doctorId, patientId);
    }

    @CrossOrigin(origins = "https://openworld-77ae7.web.app")
    @PostMapping("/patients/{patientId}/doctors/{doctorId}/reservations")
    public ReservationResource createReservation(@PathVariable Long doctorId,
                                                 @PathVariable Long patientId,
                                                 @Valid  @RequestBody CreateReservationResource request) {
        return mapper.toResource(reservationService.createByDoctorIdAndPatientId(doctorId, patientId, mapper.toModel(request)));
    }


}