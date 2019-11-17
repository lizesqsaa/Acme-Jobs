
package acme.entities.banners;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class NonCommercialBanner extends Banner {

	private static final long	serialVersionUID	= 1L;

	@URL
	@Pattern(regexp = "^(http(s?):)([/|.|\\w|\\s|-])*\\.(?:mp3|ogg|wav)$")
	private String				jingle;

}
