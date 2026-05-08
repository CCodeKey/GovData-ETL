package gov.data.controller;

import gov.data.model.Servidor;
import gov.data.model.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ServidorController {

    @Autowired
    private ServidorRepository servidorRepository;

    @GetMapping("/servidores")
    public String listarServidores(Model model) {

        List<Servidor> servidores =
                servidorRepository.findAll();

        model.addAttribute("servidores", servidores);

        return "servidores";
    }
}