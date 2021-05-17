package br.com.petz.upp.domain.repository;

import br.com.petz.upp.domain.model.GroupOptins;
import br.com.petz.upp.domain.model.Optins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OptinsRepository extends JpaRepository<Optins, UUID> {

    Optional<Optins> findByOptinsNameIgnoreCaseAndGroupId(String optinsName, UUID groupId);
}
