package me.schf.alert.engine.rule;

public interface Evaluator {

	public boolean evaluate(String value);

	public String getName();

}
