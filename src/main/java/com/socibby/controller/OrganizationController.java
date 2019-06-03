package com.socibby.controller;

import com.socibby.model.Category;
import com.socibby.model.Organization;
import com.socibby.model.Photo;
import com.socibby.model.User;
import com.socibby.service.CategoryService;
import com.socibby.service.OrganizationService;
import com.socibby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/organization")
public class OrganizationController {

    private final UserService userService;

    private final CategoryService categoryService;

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(UserService userService, CategoryService categoryService, OrganizationService organizationService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.organizationService = organizationService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@ModelAttribute("registerOrganization") Organization organization, HttpSession session, ModelMap modelMap) {

        User user = (User) session.getAttribute("user");
        Organization validOrganization = (Organization) session.getAttribute("organization");

        if (user != null) {
            return "home/multiAccount";
        }

        // organization valid
        if (validOrganization != null) {
            List<Organization> organizationList = organizationService.getOrganizationByOrganization(validOrganization);
            modelMap.addAttribute("organizations", organizationList);
            return "home/dashboard";
        }

        return "organization/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String save(@ModelAttribute("registerOrganization") @Valid Organization organization, BindingResult bindingResult, ModelMap modelMap, @RequestParam("your_picture") MultipartFile file, HttpSession session) {

        if (bindingResult.hasErrors()) {
            return "organization/register";
        }

        String userName = organization.getUsername();
        imageUploadOperations(userName, file);
        String filePath = organization.getUsername() + File.separator + "logo.png";

        Photo photo = new Photo(filePath);
        organization.getPhotoSet().add(photo);
        assignCategory(organization);

        organizationService.insertOrganization(organization);

        session.setAttribute("organization", organization);

        // Home page'de ilgili organizasyonun kategorisine göre il,ilçe ve ülke bilgilerine göre olan toplulukları görüntüle.

        List<Organization> organizationByOrganization = organizationService.getOrganizationByOrganization(organization);

        modelMap.addAttribute("organizations", organizationByOrganization);

        return "home/dashboard";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@ModelAttribute("organization") Organization organization, HttpSession session, ModelMap modelMap) {

        Organization validOrganization = (Organization) session.getAttribute("organization");

        User user = (User) session.getAttribute("user");

        if (user != null) {
            return "home/multiAccount";
        }

        // organization valid
        if (validOrganization != null) {
            List<Organization> organizationList = organizationService.getOrganizationByOrganization(validOrganization);
            modelMap.addAttribute("organizations", organizationList);
            return "home/dashboard";
        }

        return "organization/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("organization") Organization organization, ModelMap modelMap, HttpSession session) {

        String username = organization.getUsername();
        String password = organization.getPassword();

        Organization validOrganization = organizationService.validateOrganization(username, password);

        // organization valid
        if (validOrganization != null) {
            session.setAttribute("organization", validOrganization);
            List<Organization> organizationList = organizationService.getOrganizationByOrganization(validOrganization);
            modelMap.addAttribute("organizations", organizationList);
            return "home/dashboard";
        }

        // organization not valid redirect /login page
        modelMap.addAttribute("errorLogin", "Giriş bilgileriniz geçersiz !");
        return "organization/login";
    }

