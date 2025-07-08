import java.lang.reflect.Method;
import java.util.List;

import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

@Service
public class EvaluationService {

	private final StandardEvaluationContext spelContext;

	public EvaluationService(List<Evaluator> evaluators) {
		this.spelContext = new StandardEvaluationContext();

		for (Evaluator evaluator : evaluators) {
			try {
				Method method = evaluator.getClass().getMethod("evaluate", Object.class);
				spelContext.registerFunction(evaluator.getName(), method);
			} catch (NoSuchMethodException e) {
				throw new RuntimeException(
						"Evaluator " + evaluator.getClass().getName() + " must have an evaluate(Object) method", e);
			}
		}
	}
	
	public 

	public StandardEvaluationContext getSpelContext() {
		return spelContext;
	}
}
