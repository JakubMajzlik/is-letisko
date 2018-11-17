package airportis.app.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

	private String firstField;
	private String secondField;
	private String message;
	
	@Override
	public void initialize(FieldMatch constraintAnnotation) {
		firstField = constraintAnnotation.first();
		secondField = constraintAnnotation.second();
		message = constraintAnnotation.message();
	}



	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		boolean valid = true;
		try {
			Object firstObject = new BeanWrapperImpl(value).getPropertyValue(firstField);
			Object secondObject = new BeanWrapperImpl(value).getPropertyValue(secondField);
			valid = firstObject.equals(secondObject);
		}catch(Exception e) {}
		if(!valid) {
			context.buildConstraintViolationWithTemplate(message)
					.addPropertyNode(firstField)
					.addConstraintViolation()
					.disableDefaultConstraintViolation();
		}
		return valid;
	}

}
