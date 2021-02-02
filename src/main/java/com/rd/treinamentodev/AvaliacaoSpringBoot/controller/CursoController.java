package com.rd.treinamentodev.AvaliacaoSpringBoot.controller;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping("/curso")
        public ResponseEntity cadastrarCurso(@RequestBody CursoDTO cursoDTO ) {
            return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.cadastrarCurso(cursoDTO));

        }

    @GetMapping("/curso")
    public ResponseEntity buscarCursos(@PathParam("idCurso") Long idCurso){
        List<CursoEntity> cursos = cursoService.buscarCursos(idCurso);
        return ResponseEntity.status(HttpStatus.OK).body(cursos);
    }

    @GetMapping("/curso/{nomeCurso}")
    public ResponseEntity consultarPorNome(@PathVariable("nomeCurso") String nomeCurso){
        return ResponseEntity.status(HttpStatus.OK)
                .body(cursoService.consultarPorNome(nomeCurso));
    }
}