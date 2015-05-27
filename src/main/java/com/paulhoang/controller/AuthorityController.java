package com.paulhoang.controller;

import com.paulhoang.data.AuthorityData;
import com.paulhoang.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Controller to retrieve calculated establishment data
 * Created by paul on 25/05/15.
 */
@Controller
public class AuthorityController {

    @Autowired
    private RequestService requestService;

    @RequestMapping(value = "/postAuthorityData", method = RequestMethod.POST)
    public String postAuthorityData(final AuthorityData authorityData, final Model model)
    {
        final Map<String, String> establishmentData =
                requestService.getEstablishmentData(authorityData.getLocalAuthorityId());
        model.addAttribute("establishmentData", establishmentData);

        return "authority";
    }
}
