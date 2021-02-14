package sample.eventuate.customer.message.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class MessageCustomerResDto {
	
	private Long id;
	
	private String customerName;
	
	private BigDecimal credit;

}
