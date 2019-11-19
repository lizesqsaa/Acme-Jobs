/*
 * AuthenticatedCommercialBannerShowService.java
 *
 * Copyright (c) 2019 Aureliano Piqueras, based on Rafael Corchuelo's DP Starter project.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.administrator.commercialBanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.CommercialBanner;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorCommercialBannerShowService implements AbstractShowService<Administrator, CommercialBanner> {

	@Autowired
	private AdministratorCommercialBannerRepository repository;


	@Override
	public boolean authorise(final Request<CommercialBanner> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<CommercialBanner> request, final CommercialBanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "picture", "slogan", "targetURL", "creditCardNumber", "holderName", "expirationYear", "expirationMonth", "cvv");
	}

	@Override
	public CommercialBanner findOne(final Request<CommercialBanner> request) {
		CommercialBanner result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findCommercialBannerById(id);
		return result;
	}

}
