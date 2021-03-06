package com.pvs.personalvalues.controller;

import com.pvs.personalvalues.model.msg.CollectionMsg;
import com.pvs.personalvalues.service.ComparisonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/collect")
public class CollectionController {
    private Logger LOGGER = LoggerFactory.getLogger(ComparisonController.class);

    @Autowired
    ComparisonService service;

    @RequestMapping("/getAverageDataByUserData")
    public void GetAverageDataByUserData(HttpServletResponse response, HttpSession session){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"data.csv\"");


        try {
            OutputStream out = response.getOutputStream();
            service.getCsvFile(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }
}
