package com.example.eadminconsumer.indexHtml;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Index")
public class Index {

    @RequestMapping("/index")
    public String index(){
        return "test";
    }
}
