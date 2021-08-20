package mk.ukim.finki.dnic.mentalwellbeing.web.controller;

import mk.ukim.finki.dnic.mentalwellbeing.model.Text;
import mk.ukim.finki.dnic.mentalwellbeing.service.TextService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private final TextService textService;

    public HomeController(TextService textService) {
        this.textService = textService;
    }

    @GetMapping
    public String getHomePage(Model model) {

        List<Text> texts = textService.findAll().subList(0,3);
        model.addAttribute("texts",texts);
        model.addAttribute("bodyContent", "homepage");
        return "master-template";
    }
    @GetMapping("/searchText")
    public String SearchText(Model model, String search) {

        List<Text> texts = textService.findAllByKey(search);
        if(texts==null || texts.size()==0){
            return "notfound";
        }
        if(texts.size()>3){
            texts= texts.subList(0,3);
        }
        model.addAttribute("texts",texts);
        model.addAttribute("bodyContent", "textPage");
        model.addAttribute("flag","k");
        return "master-template";
    }

}
