
package acme.features.administrator.challenge;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorChallengeCreateService implements AbstractCreateService<Administrator, Challenge> {

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
	public Challenge instantiate(final Request<Challenge> request) {
		Challenge result;

		result = new Challenge();

		return result;
	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		// Validación de fecha futura

		Date fecha;
		fecha = entity.getDeadline();
		Date fechaActual;
		fechaActual = new Date();

		Boolean isAfter;
		if (fecha.after(fechaActual)) {
			isAfter = true;
		} else {
			isAfter = false;
		}

		errors.state(request, isAfter, "deadline", "errors.challenge.create.deadline", "Deadline is not future, you must to put in future");
	}

	@Override
	public void create(final Request<Challenge> request, final Challenge entity) {
		this.repository.save(entity);
	}

}