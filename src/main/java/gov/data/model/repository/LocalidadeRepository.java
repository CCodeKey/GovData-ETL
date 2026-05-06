package gov.data.model.repository;

import gov.data.model.Localidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocalidadeRepository extends JpaRepository<Localidade, Long> {
    Optional<Localidade> findByMunicipioAndUf(String municipio, String uf);

}