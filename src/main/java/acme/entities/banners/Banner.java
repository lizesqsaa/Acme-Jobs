
package acme.entities.banners;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Banner extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@URL
	@Pattern(regexp = "^(http(s?):)([/|.|\\w|\\s|-])*\\.(?:jpg|gif|png)$")
	private String				picture;

	@NotBlank
	private String				slogan;

	@NotBlank
	@URL
	private String				targetURL;

}
