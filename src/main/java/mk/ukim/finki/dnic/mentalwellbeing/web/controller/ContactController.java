package mk.ukim.finki.dnic.mentalwellbeing.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/contact")
public class ContactController {
    @GetMapping
    public String getContactPage(Model model) {
        model.addAttribute("bodyContent", "contact");
        return "master-template";
    }
    @GetMapping("/appointment")
    public String makeAppointment(Model model) {
        model.addAttribute("bodyContent", "appointment");
        return "master-template";
    }
    @PostMapping("/appointment")
    public String checkAppointment(Model model, String phone, String email) {
        if(!validateEmail(email)&&!validatePhone(phone)){
            model.addAttribute("hasError", true);
            model.addAttribute("error", "Внесете валиден мејл - test@mail.com и валиден број - XXX XXX XXX ");
            model.addAttribute("bodyContent", "appointment");
            return "master-template";
        }
        if(!validateEmail(email)) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", "Внесете валиден мејл! - test@mail.com");
            model.addAttribute("bodyContent", "appointment");
            return "master-template";
        }
        if(!validatePhone(phone)) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", "Внесете валиден број! - XXX XXX XXX");
            model.addAttribute("bodyContent", "appointment");
            return "master-template";
        }

        return "redirect:/";
    }
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
    public static boolean validatePhone(String phone){
        return phone.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}");
    }
}
