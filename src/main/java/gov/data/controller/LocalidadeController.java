package gov.data.controller;

import gov.data.model.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocalidadeController {

    @Autowired
    private LocalidadeRepository localidadeRepository;

    @GetMapping("/localidades")
    public String listarLocalidades(Model model) {

        model.addAttribute(
                "localidades",
                localidadeRepository.findAll()
        );

        return "localidades";
    }
}