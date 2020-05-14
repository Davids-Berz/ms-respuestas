package com.mservice.app.respuestas.models.repository;

import com.mservice.app.respuestas.models.entity.Respuesta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRespuestaRepository extends PagingAndSortingRepository<Respuesta, Long> {

    @Query("select r from Respuesta r join fetch r.pregunta p " +
            "join fetch p.examen e where r.alumnoId=?1 and e.id=?2")
    Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId);


    @Query("select e.id from Respuesta r join r.pregunta p " +
            "join p.examen e where r.alumnoId=?1 group by e.id")
    Iterable<Long> findExamenesIdConRespuestasByAlumno(Long alumnoId);
}
