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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final CategoryService categoryService;

    private final OrganizationService organizationService;

    @Autowired
    public UserController(UserService userService, CategoryService categoryService, OrganizationService organizationService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.organizationService = organizationService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@ModelAttribute("registerUser") User user, HttpSession session, ModelMap modelMap) {

        User validUser = (User) session.getAttribute("user");
        Organization organization = (Organization) session.getAttribute("organization");

        if (organization != null) {
            return "home/multiAccount";
        }

        if (validUser != null) {
            List<Organization> organizationByUser = organizationService.getOrganizationByUser(validUser);
            modelMap.addAttribute("organizations", organizationByUser);
            return "home/dashboard";
        }

        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String save(@ModelAttribute("registerUser") @Valid User user, BindingResult bindingResult, ModelMap modelMap,
                       @RequestParam("your_picture") MultipartFile file, HttpSession session) {

        if (bindingResult.hasErrors()) {
            return "user/register";
        }

        imageUploadOperations(user.getUsername(), file);


        String filePath = user.getUsername() + File.separator + "profile.png";
        Photo photo = new Photo(filePath);
        user.setPhoto(photo);


        Set<Category> categorySet = user.getCategorySet();
        Set<Category> realCategorySet = new HashSet<Category>();

        assignCategory(categorySet, realCategorySet, user);

        userService.insertUser(user);

        session.setAttribute("user", user);

        List<Organization> organizationByUser = organizationService.getOrganizationByUser(user);

        modelMap.addAttribute("organizations", organizationByUser);

        return "home/dashboard";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@ModelAttribute("user") User user, HttpSession session, ModelMap modelMap) {

        Organization organization = (Organization) session.getAttribute("organization");
        User validUser = (User) session.getAttribute("user");

        if (organization != null) {
            return "home/multiAccount";
        }

        if (validUser != null) {
            List<Organization> organizationByUser = organizationService.getOrganizationByUser(validUser);
            modelMap.addAttribute("organizations", organizationByUser);
            return "home/dashboard";
        }

        return "user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") User user, ModelMap modelMap, HttpSession session) {

        String username = user.getUsername();
        String password = user.getPassword();

        User validUser = userService.validateUser(username, password);

        if (validUser != null) {
            session.setAttribute("user", validUser);
            List<Organization> organizationByUser = organizationService.getOrganizationByUser(validUser);
            modelMap.addAttribute("organizations", organizationByUser);
            return "home/dashboard";
        }
        modelMap.addAttribute("errorLogin", "Giriş bilgileriniz geçersiz !");
        return "user/login";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profilePage(@ModelAttribute("updateUser") User user, HttpSession session, ModelMap modelMap) {
        User validUser = (User) session.getAttribute("user");

        if (validUser != null) {
            modelMap.addAttribute("userInformation", validUser);
            return "user/profile";
        }

        return "index";
    }

    @RequestMapping(value = "/update/{userId}", method = RequestMethod.GET)
    public String updateProfile(@PathVariable("userId") Long id, HttpSession session, ModelMap modelMap) {
        User validUser = (User) session.getAttribute("user");

        if (validUser != null) {

            if (validUser.getId() == id) {
                User user = userService.getUserById(id);
                modelMap.addAttribute("userInformation", validUser);
                modelMap.addAttribute("user", user);
                return "user/editProfile";
            } else {
                modelMap.addAttribute("userInformation", validUser);
                return "user/profile";
            }
        }

        return "index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user, HttpSession session, ModelMap modelMap) {

        User validUser = (User) session.getAttribute("user");

        user.setId(validUser.getId());
        user.setUsername(validUser.getUsername());
        user.setPhoto(validUser.getPhoto());

        Set<Category> categorySet = user.getCategorySet();
        Set<Category> realCategorySet = new HashSet<Category>();

        assignCategory(categorySet, realCategorySet, user);
        System.out.println(user);

        userService.updateUser(user);

        session.setAttribute("user", user);
        modelMap.addAttribute("userInformation", user);
        modelMap.addAttribute("user", user);
        return "user/profile";
    }

    @RequestMapping()
    public String home(HttpSession session, ModelMap modelMap) {

        User validUser = (User) session.getAttribute("user");

        if (validUser != null) {
            List<Organization> organizationByUser = organizationService.getOrganizationByUser(validUser);
            modelMap.addAttribute("organizations", organizationByUser);
            return "home/dashboard";
        }

        return "index";
    }

    private void imageUploadOperations(String userName, MultipartFile file) {

        // TOMCAT_HOME_PATH --> /opt/tomcat

        String TOMCAT_HOME_PATH = System.getProperty("catalina.home");
        String IMAGES_FOLDER_NAME = "images";
        //  " /opt/tomcat + / + images " folder path

        String IMAGES_FOLDER_PATH = TOMCAT_HOME_PATH + File.separator + IMAGES_FOLDER_NAME;
        File IMAGES_DIRECTORY = new File(IMAGES_FOLDER_PATH);
        String IMAGES_DIRECTORY_ABSOLUTE_PATH = IMAGES_DIRECTORY.getAbsolutePath() + File.separator;


        if (file.isEmpty()) {
            System.out.println("IMAGE IS EMPTY");

            String USER_FOLDER_NAME = IMAGES_DIRECTORY_ABSOLUTE_PATH + userName;
            File USER_DIRECTORY = new File(USER_FOLDER_NAME);

            if (!USER_DIRECTORY.exists()) {
                System.out.println("KULLANICIYA AIT FOLDER OLUŞTURULDU --> PATH : " + USER_FOLDER_NAME);
                USER_DIRECTORY.mkdirs();
            }
            try {

                // ---> /opt/tomcat/images/default.png
                File defaultFile = new File(IMAGES_DIRECTORY_ABSOLUTE_PATH + "default.png");
                BufferedImage bufferedImage = ImageIO.read(defaultFile);
                String uploadedFilePath = USER_FOLDER_NAME + File.separator + "profile.png";
                // e.g omerfarukgenc34/profile.png
                ImageIO.write(bufferedImage, "png", new File(uploadedFilePath));

            } catch (Exception e) {
                System.out.println("Hata olduuuuuuuuuu!");
            }


            // File/image is not empty
        } else {
            if (!IMAGES_DIRECTORY.exists()) {
                System.out.println("IMAGES KLASORU OLUŞTURULDU --> PATH : " + IMAGES_DIRECTORY_ABSOLUTE_PATH);
                IMAGES_DIRECTORY.mkdirs();
            }

            String USER_FOLDER_NAME = IMAGES_DIRECTORY_ABSOLUTE_PATH + userName;
            File USER_DIRECTORY = new File(USER_FOLDER_NAME);

            if (!USER_DIRECTORY.exists()) {
                System.out.println("KULLANICIYA AIT FOLDER OLUŞTURULDU --> PATH : " + USER_FOLDER_NAME);
                USER_DIRECTORY.mkdirs();
            }
            try {
                String fileName = "profile.png";
                String uploadedFilePath = USER_FOLDER_NAME + File.separator + fileName;
                // e.g omerfarukgenc34/profile.png
                File image = new File(uploadedFilePath);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(image));

                stream.write(file.getBytes());
                stream.close();

            } catch (Exception e) {
                System.out.println("Hata");
            }

        }

    }

    private void assignCategory(Set<Category> categorySet, Set<Category> realCategorySet, User user) {

        // realCategorySet kullanıcının seçmiş olduğu kategorilerin gerçek değeriyle dolduruldu.
        for (Category category : categorySet) {
            String categoryName = category.getName();
            Category categoryByName = categoryService.getCategoryByName(categoryName);
            realCategorySet.add(categoryByName);
        }
        user.getCategorySet().removeAll(categorySet);

        // Tüm kategoriler sırasıyla gezilip kullanıcıya hepsi teker teker eklendi.
        for (Category category : realCategorySet) {
            user.getCategorySet().add(category);
            category.getUserSet().add(user);
            categoryService.updateCategory(category);
        }
    }

    @ModelAttribute("categoryList")
    public List<String> prepareCategoryList() {
        List<Category> allCategory = categoryService.getAllCategory();
        List<String> categoryNameList = new ArrayList<String>();
        for (Category category : allCategory) {
            String categoryName = category.getName();
            categoryNameList.add(categoryName);
        }
        return categoryNameList;
    }

}
