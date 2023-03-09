package sesac.sesac.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hi") //app.get
    public String getHi(Model model){

        model.addAttribute("msg", "메시지입니다!");
        model.addAttribute("utext", "<strong>utext입니다.</strong>");
        model.addAttribute("age", 20);
        //res.render("hi", model)
        return "hi"; //res.render("hi)
    }



}

