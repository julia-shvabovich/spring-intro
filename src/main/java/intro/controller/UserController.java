package intro.controller;

import intro.config.AppConfig;
import intro.dto.UserResponseDto;
import intro.model.User;
import intro.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);
    UserService userService = context.getBean(UserService.class);

    @GetMapping(value = "/inject")
    public void injectUsers() {
        userService.add(new User("test@gmail.com", "123"));
        userService.add(new User("one_more_test@gmail.com", "321"));
    }

    @GetMapping(value = "/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        UserResponseDto userDto = mapUserResponseDto(userService.getById(userId));
        return userDto;
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> userDtos = userService.listUsers().stream()
                .map(user -> mapUserResponseDto(user))
                .collect(Collectors.toList());
        return userDtos;
    }

    private UserResponseDto mapUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPassword(user.getPassword());
        return userResponseDto;
    }
}
