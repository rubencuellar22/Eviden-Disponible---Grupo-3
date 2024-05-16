package com.grupotres.back_personal_disponible.restController;


import com.grupotres.back_personal_disponible.model.SkMethod;
import com.grupotres.back_personal_disponible.service.SkMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empleado/sk_methods")
public class SkMethodRestController {

    private final SkMethodService skMethodService;

    @Autowired
    public SkMethodRestController(SkMethodService skMethodService) {
        this.skMethodService = skMethodService;
    }

    @GetMapping("/{skMethod}")
    public List<SkMethod> findBySkMethod(@PathVariable String skMethod) {
        return skMethodService.findBySkMethod(skMethod);
    }
}
