package com.cg.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileNumberValidator  implements 
ConstraintValidator<MobileNumber, Long> {

	  @Override
	  public void initialize(MobileNumber contact) {
	  }

	  @Override
	  public boolean isValid(Long number,
	    ConstraintValidatorContext cxt) {
	      return  (number > 5999999999L) && (number < 9999999999L);
	  }


}
