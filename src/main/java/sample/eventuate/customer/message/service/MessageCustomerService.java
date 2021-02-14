package sample.eventuate.customer.message.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import sample.eventuate.customer.message.dto.MessageCustomerCreditReqDto;
import sample.eventuate.customer.message.dto.MessageCustomerResDto;
import sample.eventuate.customer.message.entity.MessageCustomerEntity;
import sample.eventuate.customer.message.repository.MessageCustomerRepository;

@Service
@Transactional
@AllArgsConstructor
public class MessageCustomerService {
	
	private MessageCustomerRepository messageCustomerRepository;
	
	public MessageCustomerResDto retrieveMessageCustomer(Long customerId) {
		MessageCustomerEntity messageCustomerEntity = messageCustomerRepository.findById(customerId).orElse(null);
		
		return toMessageCustomerResDto(messageCustomerEntity);
	}
	
	public void deductCostomerCredit(MessageCustomerCreditReqDto customerCreditReqDto){
		MessageCustomerEntity messageCustomerEntity = messageCustomerRepository.findById(customerCreditReqDto.getCustomerId()).orElse(null);
		
		if(messageCustomerEntity != null) {
			messageCustomerEntity.deductCustomerCredit(customerCreditReqDto.getPrice());
		}
	}
	
	public MessageCustomerResDto toMessageCustomerResDto(MessageCustomerEntity messageCustomerEntity) {
		
		if(messageCustomerEntity == null) {
			return null;
		}
		
		MessageCustomerResDto messageCustomerResDto = new MessageCustomerResDto();
		messageCustomerResDto.setId(messageCustomerEntity.getId());
		messageCustomerResDto.setCustomerName(messageCustomerEntity.getCustomerName());
		messageCustomerResDto.setCredit(messageCustomerEntity.getCredit());
		
		return messageCustomerResDto;
	}
	
}
