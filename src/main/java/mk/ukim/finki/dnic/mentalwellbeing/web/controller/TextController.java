package mk.ukim.finki.dnic.mentalwellbeing.web.controller;

import mk.ukim.finki.dnic.mentalwellbeing.model.Text;
import mk.ukim.finki.dnic.mentalwellbeing.model.enumeration.Category;
import mk.ukim.finki.dnic.mentalwellbeing.service.TextService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/text")
public class TextController {
    private final TextService textService;

    public TextController(TextService textService) {
        this.textService = textService;
    }
    @GetMapping("/education/{category}")
    public String TextController(Model model, @PathVariable String category){
        List<Text> texts = textService.findAllByCategory(Category.valueOf(category));
        if(texts==null || texts.size()==0){
            return "notfound";
        }
        model.addAttribute("texts",texts);
        model.addAttribute("bodyContent", "textPage");
        model.addAttribute("flag","t");
        return "master-template";

    }
    @GetMapping("/get/{id}")
    public String getText(@PathVariable Long id, Model model){

        Optional <Text> result = textService.findById(id);

        if(result.isPresent()) {
            List <Text> similar = textService.findAllByCategory(result.get().getCategory())
                    .stream().filter(i->i.getId()!=id).collect(Collectors.toList());

            model.addAttribute("result", result.get());
            model.addAttribute("bodyContent", "textContent");
            model.addAttribute("similar", similar.subList(0,2));
            return "master-template";
        }
        return "notfound";
    }
}
