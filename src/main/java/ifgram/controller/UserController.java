package ifgram.controller;

import ifgram.dto.UserRequest;
import ifgram.dto.UserResponse;
import ifgram.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("user")
public class UserController {

     public final UserService service;

     public UserController(UserService service){
         this.service = service;
     }

    @GetMapping
    public String getUsers(){
        String listaUsuarios = service.toString();
        return listaUsuarios;
    }

    @PostMapping
    public UserResponse postUser(UserRequest request) throws Exception {
        UserResponse userResponse = service.cria(request);
        return userResponse;
    }

    @DeleteMapping
    public String deleteUser(){
        return "chamei o endpoint como um DELETE!";
    }

}