package me.schf.alert.engine.service;

import java.util.List;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class EvaluationService<T> {

	private final ExpressionParser parser;
	private final List<Evaluator> evaluators;

	public EvaluationService(List<Evaluator> evaluators) {
		this.evaluators = evaluators;
		this.parser = new SpelExpressionParser();
	}

	public boolean evaluate(T input, String condition)
			throws NoSuchMethodException, SecurityException {
		var context = new StandardEvaluationContext(input);
		for (var evaluator : evaluators) {
			var method = evaluator.getClass().getMethod("evaluate", Object.class);
			context.registerFunction(evaluator.getName(), method);
		}

		return Boolean.TRUE.equals(parser.parseExpression(condition).getValue(context, Boolean.class));
	}

}
