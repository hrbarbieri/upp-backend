package br.com.petz.upp.domain.repository;

import br.com.petz.upp.domain.model.CustomerOptinsHistory;
import br.com.petz.upp.domain.model.CustomerOptinsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOptionsHistoryRepository extends JpaRepository<CustomerOptinsHistory, CustomerOptinsId> {
}
