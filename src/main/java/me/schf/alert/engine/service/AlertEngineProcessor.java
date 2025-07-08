package me.schf.alert.engine.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import me.schf.alert.engine.jpa.AlertRule;

public class AlertEngineProcessor<T> {

	private final Map<String, Alerter> alerters;
	private final List<AlertRule> alertRules;
	private final EvaluationService<T> evaluationService;
	private final Converter<T> converter;

	public AlertEngineProcessor(Map<String, Alerter> alerters, List<AlertRule> alertRules,
			EvaluationService<T> evaluationService, Converter<T> converter) {
		super();
		this.alerters = alerters;
		this.alertRules = alertRules;
		this.evaluationService = evaluationService;
		this.converter = converter;
	}

	public void checkMessageAndAlert(String message) throws Exception {

		T input = converter.convert(message);

		for (AlertRule alertRule : alertRules) {
			if (evaluationService.evaluate(input, alertRule.getSpElCondition())) {
				alertRule.getAlerters().stream().map(alerters::get).filter(Objects::nonNull)
						.forEach(alerter -> alerter.alert(alertRule.getName(), message));
			}
		}
	}
}
