package me.schf.alert.engine.rule;

@FunctionalInterface
public interface Alerter {

	public void alert(String alertRuleName, String alertMessage);

}
