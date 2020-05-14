package com.mservice.app.respuestas.service;

import com.mservice.app.respuestas.models.entity.Respuesta;
import com.mservice.generic.services.IGenericService;

public interface IRespuestaService extends IGenericService<Respuesta> {


    Iterable<Respuesta> saveAll(Iterable<Respuesta> lstRespuestas);
    Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId);
    Iterable<Long> findExamenesIdConRespuestasByAlumno(Long alumnoId);


}
