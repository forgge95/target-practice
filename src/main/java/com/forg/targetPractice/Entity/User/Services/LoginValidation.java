package com.forg.targetPractice.Entity.User.Services;

import org.springframework.stereotype.Service;

import com.forg.targetPractice.Entity.User.Model.User;

@Service
public class LoginValidation {
    public User validate(User user, UserRepository userRepo) {

        User existingUser = userRepo.findByEmail(user.getValidation());

        if (existingUser != null) {
            if (existingUser.getPassword().equals(user.getPassword())) {
                return existingUser;
            }
        } else {
            existingUser = userRepo.findByLogin(user.getValidation());
            if (existingUser != null) {
                if (existingUser.getPassword().equals(user.getPassword())) {
                    return existingUser;
                }
            }
        }
        return null;
    }
}