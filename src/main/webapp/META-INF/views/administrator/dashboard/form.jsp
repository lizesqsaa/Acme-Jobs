<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="administrator.dashboard.form.label.numberOfAnnouncements" path="numberOfAnnouncements" />
	<acme:form-textbox code="administrator.dashboard.form.label.numberOfCompanyRecords" path="numberOfCompanyRecords" />
	<acme:form-textbox code="administrator.dashboard.form.label.numberOfInvestorRecords" path="numberOfInvestorRecords" />
	
	<acme:form-textbox code="administrator.dashboard.form.label.minimumRewardActiveRequests" path="minimumRewardActiveRequests" />
	<acme:form-textbox code="administrator.dashboard.form.label.maximumRewardActiveRequests" path="maximumRewardActiveRequests" />
	<acme:form-textbox code="administrator.dashboard.form.label.averageRewardActiveRequests" path="averageRewardActiveRequests" />
	<acme:form-textbox code="administrator.dashboard.form.label.stddevRewardActiveRequests" path="stddevRewardActiveRequests" />
	
	<acme:form-textbox code="administrator.dashboard.form.label.minimumRewardActiveOffersMin" path="minimumRewardActiveOffersMin" />
	<acme:form-textbox code="administrator.dashboard.form.label.maximumRewardActiveOffersMin" path="maximumRewardActiveOffersMin" />
	<acme:form-textbox code="administrator.dashboard.form.label.averageRewardActiveOffersMin" path="averageRewardActiveOffersMin" />
	<acme:form-textbox code="administrator.dashboard.form.label.stddevRewardActiveOffersMin" path="stddevRewardActiveOffersMin" />
	
	
		<acme:form-textbox code="administrator.dashboard.form.label.minimumRewardActiveOffersMax" path="minimumRewardActiveOffersMax" />
	<acme:form-textbox code="administrator.dashboard.form.label.maximumRewardActiveOffersMax" path="maximumRewardActiveOffersMax" />
	<acme:form-textbox code="administrator.dashboard.form.label.averageRewardActiveOffersMax" path="averageRewardActiveOffersMax" />
	<acme:form-textbox code="administrator.dashboard.form.label.stddevRewardActiveOffersMax" path="stddevRewardActiveOffersMax" />
	
	<acme:form-return code="administrator.dashboard.form.button.return" />
</acme:form>