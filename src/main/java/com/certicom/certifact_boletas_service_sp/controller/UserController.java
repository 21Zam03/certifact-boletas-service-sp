package com.certicom.certifact_boletas_service_sp.controller;

import com.certicom.certifact_boletas_service_sp.dto.UserDto;
import com.certicom.certifact_boletas_service_sp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserController.API_PATH)
@RequiredArgsConstructor
public class UserController {

    public static final String API_PATH = "/api/user";
    private final UserService userService;

    @GetMapping("/idUser")
    public ResponseEntity<UserDto> findById(@RequestParam Long idUser) {
        return new ResponseEntity<>(userService.findUserById(idUser), HttpStatus.OK);
    }

    @GetMapping("/username")
    public ResponseEntity<?> findUserByUsername(@RequestParam String username) {
        return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
    }

}
