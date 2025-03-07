package com.cooksys.groupfinal.controllers;

import com.cooksys.groupfinal.dtos.ProfileDto;
import com.cooksys.groupfinal.dtos.UserRequestDto;
import org.springframework.web.bind.annotation.*;

import com.cooksys.groupfinal.dtos.CredentialsDto;
import com.cooksys.groupfinal.dtos.FullUserDto;
import com.cooksys.groupfinal.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    @CrossOrigin(origins = "*")
    public FullUserDto login(@RequestBody CredentialsDto credentialsDto) {
        return userService.login(credentialsDto);
    }

    @PostMapping("/{companyId}")
    public FullUserDto createUser(@RequestBody UserRequestDto userRequestDto, @PathVariable Long companyId) {
        return userService.createUser(userRequestDto, companyId);
    }

    @PatchMapping("/{username}/profile")
    public FullUserDto editUserProfile(@PathVariable String username, @RequestBody ProfileDto profileDto) {
        return userService.patchUserProfile(username, profileDto);
    }

    @PatchMapping("/{username}/credentials")
    public FullUserDto editUserCredentials(@PathVariable String username, @RequestBody CredentialsDto credentialsDto) {
        return userService.patchUserCredentials(username, credentialsDto);
    }

    @PatchMapping("/{username}/admin/{adminStatus}")
    public FullUserDto editUserAdmin(@PathVariable String username, @PathVariable boolean adminStatus) {
        return userService.patchUserAdmin(username, adminStatus);
    }

    @PatchMapping("/{username}/active/{activeStatus}")
    public FullUserDto editUserActive(@PathVariable String username, @PathVariable boolean activeStatus) {
        return userService.patchUserActive(username, activeStatus);
    }

    @GetMapping("/{username}")
    public FullUserDto getUser(@PathVariable String username) {
        return userService.getUser(username);
    }



}
