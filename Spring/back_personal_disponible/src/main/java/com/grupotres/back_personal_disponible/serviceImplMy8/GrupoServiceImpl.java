package com.grupotres.back_personal_disponible.serviceImplMy8;

import com.grupotres.back_personal_disponible.model.Grupo;
import com.grupotres.back_personal_disponible.repository.GrupoRepository;
import com.grupotres.back_personal_disponible.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoServiceImpl implements GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    @Override
    public void saveAllGroups(List<Grupo> grupoList) {
        grupoRepository.saveAll(grupoList);
    }

    @Override
    public List<Grupo> getAllGrupos() {
        return grupoRepository.findAll();
    }

    @Override
    public void deleteAllGrupos() {
        grupoRepository.deleteAllInBatch();
    }
}
