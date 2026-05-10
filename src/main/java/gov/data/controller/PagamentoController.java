package gov.data.controller;

import gov.data.model.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @GetMapping("/")
    public String listarPagamentos(Model model) {

        model.addAttribute(
                "pagamentos",
                pagamentoRepository.findTop100ByOrderByIdDesc()
        );
        return "index";
    }
}