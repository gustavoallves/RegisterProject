package com.example.registerspring.users;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.createUser(userRequestDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userResponseDTO.getId())
                .toUri();
        return ResponseEntity.created(location).body(userResponseDTO);
    }

    @GetMapping()
    public ResponseEntity<List<UserResponseDTO>> listAllUser() {
        return ResponseEntity.ok(userService.listAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        UserResponseDTO userResponseDTO = userService.findById(id);
        return ResponseEntity.ok(userResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> editUser(@PathVariable Long id, @Valid @RequestBody UserRequestDTO userRequestDTO) {
        userService.findById(id);
        UserResponseDTO userResponseDTO = userService.editUser(id, userRequestDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userResponseDTO.getId())
                .toUri();
        return ResponseEntity.created(location).body(userResponseDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}