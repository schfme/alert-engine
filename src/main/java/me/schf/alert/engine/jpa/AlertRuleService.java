package me.schf.alert.engine.jpa;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AlertRuleService {

	private final AlertRuleRepository alertRuleRepository;

	public AlertRuleService(AlertRuleRepository alertRuleRepository) {
		super();
		this.alertRuleRepository = alertRuleRepository;
	}

	public List<AlertRule> getActiveAlertRules() {
		return alertRuleRepository.findAllByEnabledTrue();
	}

}
