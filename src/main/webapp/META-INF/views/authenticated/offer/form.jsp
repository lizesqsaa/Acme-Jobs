<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.offer.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.offer.form.label.creationMoment" path="creationMoment"/>
	<acme:form-moment code="authenticated.offer.form.label.limitDate" path="limitDate"/>
	<acme:form-textbox code="authenticated.offer.form.label.descriptionText" path="descriptionText"/>
	<acme:form-money code="authenticated.offer.form.label.amount" path="amount"/>
	<acme:form-textbox code="authenticated.offer.form.label.ticker" path="ticker"/>
	
	
	<acme:form-return code="authenticated.offer.form.button.return"/>
</acme:form>
