package ru.sbrf.emoAuth.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.sbrf.emoAuth.Authentication;
import ru.sbrf.emoAuth.Request.LoginRequest;
import ru.sbrf.emoAuth.Request.LoginResponse;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@Log
public class LoginController {

    @Autowired
    Authentication authentication;

    public LoginController() {}

    @PostMapping ("/users/login")
    @ResponseBody
    public ResponseEntity postLoginController(@RequestBody @Valid LoginRequest request, Errors errors) {

        log.info("postLoginController: invoked");

        if( errors.hasErrors() ) {
            LoginResponse response = new LoginResponse();
            List<String> errorMessages = new ArrayList<>();

            for( ObjectError error : errors.getAllErrors()) {
                errorMessages.add(error.getDefaultMessage());
                log.info("postLoginController: ".concat("error: bad request: ").concat(error.getDefaultMessage()));
            }

            response.setErrors(errorMessages);

            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }

        if( authentication.checkLogin(request.getLogin(), request.getPassword()) ) {
            log.info("postLoginController: Success login");
            return new ResponseEntity("Hello ".concat(request.getLogin()), HttpStatus.OK);
        }
        else {
            log.info("postLoginController: User not found");
            return new ResponseEntity("User not found",HttpStatus.UNAUTHORIZED);
        }
    }
}