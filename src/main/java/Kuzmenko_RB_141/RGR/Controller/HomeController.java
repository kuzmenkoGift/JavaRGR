package Kuzmenko_RB_141.RGR.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String Home(){
        return "Home";
    }
}