    @RequestMapping(value = "{username}", method = RequestMethod.GET)
    public String getOrganizationByUsername(@PathVariable("username") String username, ModelMap modelMap) {
        Organization organization = organizationService.getOrganization(username);

        // Organization not found ...
        if (organization == null) {
            modelMap.addAttribute("foundedOrganization", "false");
            return "organization/search";
        }

        modelMap.addAttribute("organizationInformation", organization);
        return "organization/profile";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchOrganizationByUsername(@RequestParam(value = "username", required = false) String searchOrganizationByUsername, ModelMap modelMap) {
        Organization organization = organizationService.getOrganization(searchOrganizationByUsername);

        if (organization == null) {
            return "organization/search";
        }
        modelMap.addAttribute("organizationInformation", organization);
        return "organization/profile";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchOrganizationByUsername(@ModelAttribute("username") String organizationUsername) {
        organizationService.getOrganization(organizationUsername);
        return "organization/profile";
    }

    @RequestMapping(value = "/update/{organizationId}", method = RequestMethod.GET)
    public String updateProfile(@PathVariable("organizationId") Long id, HttpSession session, ModelMap modelMap) {

        Organization validOrganization = (Organization) session.getAttribute("organization");

        if (validOrganization != null) {

            if (validOrganization.getId() == id) {
                Organization organization = organizationService.getOrganizationById(id);
                modelMap.addAttribute("organizationInformation", validOrganization);
                modelMap.addAttribute("organization", organization);
                return "organization/editProfile";
            } else {
                modelMap.addAttribute("organizationInformation", validOrganization);
                return "organization/profile";
            }
        }
        return "index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("organization") Organization organization, HttpSession session, ModelMap modelMap) {
        Organization validOrganization = (Organization) session.getAttribute("organization");

        organization.setId(validOrganization.getId());
        organization.setUsername(validOrganization.getUsername());
        organization.setPhotoSet(validOrganization.getPhotoSet());
        organization.getContact().setId(validOrganization.getContact().getId());

        assignCategory(organization);

        organizationService.updateOrganization(organization);

        session.setAttribute("organization", organization);
        modelMap.addAttribute("organizationInformation", organization);

        return "organization/profile";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(HttpSession session, ModelMap modelMap) {

        Organization validOrganization = (Organization) session.getAttribute("organization");

        // organization valid
        if (validOrganization != null) {
            List<Organization> organizationList = organizationService.getOrganizationByOrganization(validOrganization);
            modelMap.addAttribute("organizations", organizationList);
            return "home/dashboard";
        }
        return "index";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profilePage(HttpSession session, ModelMap modelMap) {
        Organization validOrganization = (Organization) session.getAttribute("organization");
        if (validOrganization != null) {
            modelMap.addAttribute("organizationInformation", validOrganization);
            return "organization/profile";
        }

        return "organization/search";
    }

    private void imageUploadOperations(String userName, MultipartFile file) {

        // TOMCAT_HOME_PATH --> /opt/tomcat

        String TOMCAT_HOME_PATH = System.getProperty("catalina.home");
        String IMAGES_FOLDER_NAME = "organizations";
        //  " /opt/tomcat + / + images " folder path

        String IMAGES_FOLDER_PATH = TOMCAT_HOME_PATH + File.separator + IMAGES_FOLDER_NAME;
        File IMAGES_DIRECTORY = new File(IMAGES_FOLDER_PATH);
        String IMAGES_DIRECTORY_ABSOLUTE_PATH = IMAGES_DIRECTORY.getAbsolutePath() + File.separator;

        if (file.isEmpty()) {
            System.out.println("IMAGE IS EMPTY!");

            String ORGANIZATION_FOLDER_NAME = IMAGES_DIRECTORY_ABSOLUTE_PATH + userName;
            File ORGANIZATION_DIRECTORY = new File(ORGANIZATION_FOLDER_NAME);

            if (!ORGANIZATION_DIRECTORY.exists()) {
                System.out.println("ORGANIZASYONA AIT FOLDER OLUŞTURULDU --> PATH : " + ORGANIZATION_FOLDER_NAME);
                ORGANIZATION_DIRECTORY.mkdirs();
            }

            try {

                File defaultFile = new File(IMAGES_DIRECTORY_ABSOLUTE_PATH + "company.png");
                BufferedImage bufferedImage = ImageIO.read(defaultFile);
                String uploadedFilePath = ORGANIZATION_FOLDER_NAME + File.separator + "logo.png";
                ImageIO.write(bufferedImage, "png", new File(uploadedFilePath));

            } catch (Exception e) {
                System.out.println("Hata !");
            }


        } else {
            if (!IMAGES_DIRECTORY.exists()) {
                System.out.println("IMAGES KLASORU OLUŞTURULDU -> PATH : " + IMAGES_DIRECTORY_ABSOLUTE_PATH);
                IMAGES_DIRECTORY.mkdirs();
            }

            String ORGANIZATION_FOLDER_NAME = IMAGES_DIRECTORY_ABSOLUTE_PATH + userName;
            File ORGANIZATION_DIRECTORY = new File(ORGANIZATION_FOLDER_NAME);

            if (!ORGANIZATION_DIRECTORY.exists()) {
                System.out.println("ORGANIZASYONA AIT FOLDER OLUŞTURULDU --> PATH : " + ORGANIZATION_FOLDER_NAME);
                ORGANIZATION_DIRECTORY.mkdirs();
            }
            try {
                String fileName = "logo.png";
                System.out.println();
                String uploadedFilePath = ORGANIZATION_FOLDER_NAME + File.separator + fileName;

                File image = new File(uploadedFilePath);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(image));

                stream.write(file.getBytes());
                stream.close();

            } catch (Exception e) {
                System.out.println("Hata");
            }

        }

    }

    private void assignCategory(Organization organization) {

        String categoryName = organization.getCategory().getName();

        Category foundedCategory = categoryService.getCategoryByName(categoryName);

        organization.setCategory(foundedCategory);

        foundedCategory.getOrganizationSet().add(organization);

        categoryService.updateCategory(foundedCategory);

    }

    @ModelAttribute("categoryList")
    public List<String> prepareCategoryList() {
        List<Category> allCategory = categoryService.getAllCategory();
        List<String> categoryNameList = new ArrayList<String>();
        for (Category category : allCategory) {
            categoryNameList.add(category.getName());
        }
        return categoryNameList;
    }

}
