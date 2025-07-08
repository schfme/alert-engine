package me.schf.alert.engine.rule;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class AlertingService {
	
	private final Map<String, Alerter> alerters;
	
	public void sendAlert();

}
