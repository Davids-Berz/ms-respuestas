package com.mservice.app.respuestas.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mservice.commons.alumnos.models.entity.Alumno;
import com.mservice.commons.examenes.models.entity.Pregunta;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "respuestas")
public class Respuesta {

    public Respuesta(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;

    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    //@ManyToOne(fetch = FetchType.LAZY)
    @Transient
    private Alumno alumno;

    @Column(name = "alumno_id")
    private Long AlumnoId;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY)
    private Pregunta pregunta;

}
