package com.example.daycare.controller;

import com.example.daycare.model.Child;
import com.example.daycare.repository.ChildRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/children")
public class ChildController {

    private final ChildRepository childRepository;

    public ChildController(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @GetMapping
    public String listChildren(Model model) {
        List<Child> children = childRepository.findAll();
        model.addAttribute("children", children);
        return "children";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        Child child = new Child();
        child.setEnrolledDate(LocalDate.now());
        model.addAttribute("child", child);
        model.addAttribute("title", "Add New Child");
        return "child_form";
    }

    @PostMapping
    public String saveChild(@ModelAttribute("child") Child child) {
        childRepository.save(child);
        return "redirect:/children";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Child child = childRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid child Id:" + id));
        model.addAttribute("child", child);
        model.addAttribute("title", "Edit Child");
        return "child_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteChild(@PathVariable Long id) {
        childRepository.deleteById(id);
        return "redirect:/children";
    }
}
