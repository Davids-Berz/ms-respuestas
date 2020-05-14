package com.mservice.app.respuestas.service;

import com.mservice.app.respuestas.models.entity.Respuesta;
import com.mservice.app.respuestas.models.repository.IRespuestaRepository;
import com.mservice.generic.services.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RespuestaServiceImpl extends GenericServiceImpl<Respuesta, IRespuestaRepository> implements IRespuestaService {

    @Override
    @Transactional
    public Iterable<Respuesta> saveAll(Iterable<Respuesta> lstRespuestas) {
        return repository.saveAll(lstRespuestas) ;
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId) {
        return repository.findRespuestaByAlumnoByExamen(alumnoId, examenId);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Long> findExamenesIdConRespuestasByAlumno(Long alumnoId) {
        return repository.findExamenesIdConRespuestasByAlumno(alumnoId);
    }

}
