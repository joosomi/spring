package sesac.sesac.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sesac.sesac.spring.Person;

import java.util.ArrayList;

@Controller
public class HelloController {

    @GetMapping("/hi") //app.get
    public String getHi(Model model) {

        model.addAttribute("msg", "메시지입니다!");
        model.addAttribute("utext", "<strong>utext입니다.</strong>");
        model.addAttribute("age", 20);
        //res.render("hi", model)
        return "hi"; //res.render("hi)
    }

    @GetMapping("/people")
        public String getPeople(Model model) {
            ArrayList<Person> people = new ArrayList<Person>();
            people.add(new Person("이름1",  10));
            people.add(new Person("이름2",  20));
            people.add(new Person("이름3",  30));
            people.add(new Person("이름4",  40));

            model.addAttribute("people", people);
            return "people";
        }
    }


