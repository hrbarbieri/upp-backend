package br.com.petz.upp.domain.repository;

import br.com.petz.upp.domain.model.GroupOptins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GroupOptinsRepository extends JpaRepository<GroupOptins, UUID> {

    Optional<GroupOptins> findByGroupNameIgnoreCase(String groupName);
}
