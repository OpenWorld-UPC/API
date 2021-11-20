package com.acme.openworldapi.appointment.mapping;

import com.acme.openworldapi.appointment.domain.model.entity.Reservation;
import com.acme.openworldapi.appointment.resource.CreateReservationResource;
import com.acme.openworldapi.appointment.resource.ReservationResource;
import com.acme.openworldapi.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ReservationMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    //Object Mapping

    public ReservationResource toResource(Reservation model){
        return mapper.map(model, ReservationResource.class);
    }

    public Page<ReservationResource> modelListToPage(List<Reservation> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, ReservationResource.class), pageable, modelList.size());
    }

    public Reservation toModel(CreateReservationResource resource) {
        return mapper.map(resource, Reservation.class);
    }

    /**
     public Reservation toModel(UpdateReservationResource resource){
     return mapper.map(resource, Reservation.class);
     }
     **/
}
