package com.example.projectTestLibrary.Controller;

import com.example.projectTestLibrary.MailComponent;
import com.example.projectTestLibrary.Model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    MailComponent mailComponent;

    @PostMapping("/sendMail")
    public String processFormContact(@Validated Contact contact, BindingResult bindingResult, RedirectAttributes model) {
        if (bindingResult.hasErrors()) {
            return "author/contact";
        }

        if (mailComponent.sendHtmlMail(contact)) {
            model.addFlashAttribute("message", "Twoja wiadomość zostałą wysłana");
            model.addFlashAttribute("mailSendAlert", "alert alert-success");
        } else {
            model.addFlashAttribute("message", "Wystąpił błąd Twoja wiadomość nie została wysłana");
            model.addFlashAttribute("mailSendAlert", "alert alert-warning");
        }

        return "redirect:/contact/";
    }

    @GetMapping("/")
    String contact(@ModelAttribute Contact contact) {
        return "author/contact";
    }


}
