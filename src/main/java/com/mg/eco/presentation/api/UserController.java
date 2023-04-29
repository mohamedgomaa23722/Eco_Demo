package com.mg.eco.presentation.api;

import com.mg.eco.bussiness.dtos.Message;
import com.mg.eco.bussiness.dtos.UserDto;
import com.mg.eco.bussiness.mappers.UserMapper;
import com.mg.eco.bussiness.services.UserService;
import com.mg.eco.presentation.dtos.InsertUserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> getUsers(@RequestParam(value = "page", defaultValue = "1") int page) {
        return userService.getAll(page);
    }

    @GetMapping("{id}")
    public UserDto getUser(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    @PostMapping
    public Message insertUser(@Valid @RequestBody InsertUserDto insertUserDto){
        UserDto userDto = UserMapper.INSTANCE.fromInsertObject(insertUserDto);
        return userService.insert(userDto);
    }

    @DeleteMapping("{id}")
    public Message deleteUser(@PathVariable("id") int id) {
        return userService.delete(id);
    }

    @GetMapping("search")
    public List<UserDto> findUsersByName(@RequestParam("name") String userName,
                                        @RequestParam(value = "page", defaultValue = "1") int page) {
        return userService.findByName(userName, "firstName", page);
    }
}
