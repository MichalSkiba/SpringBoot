package com.ms.SpringBoot.Controller;

import com.ms.SpringBoot.Model.User;
import com.ms.SpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ControllerAdmin {

    @Autowired
    private UserService userService;

    @GET
    @RequestMapping("/admin/main")
    @Secured("ROLE_ADMIN")
    public String pokazStrone() {
        return "admin/admin";
    }

    @GET
    @RequestMapping(value = "/admin/users")
    @Secured(value = { "ROLE_ADMIN" })
    public String getAllUsers(Model model) {

        List<User> userList = null;
        userList = getAllUsers();
        model.addAttribute("userList", userList);

        return "admin/users";
    }

    @GET
    @RequestMapping(value = "/admin/edit/{id}")
    @Secured(value = { "ROLE_ADMIN" })
    public String getUserToEdit(@PathVariable("id") String id, Model model) {

        User user = new User();
        int userId = Integer.parseInt(id);
        user = userService.findUserById(userId);

        Map<Integer, String> roleMap = new HashMap<Integer, String>();
        roleMap = prepareRoleMap();
        model.addAttribute("roleMap", roleMap);

        int rola = user.getRoles().iterator().next().getId();
        user.setRodaInt(rola);

        model.addAttribute("roleMap", roleMap);
        model.addAttribute("user", user);

        return "admin/useredit";
    }

    @POST
    @RequestMapping(value = "/admin/update")
    @Secured(value = "ROLE_ADMIN")
    public String updateUser(Model model, @Valid User user, BindingResult result) {

        String returnPage = null;
        String rola = null;

        if (user.getRodaInt() == 1) {
            rola = "ROLE_ADMIN";
        } else if (user.getRodaInt() == 2) {
            rola = "ROLE_USER";
        } else {
            rola = "ROLE_SALE";
        }

        if (result.hasErrors()) {
            Map<Integer, String> roleMap = new HashMap<Integer, String>();
            roleMap = prepareRoleMap();
            model.addAttribute("roleMap", roleMap);

            returnPage = "admin/useredit";
        } else {
            userService.updateUser(rola, user);

            List<User> userList = null;
            userList = getAllUsers();

            model.addAttribute("userList", userList);
            returnPage = "admin/users";
        }
        return returnPage;
    }

    // pobranie wszystkich użytkowników
    public List<User> getAllUsers() {
        List<User> userList = null;
        userList = userService.findAll();
        for (User users : userList) {
            int numerRoli = users.getRoles().iterator().next().getId();

            if (numerRoli == 1) {
                users.setRodaInt(numerRoli);
            } else if (numerRoli == 2) {
                users.setRodaInt(numerRoli);
            }
        }

        return userList;
    }

    // przygotowanie mapy ról
    public Map<Integer, String> prepareRoleMap() {
        Map<Integer, String> roleMap = new HashMap<Integer, String>();
        roleMap.put(1, "Administrator");
        roleMap.put(2, "Użytkownik");
        roleMap.put(3, "Sprzedawca");
        return roleMap;
    }
}
