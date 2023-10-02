package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alishev.springcourse.models.Consultation;
import ru.alishev.springcourse.services.ConsultationService;

import javax.validation.Valid;


@Controller
@RequestMapping("/people")
public class ConsultationController {

    private final ConsultationService consultationService;

    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("consultation", consultationService.findOne(id));
        return "consultation/show";
    }

    @PostMapping()
    public String create(@ModelAttribute("consultations") @Valid Consultation consultation,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "consultation/new";
        }
        consultationService.save(consultation);
        return "redirect:/consultation";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("consultations") Consultation consultation, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "consultation/edit";

        consultationService.update(id, consultation);
        return "redirect:/consultation";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        consultationService.delete(id);
        return "redirect:/consultation";
    }
}
