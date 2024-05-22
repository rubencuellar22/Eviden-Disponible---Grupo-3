package com.grupotres.back_personal_disponible.service;

import com.grupotres.back_personal_disponible.model.Grupo;

import java.util.List;

public interface GrupoService {
    void saveAllGroups(List<Grupo> grupoList);
}
