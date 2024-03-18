package web.controller;

import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

        userService.add(new User("Vladimir", "Kurtsev", "vk@vk.com"));

        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");

        userService.add(user2);
        userService.add(user3);
        userService.add(user1);
        userService.add(user4);
    }

    @GetMapping()
    public String printUsers(Model model) {
        List<User> userList = userService.listUsers();
        model.addAttribute("user_list", userList);
        return "user-list";
    }

    @GetMapping("/{id}")
    public String viewUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user-view";
    }

    @GetMapping(value = "/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "user-new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user-edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(user, id);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/";
    }

}
