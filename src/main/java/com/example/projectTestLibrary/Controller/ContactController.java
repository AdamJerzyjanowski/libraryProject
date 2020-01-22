package com.example.projectTestLibrary.Controller;

import com.example.projectTestLibrary.Model.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @PostMapping("/sendMail")
    public String processFormContact(@Validated Contact contact, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "author/contact";

        }
        return "redirect:author/contact";
    }

    @GetMapping("/")
    String contact(@ModelAttribute Contact contact) {
        return "author/contact";
    }


}
