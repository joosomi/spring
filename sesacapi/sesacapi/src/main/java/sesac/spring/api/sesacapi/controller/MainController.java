package sesac.spring.api.sesacapi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sesac.spring.api.sesacapi.dto.UserDTO;
import vo.UserVO;

import java.util.Date;

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

    @PostMapping("/post/response1")
    public String postAPI1(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
     return "response";
    }
    @PostMapping("/post/response2")
    public String postAPI2(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "response";
    }

    @PostMapping("/post/response3")
    @ResponseBody //res.send
    public String postAPI3(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "이름은 :" + name;
    }
//실습3
    @GetMapping("/introduce/{name}")
    public String introduce(@PathVariable(value="name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "response";
    }

    @GetMapping("/introduce2")
    public String introduce2(@RequestParam(value="name", required = false) String name,@RequestParam(value="age")String age, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "response";
    }
//실습4
//@PostMapping("introduce3")
//public String introduce3(@RequestParam String name,@RequestParam String age, @RequestParam  String year, @RequestParam String interest,
//                         @RequestParam  String month,  @RequestParam  String day, Model model){
//    model.addAttribute("name", name);
//    model.addAttribute("age", age);
//    model.addAttribute("year", year);
//    model.addAttribute("interest", interest);
//    model.addAttribute("month", month);
//    model.addAttribute("day", day);
//    return "response";
//}
////DTO 수업
    @GetMapping("/dto/response1")
    @ResponseBody
    public String dtoAPI1(UserDTO userDTO){
        String msg = userDTO.getName() + " " + userDTO.getAge() + "!!!" ;
        return msg;
    }

    @PostMapping("/dto/response2")
    @ResponseBody
    public String dtoAPI2(UserDTO userDTO){
        String msg = userDTO.getName() + " " + userDTO.getAge() + "!!!" ;
        return msg;
    }

    @PostMapping("/dto/response3")
    @ResponseBody
    public String dtoAPI3(@RequestBody UserDTO userDTO){
        String msg = userDTO.getName() + " " + userDTO.getAge() + "!!!" ;
        return msg;
    }
    @GetMapping("/vo/response1")
    @ResponseBody
    public String voAPI1(UserVO uservo){
        String msg = uservo.getName() + " " + uservo.getAge() + "!!!" ;
        return msg;
    }

    @PostMapping("/vo/response2")
    @ResponseBody
    public String voAPI2(UserVO uservo){
        String msg = uservo.getName() + " " + uservo.getAge() + "!!!" ;
        return msg;
    }

    @PostMapping("/vo/response3")
    @ResponseBody
    public String voAPI3(@RequestBody UserVO uservo){
        String msg = uservo.getName() + " " + uservo.getAge() + "!!!" ;
        return msg;
    }
//////Axio DTO/////
    @GetMapping("/axios/response1")
    @ResponseBody
    public String axiosAPI1(@RequestParam(value="name") String name, @RequestParam(value="age") String age) {
        String msg= "이름 : " + name + "\n나이 : " + age;
        return msg;
    }
    @GetMapping("/axios/response2")
    @ResponseBody
    public String axiosAPI2(UserDTO userDTO) {
        String msg= "이름 : " + userDTO.getName() + "\n나이 : " + userDTO.getAge();
        return msg;
    }

    @PostMapping("/axios/response3")
    @ResponseBody
    public String axiosAPI3(@RequestParam(value="name") String name, @RequestParam(value="age") String age) {
        String msg= "이름 : " + name + "\n나이 : " + age;
        return msg;
    }
    //axios로 보낼 떄는 requestparam으로 보낼 수 없다. requestparam으로 받으려면 post는 무조건 폼 전송
    @PostMapping("/axios/response4")
    @ResponseBody
    public String axiosAPI4(UserDTO userDTO) {
        String msg= "이름 : " + userDTO.getName() + "\n나이 : " + userDTO.getAge();
        return msg;
    }
    //null
    @PostMapping("/axios/response5")
    @ResponseBody
    public String axiosAPI5(@RequestBody UserDTO userDTO) {
        String msg= "이름 : " + userDTO.getName() + "\n나이 : " + userDTO.getAge();
        return msg;
    }
/////AXIOS - VO 수업//////
@GetMapping("/axios/vo/response1")
@ResponseBody
public String axiosvoAPI1(@RequestParam(value="name") String name, @RequestParam(value="age") String age) {
    String msg= "이름 : " + name + "\n나이 : " + age;
    return msg;
}
    @GetMapping("/axios/vo/response2")
    @ResponseBody
    public String axiosvpAPI2(UserVO uservo) {
        String msg= "이름 : " + uservo.getName() + "\n나이 : " + uservo.getAge();
        return msg;
    }

    @PostMapping("/axios/vo/response3")
    @ResponseBody
    public String axiosvoAPI3(@RequestParam(value="name") String name, @RequestParam(value="age") String age) {
        String msg= "이름 : " + name + "\n나이 : " + age;
        return msg;
    }

    @PostMapping("/axios/vo/response4")
    @ResponseBody
    public String axiosvoAPI4(UserVO uservo) {
        String msg= "이름 : " + uservo.getName() + "\n나이 : " + uservo.getAge();
        return msg;
    }
    //null
    @PostMapping("/axios/vo/response5")
    @ResponseBody
    public String axiosvoAPI5(@RequestBody UserVO uservo) {
        String msg= "이름 : " + uservo.getName() + "\n나이 : " + uservo.getAge();
        return msg;
    }






}


















