
package acme.features.consumer.offer;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.offers.Offer;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ConsumerOfferRepository extends AbstractRepository {

	@Query("select o from Offer o where o.id=?1")
	Offer findOfferById(int id);

	@Query("select o from Offer o")
	Collection<Offer> findMany();

	@Query("select o from Offer o where o.ticker =?1")
	Object findOneOfferByTicker(String ticker);

}
