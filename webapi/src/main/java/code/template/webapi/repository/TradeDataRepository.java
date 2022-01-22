package code.template.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import code.template.webapi.entity.TradeData;

@Repository
public interface TradeDataRepository extends JpaRepository<TradeData, Long> {

}