package web.controller;

import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

        userService.add(new User("Volodya", "Kurtsev", "vk@vk.com"));

        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");

        userService.add(user2);
        userService.add(user3);
        userService.add(user1);
        userService.add(user4);
    }

    @GetMapping(value = "/")
    public String printUsers(Model model) {
        List<User> userList=userService.listUsers();
        model.addAttribute("user_list", userList);
        return "user-view";
    }

    @GetMapping(value = "/add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-add";
    }

}
