package ru.crud.app.controller;

import ru.crud.app.model.UserEntity;
import ru.crud.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
public class UserController {
    private UserService userService;
    int recordsPerPage = 10;
    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listUsers(@RequestParam(value = "page", defaultValue = "0", required = false) int page, Model model) {
        model.addAttribute("userEntity", new UserEntity());
        model.addAttribute("listUsers", userService.listUsers(recordsPerPage, page));
        model.addAttribute("page",page);
        model.addAttribute("numberOfRecords", userService.getNumberOfRecords());
        model.addAttribute("message", "Add a user");
        return "users";
    }
    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userEntity") UserEntity userEntity) {
        System.out.println(userEntity);
        if (userEntity.getId() == null) {
            userService.addUser(userEntity);
        } else {
            userService.updateUser(userEntity);
        }
        return "redirect:/users";
    }
    @RequestMapping(value = "/remove/{id}")
    public String removeUser(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/users";
    }
    @RequestMapping(value = "/edit/{id}")
    public String editUser(@RequestParam(value = "page", defaultValue = "0", required = false) int page, @PathVariable("id") int id, Model model) {
        model.addAttribute("userEntity", userService.getUserById(id));
        model.addAttribute("listUsers", userService.listUsers(recordsPerPage, page));
        model.addAttribute("page",page);
        model.addAttribute("numberOfRecords", userService.getNumberOfRecords());
        model.addAttribute("message", "Edit a user");
        return "users";
    }
    @RequestMapping(value = "/search")
    public String Search(@RequestParam("searchString") String searchString, Model model) {
        if (searchString != null) {
            List<UserEntity> searchResult = userService.searchUsers(searchString);
            model.addAttribute("searchResult", searchResult);
        }
        return "search";
    }
    @RequestMapping(value = "/error")
    @ExceptionHandler({Exception.class})
    public String handleIOException(Exception exception, Model model) {
        model.addAttribute("exception", exception);
        return "error";
    }


}
