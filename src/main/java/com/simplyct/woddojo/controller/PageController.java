package com.simplyct.woddojo.controller;

import com.simplyct.woddojo.helper.PortalHelper;
import com.simplyct.woddojo.helper.dto.AboutPage;
import com.simplyct.woddojo.helper.dto.CoachDetail;
import com.simplyct.woddojo.helper.dto.GymDetail;
import com.simplyct.woddojo.helper.dto.HomePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by cyril on 5/25/15.
 */
@Controller
@RequestMapping("/")
public class PageController {

    @Autowired
    PortalHelper portalHelper;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpSession httpSession) {
        Long orgId = (Long) httpSession.getAttribute("orgId");
        HomePage homePage = portalHelper.getHomePage(orgId);

        model.addAttribute("homeObj", homePage);

        return "index";
    }

    @RequestMapping(value = "about", method = RequestMethod.GET)
    public String about(Model model, HttpSession httpSession) {
        Long orgId = (Long) httpSession.getAttribute("orgId");
        AboutPage aboutPage = portalHelper.getAboutPage(orgId);
        List<CoachDetail> coaches = portalHelper.getCoaches(orgId);

        model.addAttribute("aboutObj", aboutPage);
        model.addAttribute("coaches", coaches);
        return "about";
    }

    @RequestMapping(value = "contact", method = RequestMethod.GET)
    public String contact(Model model, HttpSession httpSession) {
        Long orgId = (Long) httpSession.getAttribute("orgId");
        GymDetail gymDetail = portalHelper.getGymDetail(orgId);

        model.addAttribute("gymObj", gymDetail);

        return "contact";
    }
    
    @RequestMapping(value = "server_status", method = RequestMethod.GET)
    public String serverStatus() {
    	return "server_status";
    }

}