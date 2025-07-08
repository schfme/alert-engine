package me.schf.alert.engine.jpa;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "alert_rules")
public class AlertRule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(name = "spel_condition")
	private String spElCondition;

	@ElementCollection
	@CollectionTable(name = "alert_rule_alerters", joinColumns = @JoinColumn(name = "alert_rule_id"))
	@Column(name = "alerter")
	private List<String> alerters;

	@ElementCollection
	@CollectionTable(name = "alert_rule_notifiers", joinColumns = @JoinColumn(name = "alert_rule_id"))
	@Column(name = "notifier")
	private List<String> notifiers;

	private boolean enabled;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSpElCondition() {
		return spElCondition;
	}

	public List<String> getAlerters() {
		return alerters;
	}

	public List<String> getNotifiers() {
		return notifiers;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSpElCondition(String spElCondition) {
		this.spElCondition = spElCondition;
	}

	public void setAlerters(List<String> alerters) {
		this.alerters = alerters;
	}

	public void setNotifiers(List<String> notifiers) {
		this.notifiers = notifiers;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
