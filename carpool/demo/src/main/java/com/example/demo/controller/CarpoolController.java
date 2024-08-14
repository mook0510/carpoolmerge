package com.example.demo.controller;

import com.example.demo.dao.CarpoolDao;
import com.example.demo.dao.CarpoolObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class CarpoolController {

    private final CarpoolDao carpoolDao;

    @Autowired
    public CarpoolController(CarpoolDao carpoolDao) {
        this.carpoolDao = carpoolDao;
    }

    @RequestMapping(value = "/carpool", method = {RequestMethod.GET, RequestMethod.POST})
    public String getList(Model model){
        model.addAttribute("resp", carpoolDao.getList());
        return "/carpool";
    }

    @RequestMapping(value = "/carpool/regCarpoolPage", method = {RequestMethod.GET, RequestMethod.POST})
    public String regCarpoolPage(){
        return "/regCarpool";
    }

    @PostMapping("/carpool/regCarpool")
    @ResponseBody
    public String regCarpool(CarpoolObj carpoolObj) {
        return carpoolDao.saveCarpool(carpoolObj);
    }

    @GetMapping("/carpool/detail/{id}")
    public String getDetail(@PathVariable Long id, Model model){
        model.addAttribute("resp", carpoolDao.getDetail(id));
        return "/carpoolDetail";
    }
}
