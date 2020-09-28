package com.capgemini.pecunia.accountservice.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class AadharNumberValidatior implements 
ConstraintValidator<AadharNumber, Long> {

	  @Override
	  public void initialize(AadharNumber aadhar) {
	  }

	  @Override
	  public boolean isValid(Long number,
	    ConstraintValidatorContext cxt) {
	      return  (number > 100000000000L) && (number < 999999999999L);
	  }

}