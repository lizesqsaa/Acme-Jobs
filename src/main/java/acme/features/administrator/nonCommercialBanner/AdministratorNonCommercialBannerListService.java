/*
 * AuthenticatedAcmeRequestListService.java
 *
 * Copyright (c) 2019 Aureliano Piqueras, based on Rafael Corchuelo's DP Starter project.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.administrator.nonCommercialBanner;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.NonCommercialBanner;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorNonCommercialBannerListService implements AbstractListService<Administrator, NonCommercialBanner> {

	@Autowired
	private AdministratorNonCommercialBannerRepository repository;


	@Override
	public boolean authorise(final Request<NonCommercialBanner> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<NonCommercialBanner> request, final NonCommercialBanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "picture", "slogan", "targetURL", "jingle");
	}

	@Override
	public Collection<NonCommercialBanner> findMany(final Request<NonCommercialBanner> request) {
		assert request != null;
		Collection<NonCommercialBanner> result;
		result = this.repository.findMany();
		return result;
	}

}
