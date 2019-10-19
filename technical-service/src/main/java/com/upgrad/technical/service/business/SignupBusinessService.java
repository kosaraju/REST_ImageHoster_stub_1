package com.upgrad.technical.service.business;

import com.upgrad.technical.service.dao.UserDao;
import com.upgrad.technical.service.entity.UserEntity;
import com.upgrad.technical.service.exception.UserSignupException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignupBusinessService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordCryptographyProvider passwordCryptographyProvider;

    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity signup(UserEntity userEntity) throws UserSignupException {


        //null check
        if (userEntity == null || userEntity.getFirstName() == null ||
                userEntity.getLastName() == null || userEntity.getEmail() == null
                || userEntity.getPassword() == null || userEntity.getMobilePhone() == null ||
                userEntity.getFirstName().isEmpty() || userEntity.getLastName().isEmpty()
                || userEntity.getEmail().isEmpty() || userEntity.getPassword().isEmpty() ||
                userEntity.getMobilePhone().isEmpty()) {
            throw new UserSignupException("USE-001", "Blank or Malformed details provided for signup");
        }


        String[] encryptedText = passwordCryptographyProvider.encrypt(userEntity.getPassword());
        userEntity.setSalt(encryptedText[0]);
        userEntity.setPassword(encryptedText[1]);

        return userDao.createUser(userEntity);
    }
}
