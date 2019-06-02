package com.ugurlu.gurkan;

import com.ugurlu.gurkan.analysis.Runner;
import com.ugurlu.gurkan.service.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value="/admin")
public class LoginController {
    @Autowired
    private MainService mainService;
    private List<Runner> threads;

     private static Logger logger= LoggerFactory.getLogger(LoginController.class);


    @RequestMapping(value="/users")
    public String users(Model model, HttpServletRequest request){
        logger.info("Users is collecting from Databases:Started ");
        mainService.loadUsers(request);
        logger.info("Users is collecting from Databases: Completed ");
        logger.info("Requested page is /admin/users");
        return "users";
    }

    @RequestMapping(value = "/webpages")

    public String webpages(Model model, HttpServletRequest request) {
        logger.info("Webpages is collecting from Databases:Started ");
        mainService.loadWebPages(model);
        logger.info("Webpages is collecting from Databases: Completed ");
        logger.info("Requested page is /admin/webpages");
        return "webpages";
    }

    @RequestMapping(value="/login",method = RequestMethod.GET)

    public String login(HttpServletRequest request, HttpServletResponse response, Model model){
        logger.info("Requested page is /admin/login");
        return "login";
    }

    @PostMapping(value="/login")

    public String loginYonlendir(HttpServletRequest request, HttpServletResponse response, @RequestParam String mail, @RequestParam String password, Model model){
        boolean sonuc= mainService.loadAdmin(request,mail,password);
        if(sonuc==false){
            logger.info("Password is wrong, back to the /home/login ");
            return "login";
        }
        logger.info("Redirecting to /admin/adminpanel");
        return "redirect:adminpanel";

    }


    @GetMapping(value="/adminpanel")
    public String adminPanel(HttpServletRequest request, HttpServletResponse response, Model model){
        logger.info("Admin panel is loading...");
        mainService.loadOsName(model);
        mainService.loadUsersCount(model);
        mainService.loadOsCount(model);
        mainService.totalBrowserCount(model);
        mainService.loadBrowserName(model);
        mainService.totalCounts(model);
        mainService.findBiggestSessionTime(model);
        mainService.findAverageSessionTime(model);
        mainService.findLastThirtyDayUsers(model);

        logger.info("Requested page is /admin/adminpanel");
        return "adminpanel";
    }

    @GetMapping(value="/userinf/{id}")
    public String bringUserId(@PathVariable("id") Long id,Model model){
        if(id!=null){

            mainService.loadUser(model,id);
            logger.info("Requested page is /admin/userinf/ "+id.toString());
        }

        return "userinf";
    }

    public MainService getMainService() {
        return mainService;
    }

    public void setMainService(MainService mainService) {
        this.mainService = mainService;
    }
}
