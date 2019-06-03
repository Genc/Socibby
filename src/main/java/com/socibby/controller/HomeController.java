package com.socibby.controller;

import com.socibby.model.Category;
import com.socibby.model.Organization;
import com.socibby.model.User;
import com.socibby.service.CategoryService;
import com.socibby.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    private final OrganizationService organizationService;

    private final CategoryService categoryService;

    @Autowired
    public HomeController(OrganizationService organizationService, CategoryService categoryService) {
        this.organizationService = organizationService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }

    @RequestMapping("/index")
    public String homePage() {
        return "index";
    }

    @RequestMapping("/about")
    public String aboutPage() {
        return "home/about";
    }

    @RequestMapping("/contact")
    public String contactPage() {
        return "home/contact";
    }

    @RequestMapping("/userAgreement")
    public String userAgreement() {
        return "home/userAgreement";
    }

    @RequestMapping("/organizationAgreement")
    public String organizationAgreement() {
        return "home/organizationAgreement";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }

    @RequestMapping(value = "/tag/{categoryName}")
    public String tagController(@PathVariable("categoryName") String categoryName, ModelMap modelMap, HttpSession session) {

        Organization organization = (Organization) session.getAttribute("organization");
        User validUser = (User) session.getAttribute("user");

        if (organization == null && validUser == null) {
            return "index";
        }

        Category categoryByName = categoryService.getCategoryByName(categoryName);

        if (categoryByName == null) {
            return "index";
        }

        List<Organization> organizationByCategoryName = organizationService.getOrganizationByCategoryName(categoryName);

        modelMap.addAttribute("organizations", organizationByCategoryName);

        return "home/dashboard";
    }

}
