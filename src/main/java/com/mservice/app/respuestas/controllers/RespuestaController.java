package com.mservice.app.respuestas.controllers;

import com.mservice.app.respuestas.models.entity.Respuesta;
import com.mservice.app.respuestas.service.IRespuestaService;
import com.mservice.generic.controllers.GenericController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RespuestaController extends GenericController<Respuesta, IRespuestaService> {

    @Override
    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/saveAll")
    public ResponseEntity<?> saveAll(@Valid @RequestBody Iterable<Respuesta> lstRespuestas, BindingResult result){
        lstRespuestas =((List<Respuesta>) lstRespuestas).stream().map(respuesta -> {
            respuesta.setAlumnoId(respuesta.getAlumno().getId());
            return respuesta;
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveAll(lstRespuestas));
    }

    @GetMapping("/alumno/{alumnoId}/examen/{examenId}")
    public ResponseEntity<?> findRespuestaByAlumnoByExamen(@PathVariable Long alumnoId, @PathVariable Long examenId){
        return ResponseEntity.ok().body(service.findRespuestaByAlumnoByExamen(alumnoId, examenId));
    }

    @GetMapping("/alumno/{alumnoId}/examenes-respondidos")
    public ResponseEntity<?> obtenerExamenesIdConRespuestaAlumno(@PathVariable Long alumnoId){
        return ResponseEntity.ok().body(service.findExamenesIdConRespuestasByAlumno(alumnoId));
    }
}
