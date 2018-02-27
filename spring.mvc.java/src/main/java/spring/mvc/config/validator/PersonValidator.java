package spring.mvc.config.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.mvc.web.member.dto.Person;

public class PersonValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object obj, Errors err) {
		ValidationUtils.rejectIfEmpty(err, "name", "name.empty");
		Person p = (Person) obj;
		if (p.getAge() < 0) {
			err.rejectValue("age", "negativevalue");
		} else if (p.getAge() > 110) {
			err.rejectValue("age", "too.darn.old");
		}
	}

}
