package ru.sbrf.emoAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sbrf.emoAuth.repo.UserRepository;

@Component
public class Authentication {

    @Autowired
    private UserRepository userRepository;

    public Boolean checkLogin(String login, String password) {

        if( !userRepository.findByLoginAndPassword(login, password).isEmpty())
            return  true;
        else
            return false;
    }
}
