package ru.alishev.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alishev.springcourse.models.Client;
import ru.alishev.springcourse.models.Consultation;
import ru.alishev.springcourse.services.ClientServices;
import ru.alishev.springcourse.services.ConsultationService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/сlient")
public class ClientController {
    private final ClientServices clientServices;

    @Autowired
    public ClientController(ClientServices clientServices) {
        this.clientServices = clientServices;

    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("сlient", clientServices.findOne(id));
        return "сlient/show";
    }

    @PostMapping()
    public String create(@ModelAttribute("сlients") @Valid Client client,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "сlient/new";
        }
        clientServices.save(client);
        return "redirect:/сlient";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("clients") Client client, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "client/edit";

        clientServices.update(id, client);
        return "redirect:/client";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        clientServices.delete(id);
        return "redirect:/client";
    }

}
