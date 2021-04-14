package Services;

import DTO.PatientDTO;
import Repositories.PatientRepository;
import models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient registerNewPatientAccount(PatientDTO patientDTO) throws UserAlreadyExistException{
        if(userExist(patientDTO.getUserName())){
            throw new UserAlreadyExistException("There is an account with that User Name: " + patientDTO.getUserName());
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

    private boolean userExist(String user_name){
        return patientRepository.findByUserName(user_name) != null;
    }

    public class UserAlreadyExistException extends Exception {
        public UserAlreadyExistException(String message){
            super(message);
        }
    }
}
