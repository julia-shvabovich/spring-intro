package intro;

import intro.config.AppConfig;
import intro.model.User;
import intro.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        User testUser = new User();
        testUser.setEmail("test@gmail.com");
        testUser.setPassword("123");
        userService.add(testUser);
        userService.listUsers().forEach(System.out::println);
    }
}
