
package acme.entities.banners;

import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CommercialBanner extends Banner {

	private static final long	serialVersionUID	= 1L;

	@Size(min = 16, max = 16)
	@Digits(fraction = 0, integer = 16)
	@CreditCardNumber
	private String				creditCardNumber;

	//	@NotBlank
	//	private String				holderName;
	//
	//	@NotBlank
	//	@Pattern(regexp = "^(0[1-9]|1[0-2])\\/([0-9]{2})$")
	//	private String				expirationMonthYear;
	//
	//	@NotBlank
	//	@Pattern(regexp = "^([0-9]{3,4})$")
	//	private String				cvv;

}
