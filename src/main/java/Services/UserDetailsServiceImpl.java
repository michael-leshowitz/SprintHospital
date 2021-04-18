package Services;

import DTO.UserDTO;
import Repositories.UsersRepository;
import models.Role;
import models.Users;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PostPersist;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Transactional
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<Users> usersList = usersRepository.findUser(userName);

        if (usersList != null && usersList.size() == 1) {
            Users users = usersList.get(0);

            List<String> roleList = new ArrayList<String>();
            for (Role role : users.getRoles()) {
                roleList.add(role.getRole_name());
            }
//Todo fix encryption. Need to submit users that are encrypted in order for log in credentials to be ok
            return User.builder()
                    .username(users.getUsername())
                    //change here to store encoded password in db
//                    .password( bCryptPasswordEncoder.encode(users.getPassword()) )
                    .password(users.getPassword())
                    .disabled(users.isDisabled())
                    .accountExpired(users.isAccountExpired())
                    .accountLocked(users.isAccountLocked())
                    .credentialsExpired(users.isCredentialsExpired())
                    .roles(roleList.toArray(new String[0]))
                    .build();
        } else {
            throw new UsernameNotFoundException("User Name is not Found");
        }
    }

    @Transactional
        public Users registerNewUserAccount(UserDTO userDTO)
            throws UserAlreadyExistException, PasswordMisMatchException, InvalidEmailException
    {
        if(userExist(userDTO.getUsername())){
            throw new UserAlreadyExistException("There is an account with that User Name: " + userDTO.getUsername());
        }
        if(!(isValidEmail(userDTO.getEmail()))){
            throw new InvalidEmailException("Invalid email address.");
        }
        if(passwordMisMatch(userDTO.getPassword(), userDTO.getMatchingPassword())){
            throw new PasswordMisMatchException("Password confirmation failed. The passwords do not match.");
        }
        Users newPatient = new Users();

        newPatient.setUsername(userDTO.getUsername());
        newPatient.setEmail(userDTO.getEmail());
        newPatient.setLastName(userDTO.getLastName());
        newPatient.setFirstName(userDTO.getFirstName());
//        newPatient.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        newPatient.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
//        newPatient.setPassword(userDTO.getPassword());
        newPatient.setDisabled(false);
        newPatient.setAccountLocked(false);
        newPatient.setAccountExpired(false);
        newPatient.setCredentialsExpired(false);
        usersRepository.savePatient(newPatient.getUsername(), newPatient.getPassword(),newPatient.getEmail(), newPatient.getFirstName(), newPatient.getLastName());

        return newPatient;
    }
//    @PostPersist
    public void updateUserRole(){
        usersRepository.updateUserRole();
    }

        private boolean userExist(String user_name){

//            List<Users> us = usersRepository.findUser(user_name);
            return !(usersRepository.findUser(user_name).isEmpty());
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
    public boolean passwordMisMatch(String password, String passwordMatch){return !(password.equals(passwordMatch));}

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
