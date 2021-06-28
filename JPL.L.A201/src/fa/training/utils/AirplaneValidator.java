package fa.training.utils;

public class AirplaneValidator {
	public static boolean isModel(String model) {
		if (model.length() <= 40) return true;
		throw new RuntimeException("Model incorret. Length must be less than 40!");
	}
}
