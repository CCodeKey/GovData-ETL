package gov.data.controller;

import gov.data.model.repository.LocalidadeRepository;
import gov.data.model.repository.OrgaoRepository;
import gov.data.model.repository.PagamentoRepository;
import gov.data.model.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ServidorRepository servidorRepository;

    @Autowired
    private OrgaoRepository orgaoRepository;

    @Autowired
    private LocalidadeRepository localidadeRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("totalServidores",
                servidorRepository.count());

        model.addAttribute("totalOrgaos",
                orgaoRepository.count());

        model.addAttribute("totalLocalidades",
                localidadeRepository.count());

        model.addAttribute("totalPagamentos",
                pagamentoRepository.count());

        return "index";
    }
}