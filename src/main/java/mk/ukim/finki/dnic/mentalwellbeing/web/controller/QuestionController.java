package mk.ukim.finki.dnic.mentalwellbeing.web.controller;


import mk.ukim.finki.dnic.mentalwellbeing.model.Question;
import mk.ukim.finki.dnic.mentalwellbeing.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public String getQuestionPage(Model model) {
        List<Question> questionList=this.questionService.findAll();
        model.addAttribute("questionList",questionList);
        model.addAttribute("bodyContent", "question");
        return "master-template";
    }
    @GetMapping("/askQuestion")
    public String askQuestionPage(Model model) {
            model.addAttribute("bodyContent", "askQuestion");
            return "master-template";
    }
    @PostMapping("/askQuestion")
    public String QuestionPage(Model model, @RequestParam(required = false) String email, @RequestParam(required = false) String question) {
        if(!validateEmail(email)) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", "Внесете валиден мејл! - test@mail.com");
            model.addAttribute("bodyContent", "askQuestion");
            return "master-template";
        }
        int size=questionService.findAll().size()+1;
        Question q1= new Question((long)size,question,"");
        questionService.save(q1);
        return "redirect:/questions";
    }
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}
