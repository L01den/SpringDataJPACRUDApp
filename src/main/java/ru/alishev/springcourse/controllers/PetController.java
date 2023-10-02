package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alishev.springcourse.models.Client;
import ru.alishev.springcourse.models.Pet;
import ru.alishev.springcourse.services.PetService;

import javax.validation.Valid;

@Controller
@RequestMapping("/home")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("pets", petService.findOne(id));
        return "pet/show";
    }

    @PostMapping()
    public String create(@ModelAttribute("pets") @Valid Pet pet,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "pet/new";
        }
        petService.save(pet);
        return "redirect:/pet";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("pets") Pet pet, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "pet/edit";

        petService.update(id, pet);
        return "redirect:/pet";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        petService.delete(id);
        return "redirect:/pet";
    }

}
