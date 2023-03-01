package io.deneb.fraud.repository;

import io.deneb.fraud.model.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository
  extends JpaRepository<FraudCheckHistory, Integer> {
}
