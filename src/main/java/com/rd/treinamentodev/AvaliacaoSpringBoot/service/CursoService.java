package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public String cadastrarCurso(CursoDTO cursoDTO){
        CursoEntity cursoEntity = new CursoEntity();

        cursoEntity.setNomeCurso(cursoDTO.getNome());
        cursoEntity.setNrCargaHoraria(cursoDTO.getCargaHoraria());


        cursoRepository.save(cursoEntity);

        return "Cadastro realizado com sucesso" + cursoEntity.getIdCurso();
    }

    public List<CursoEntity> buscarCursos(Long idCursos){
        return cursoRepository.findAll();
    }


    public List<CursoEntity> consultarPorNome(String nomeCurso){
        return cursoRepository.findBynomeCurso(nomeCurso);
    }
}