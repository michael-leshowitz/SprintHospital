package Annotations;

import DTO.PatientDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        PatientDTO patient = (PatientDTO) obj;
        return patient.getPassword().equals(patient.getMatchingPassword());
    }

}
