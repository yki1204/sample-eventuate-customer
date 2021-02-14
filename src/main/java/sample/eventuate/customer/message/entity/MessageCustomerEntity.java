package sample.eventuate.customer.message.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="customer_info")
@Entity
@Getter
@NoArgsConstructor
public class MessageCustomerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String customerName;
	
	private BigDecimal credit;

	@Builder
	public MessageCustomerEntity(Long id, String customerName, BigDecimal credit) {
		this.id = id;
		this.customerName = customerName;
		this.credit = credit;
	}
	
	public void deductCustomerCredit(BigDecimal credit) {
		
		if(this.credit.compareTo(credit) == -1) {
			throw new RuntimeException("CustomerCreditLimitExceeded");
		}
		
		this.credit = this.credit.subtract(credit);
	}
}
