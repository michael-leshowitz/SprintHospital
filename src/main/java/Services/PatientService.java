package Services;

import Annotations.ValidEmail;
import DTO.PatientDTO;
import Repositories.PatientRepository;
import models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient registerNewPatientAccount(PatientDTO patientDTO)
            throws UserAlreadyExistException, PasswordMisMatchException, InvalidEmailException
    {
        if(userExist(patientDTO.getUserName())){
            throw new UserAlreadyExistException("There is an account with that User Name: " + patientDTO.getUserName());
        }
        if(passwordMisMatch(patientDTO.getPassword(), patientDTO.getMatchingPassword())){
            throw new PasswordMisMatchException("Password confirmation failed. The passwords do not match.");
        }
        if(!(isValidEmail(patientDTO.getContact_email()))){
            throw new InvalidEmailException("Invalid email address.");
        }
        Patient newPatient = new Patient();

        newPatient.setUser_name(patientDTO.getUserName());
        newPatient.setLastName(patientDTO.getLastName());
        newPatient.setFirstName(patientDTO.getFirstName());
        newPatient.setContact_email(patientDTO.getContact_email());
        newPatient.setPassword(new BCryptPasswordEncoder().encode(patientDTO.getPassword()));
        patientRepository.save(newPatient);
        return newPatient;
    }

    public boolean passwordMisMatch(String password, String passwordMatch){return !(password.equals(passwordMatch));}

    private boolean userExist(String user_name){
        return patientRepository.findByUserName(user_name) != null;
    }



        public boolean isValidEmail(String email){
            return (validateEmail(email));
        }
        private boolean validateEmail(String email) {
             Pattern pattern;
             Matcher matcher;
             final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";

            pattern = Pattern.compile(EMAIL_PATTERN);
            matcher = pattern.matcher(email);
            return matcher.matches();
        }


        public class UserAlreadyExistException extends Exception {
        public UserAlreadyExistException(String message){
            super(message);
        }
    }

    public class PasswordMisMatchException extends Exception{
        public PasswordMisMatchException(String message){super(message);}
    }

    public class InvalidEmailException extends Exception{
        public InvalidEmailException(String message){super(message);}
    }
}
