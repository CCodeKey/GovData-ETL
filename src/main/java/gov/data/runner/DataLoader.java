package gov.data.runner;

import gov.data.service.CargaDadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CargaDadosService cargaDadosService;

    @Override
    public void run(String... args) throws Exception {
        cargaDadosService.carregarDadosIniciais();
    }
}