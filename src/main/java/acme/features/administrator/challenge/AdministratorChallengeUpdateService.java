
package acme.features.administrator.challenge;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorChallengeUpdateService implements AbstractUpdateService<Administrator, Challenge> {

	// Internal state ---------------------------------------------------------------------------------

	@Autowired
	AdministratorChallengeRepository repository;


	// AbstractCreateService<Administrator, Challenge> interface --------------------------------------

	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "goldGoal", "goldReward", "silverGoal", "silverReward", "bronzeGoal", "bronzeReward");
	}

	@Override
	public Challenge findOne(final Request<Challenge> request) {
		assert request != null;

		Challenge result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findChallengeById(id);

		return result;
	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		Boolean isFuture, isPositiveGold, isPositiveSilver, isPositiveBronze, isEuroGold, isEuroSilver, isEuroBronze, isGold, isSilver, isBronze;

		// Validación de fecha futura
		Date fechaActual;
		fechaActual = new Date();
		isFuture = entity.getDeadline().after(fechaActual);
		errors.state(request, isFuture, "deadline", "errors.challenge.deadline.future", "Deadline must be in future");

		// Validación dinero positivo
		isPositiveGold = entity.getGoldReward().getAmount() > 0;
		errors.state(request, isPositiveGold, "goldReward", "errors.challenge.reward.money.amount-positive", "The amount must be positive");

		isPositiveSilver = entity.getSilverReward().getAmount() > 0;
		errors.state(request, isPositiveSilver, "silverReward", "errors.challenge.reward.money.amount-positive", "The amount must be positive");

		isPositiveBronze = entity.getGoldReward().getAmount() > 0;
		errors.state(request, isPositiveBronze, "bronzeReward", "errors.challenge.reward.money.amount-positive", "The amount must be positive");

		// Validación moneda
		isEuroGold = entity.getGoldReward().getCurrency().equals("EUR") || entity.getGoldReward().getCurrency().equals("€");
		errors.state(request, isEuroGold, "goldReward", "errors.challenge.reward.money.euro", "The money must be in euro '€' / 'EUR'");

		isEuroSilver = entity.getSilverReward().getCurrency().equals("EUR") || entity.getSilverReward().getCurrency().equals("€");
		errors.state(request, isEuroSilver, "silverReward", "errors.challenge.reward.money.euro", "The money must be in euro '€' / 'EUR'");

		isEuroBronze = entity.getBronzeReward().getCurrency().equals("EUR") || entity.getBronzeReward().getCurrency().equals("€");
		errors.state(request, isEuroBronze, "bronzeReward", "errors.challenge.reward.money.euro", "The money must be in euro '€' / 'EUR'");

		// Validación cantidad orden
		isGold = entity.getGoldReward().getAmount() > entity.getSilverReward().getAmount() && entity.getGoldReward().getAmount() > entity.getBronzeReward().getAmount();
		errors.state(request, isGold, "goldReward", "errors.challenge.goldReward.amount-major", "The amount of gold must be higher than silver and bronze");

		isSilver = entity.getSilverReward().getAmount() < entity.getGoldReward().getAmount() && entity.getSilverReward().getAmount() > entity.getBronzeReward().getAmount();
		errors.state(request, isSilver, "silverReward", "errors.challenge.silverReward.amount-medium", "The amount of silver must be higher than bronze and lower than gold");

		isBronze = entity.getBronzeReward().getAmount() < entity.getSilverReward().getAmount() && entity.getBronzeReward().getAmount() < entity.getGoldReward().getAmount();
		errors.state(request, isBronze, "bronzeReward", "errors.challenge.bronzeReward.amount-minor", "The amount of bronze must be lower than silver and gold");
	}

	@Override
	public void update(final Request<Challenge> request, final Challenge entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
