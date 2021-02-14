package sample.eventuate.customer.message.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sample.eventuate.customer.message.entity.MessageCustomerEntity;

@Repository
public interface MessageCustomerRepository extends JpaRepository<MessageCustomerEntity, Long>{

}
