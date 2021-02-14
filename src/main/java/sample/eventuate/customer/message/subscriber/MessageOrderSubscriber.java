package sample.eventuate.customer.message.subscriber;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.messaging.consumer.MessageConsumer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import sample.eventuate.customer.message.dto.MessageCustomerCreditReqDto;
import sample.eventuate.customer.message.service.MessageCustomerService;

@Slf4j
@Configuration
@AllArgsConstructor
public class MessageOrderSubscriber {
	
	private MessageConsumer messageConsumer;
	
	private MessageCustomerService messageCustomerService;

	//@PostConstruct
	private void messageHandlers() {
		messageConsumer.subscribe("sample-customer", Collections.singleton("order-message"), this::handleMessage);
	}
	
	public void handleMessage(Message message) {
		
		MessageCustomerCreditReqDto customerCreditReqDto = new Gson().fromJson(message.getPayload(), MessageCustomerCreditReqDto.class);
		
		try {
			messageCustomerService.deductCostomerCredit(customerCreditReqDto);
		}catch(Exception e) {
			log.error("exception occurred during handleMessage: {}", e);
		}
	}
}
