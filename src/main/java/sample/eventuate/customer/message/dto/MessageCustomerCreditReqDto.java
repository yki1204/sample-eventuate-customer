package sample.eventuate.customer.message.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class MessageCustomerCreditReqDto {
	
	private Long id;
	
	private String orderName;
	
	private Long customerId;
	
	private BigDecimal price;

}
