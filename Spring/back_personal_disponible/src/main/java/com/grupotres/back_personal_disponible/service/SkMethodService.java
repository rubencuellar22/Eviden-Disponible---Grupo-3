package com.grupotres.back_personal_disponible.service;

import com.grupotres.back_personal_disponible.model.SkMethod;

import java.util.List;

public interface SkMethodService {
    List<SkMethod> findBySkMethod(String skMethod);
}
