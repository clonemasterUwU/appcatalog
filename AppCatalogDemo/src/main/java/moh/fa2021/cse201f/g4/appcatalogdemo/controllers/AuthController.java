package moh.fa2021.cse201f.g4.appcatalogdemo.controllers;

import moh.fa2021.cse201f.g4.appcatalogdemo.models.Role;
import moh.fa2021.cse201f.g4.appcatalogdemo.models.User;
import moh.fa2021.cse201f.g4.appcatalogdemo.payload.request.AuthenticationRequest;
import moh.fa2021.cse201f.g4.appcatalogdemo.payload.request.SignupRequest;
import moh.fa2021.cse201f.g4.appcatalogdemo.payload.response.AuthenticationResponse;
import moh.fa2021.cse201f.g4.appcatalogdemo.repository.UserRepository;
import moh.fa2021.cse201f.g4.appcatalogdemo.services.MyUserDetailsService;
import moh.fa2021.cse201f.g4.appcatalogdemo.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "Hello world";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().body("Incorrect username or password");
        }
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body("Error: Username already used");
        }
        User user = new User(signUpRequest.getUsername(), passwordEncoder.encode(signUpRequest.getPassword()), Role.STANDARD);
        userRepository.save(user);
        return ResponseEntity.ok("User registered");
    }
}