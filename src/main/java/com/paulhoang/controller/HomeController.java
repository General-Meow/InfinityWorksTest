package com.paulhoang.controller;

import com.paulhoang.data.AuthorityData;
import com.paulhoang.data.AuthorityListData;
import com.paulhoang.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Home page controller that retrieves the list of authorities
 * Created by paul on 25/05/15.
 */
@Controller
public class HomeController {

    @Autowired
    private RequestService requestService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(final Model model)
    {
        final AuthorityListData authorityData = requestService.getAuthorities();
        model.addAttribute("authorityData", authorityData);
        model.addAttribute("authorityForm", new AuthorityData());

        return "home";
    }

}
