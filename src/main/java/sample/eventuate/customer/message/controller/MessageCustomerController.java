package sample.eventuate.customer.message.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sample.eventuate.customer.message.dto.MessageCustomerResDto;
import sample.eventuate.customer.message.service.MessageCustomerService;

@RestController
@AllArgsConstructor
public class MessageCustomerController {
	
	private MessageCustomerService messageCustomerService;
	
	@GetMapping("/message/customers/v1/{customerId}")
	public MessageCustomerResDto retrieveMessageCustomer(@PathVariable Long customerId){
		
		return messageCustomerService.retrieveMessageCustomer(customerId);
	}

}
