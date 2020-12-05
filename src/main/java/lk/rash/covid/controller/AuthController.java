package lk.rash.covid.controller;

import lk.rash.covid.dto.AuthenticationDto;
import lk.rash.covid.utill.JWTResponse;
import lk.rash.covid.utill.JWTUtill;
import lk.rash.covid.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JWTUtill jwtUtill;

    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDto authenticationDto){

        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationDto.getUsername(), authenticationDto.getPassword()));


        }catch (BadCredentialsException e){
            e.printStackTrace();
            throw new RuntimeException("invalid username passward");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDto.getUsername());
        String token = jwtUtill.generateToken(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new StandardResponse(200,"true",new JWTResponse(userDetails.getUsername(),token,roles)));
    }


}
