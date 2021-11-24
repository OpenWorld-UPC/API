package com.acme.openworldapi.appointment.api;

import com.acme.openworldapi.appointment.domain.model.entity.Doctor;
import com.acme.openworldapi.appointment.domain.service.DoctorService;
import com.acme.openworldapi.appointment.mapping.DoctorMapper;
import com.acme.openworldapi.appointment.resource.CreateDoctorResource;
import com.acme.openworldapi.appointment.resource.DoctorResource;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
@CrossOrigin(origins = "https://open-world-api-upc.herokuapp.com")
public class DoctorsController {
    private final DoctorService doctorService;

    private final DoctorMapper mapper;

    public DoctorsController(DoctorService doctorService, DoctorMapper doctorMapper) {
        this.doctorService = doctorService;
        this.mapper = doctorMapper;
    }

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAll();
    }

    @PostMapping
    public DoctorResource createDoctor(@Valid @RequestBody CreateDoctorResource resource) {
        return mapper.toResource(doctorService.create(mapper.toModel(resource)));
    }
}
