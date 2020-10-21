package intro.controller;

import intro.dto.UserResponseDto;
import intro.model.User;
import intro.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inject")
    public void injectUsers() {
        userService.add(new User("test@gmail.com", "123"));
        userService.add(new User("one_more_test@gmail.com", "321"));
    }

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        UserResponseDto userDto = mapUserDto(userService.getById(userId));
        return userDto;
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> userDtos = userService.listUsers().stream()
                .map(user -> mapUserDto(user))
                .collect(Collectors.toList());
        return userDtos;
    }

    private UserResponseDto mapUserDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPassword(user.getPassword());
        return userResponseDto;
    }
}
