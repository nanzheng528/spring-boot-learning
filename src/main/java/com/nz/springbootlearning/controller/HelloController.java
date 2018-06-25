package com.nz.springbootlearning.controller;

import com.nz.springbootlearning.bean.GreetingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.modelmbean.ModelMBean;

@Controller
@EnableConfigurationProperties({GreetingBean.class})
public class HelloController {
    @Autowired
    GreetingBean GreetingBean;
    @PostMapping("/aa")
    public String hello(ModelMap map){
        map.addAttribute("host","nanzheng.com");
        return "index";
    }

    @RequestMapping("/lucy")
    public  String lucy(){
          return GreetingBean.getGreeting()+" >>>>"+GreetingBean.getName()+" >>>>"+ GreetingBean.getUuid()+" >>>>"+GreetingBean.getMax();
    }
}
