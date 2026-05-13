package gov.data.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriterUtil {

    public static void escreverCsvTratado(List<String[]> dados) {
        String caminho = "src/main/resources/data/output/dados_tratados.csv";
        
        try (FileWriter writer = new FileWriter(caminho)) {
            writer.append("CO_ORGAO;NO_ORGAO;MUNICIPIO;UF;MAT_SERV;NO_SERVIDOR;GRUPO_CARGO;CARGO_FUNCAO;VALOR_AUXILIO;COTA_PARTE\n");

            for (String[] linha : dados) {
                writer.append(String.join(";", linha));
                writer.append("\n");
            }
            System.out.println("Arquivo CSV tratado!");

        } catch (IOException e) {
            System.err.println("Erro ao gerar CSV tratado: " + e.getMessage());
        }
    }
}