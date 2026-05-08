package gov.data.controller;

import gov.data.model.repository.OrgaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrgaoController {

    @Autowired
    private OrgaoRepository orgaoRepository;

    @GetMapping("/orgaos")
    public String listarOrgaos(Model model) {

        model.addAttribute(
                "orgaos",
                orgaoRepository.findAll()
        );

        return "orgaos";
    }
}