package me.schf.alert.engine.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(AlertRuleService.class)
class AlertRuleServiceTest {

	@Autowired
	private AlertRuleService alertRuleService;

	@Autowired
	private AlertRuleRepository alertRuleRepository;

	@Test
	void testGetEnabledAlertRules() {
		AlertRule activeRule = initActive();
		AlertRule inactiveRule = initInnactive();

		alertRuleRepository.save(activeRule);
		alertRuleRepository.save(inactiveRule);

		List<AlertRule> enabledRules = alertRuleService.getActiveAlertRules();

		assertThat(enabledRules).hasSize(1);
		assertThat(enabledRules.get(0).getName()).isEqualTo("activeRule");
	}

	private AlertRule initInnactive() {
		AlertRule inactiveRule = new AlertRule();
		inactiveRule.setName("inactiveRule");
		inactiveRule.setEnabled(false);
		return inactiveRule;
	}

	private AlertRule initActive() {
		AlertRule activeRule = new AlertRule();
		activeRule.setName("activeRule");
		activeRule.setEnabled(true);
		return activeRule;
	}

}
