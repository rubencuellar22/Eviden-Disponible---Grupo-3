package com.grupotres.back_personal_disponible.serviceImplMy8;


import com.grupotres.back_personal_disponible.model.Empleado;
import com.grupotres.back_personal_disponible.model.SkMethod;
import com.grupotres.back_personal_disponible.repository.SkMethodRepository;
import com.grupotres.back_personal_disponible.service.SkMethodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkMethodServiceImpl implements SkMethodService {

	@Autowired
    private SkMethodRepository skMethodRepository;

	@Override
	public List<Empleado> findBySkMethod(String skMethod) {
		return skMethodRepository.findBySkMethod(skMethod);
	}

   

}
