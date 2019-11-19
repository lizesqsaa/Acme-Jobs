
package acme.features.administrator.chart;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorChartRepository extends AbstractRepository {

	@Query("select c.sector, count(c) from CompanyRecord c group by c.sector order by c.sector")
	Collection<Object[]> getCompanyBySector();

	@Query("select i.sector, count(i) from Investor i group by i.sector order by i.sector")
	Collection<Object[]> getInvestorBySector();

}
