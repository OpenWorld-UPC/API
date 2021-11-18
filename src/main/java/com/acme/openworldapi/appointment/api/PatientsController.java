package com.acme.openworldapi.appointment.api;

import com.acme.openworldapi.appointment.domain.model.entity.Patient;
import com.acme.openworldapi.appointment.domain.service.PatientService;
import com.acme.openworldapi.appointment.mapping.PatientMapper;
import com.acme.openworldapi.appointment.resource.CreatePatientResource;
import com.acme.openworldapi.appointment.resource.PatientResource;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientsController {
    private final PatientService patientService;

    private final PatientMapper mapper;

    public PatientsController(PatientService patientService, PatientMapper patientMapper) {
        this.patientService = patientService;
        this.mapper = patientMapper;
    }

    @GetMapping
    public List<Patient> getAllPatients(){
        return patientService.getAll();
    }

    @GetMapping("/{patientId}")
    public Patient getPatientById(@PathVariable Long patientId) {
        return patientService.getById(patientId); }

    @PostMapping
    public PatientResource createPatient(@Valid @RequestBody CreatePatientResource resource) {
        return mapper.toResource(patientService.create(mapper.toModel(resource)));
    }
}
