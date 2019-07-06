package com.example.springboot_demo.Controller;

import com.example.springboot_demo.Modal.BlankFiling;
import com.example.springboot_demo.Service.BlankFilingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author HFZ
 * @email 1310209619@qq.com
 * @date 2019-07-06 10:59
 */
@RestController
@RequestMapping(value = {"BF"})
public class BlankFilingController {

    @Autowired
    private BlankFilingService blankFilingService;

    @RequestMapping(value = {"list"})
    public List<BlankFiling> getBlankFiling() {
        return blankFilingService.getBlankFIling();
    }

}
