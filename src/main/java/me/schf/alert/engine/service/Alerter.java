package me.schf.alert.engine.service;

@FunctionalInterface
public interface Alerter {

	public void alert(String alertRuleName, String alertMessage);

}
