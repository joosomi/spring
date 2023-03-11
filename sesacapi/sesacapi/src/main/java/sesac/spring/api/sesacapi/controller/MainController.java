package sesac.spring.api.sesacapi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String main() {
        return "request";
    }
    @GetMapping("/get/response1")
    public String getAPI1(@RequestParam(value= "name", required = true) String name2, Model model){
        model.addAttribute("name", name2);
        return "response";
    }

    //required = true이면 빈값이라도 무조건 값이 보내져야함.
    //값이 없다면 에러가 뜨게 된다. 값을 보내기도 하고 안보낸다면 false라고 설정해주어야 한다. default는 true
    @GetMapping("/get/response2")
    public String getAPI2(@RequestParam(value= "name", required = false) String name2, Model model){
        model.addAttribute("name", name2);
        return "response";
    }

    @GetMapping({"/get/response4/{name}", "/get/response4/{name}/{age}"})
    public String getAPI3(@PathVariable String name, @PathVariable(value = "age", required = false) String abc, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", abc);
        return "response";
    }


}
