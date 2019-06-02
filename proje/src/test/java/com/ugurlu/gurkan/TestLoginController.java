package com.ugurlu.gurkan;

import com.ugurlu.gurkan.analysis.WebPage;
import com.ugurlu.gurkan.config.AppConfig;
import com.ugurlu.gurkan.config.WebAppInitializer;
import com.ugurlu.gurkan.config.WebConfig;
import com.ugurlu.gurkan.service.MainService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppInitializer.class, AppConfig.class, WebConfig.class})
@Transactional
@WebAppConfiguration
public class TestLoginController {
    @Autowired
    private LoginController loginController;

    @Test
    public void users(){
        MockHttpServletRequest request=new MockHttpServletRequest();
        String sonuc=loginController.users(null,request);
        Assert.assertEquals("sonuc",sonuc);

        // admin/users isteği users döndürüyor mu diye baktık cevap == true
    }
    @Test
    public void loadUsers(){
        MockHttpServletRequest request=new MockHttpServletRequest();
        Boolean webUsers=loginController.getMainService().loadUsers(request);
        Assert.assertTrue(webUsers==true);
        // admin/users isteği içerisindeki mainService.loadUsers() kullanıcılar döndürüyor mu diye baktık cevap == true

    }
    @Test
    public void webPages(){
        MockHttpServletRequest request=new MockHttpServletRequest();;
        String sonuc=loginController.webpages(null,request);
        Assert.assertEquals("webpages",sonuc);

        // admin/webpages isteği webpages döndürüyor mu diye baktık cevap == true
    }
    @Test
    public void loadWebPages(){
        List<WebPage>  webPages=loginController.getMainService().loadWebPages(null);
        Assert.assertTrue(webPages.size()>0);

        // admin/webpages isteği içerisindeki bu işlemler web sayfalarını dönddürüyor cevap == true
    }
    @Test
    public void login(){
        MockHttpServletRequest request=new MockHttpServletRequest();
        MockHttpServletResponse response=new MockHttpServletResponse();
        String sonuc=loginController.login(request,response,null);
        Assert.assertEquals("login",sonuc);

       // admin/login isteği login döndürüyor mu diye baktık cevap == true
    }
    @Test
    public void postLogin(){
        MockHttpServletRequest request=new MockHttpServletRequest();
        MockHttpServletResponse response=new MockHttpServletResponse();
        String mail="gurkan_henry_96@hotmail.com";
        String password="21s4a68d12";
        String sonuc= loginController.loginYonlendir(request,response,mail,password,null);
        Assert.assertTrue(sonuc=="redirect:adminpanel");

        // admin/login formundan gönderilen POST isteğinin sonucu cevap == true
    }
    @Test
    public void postLogin2(){
        MockHttpServletRequest request=new MockHttpServletRequest();
        MockHttpServletResponse response=new MockHttpServletResponse();
        String mail="gurkan_henry_96@hotmail.com";
        String password="asagh";
        String sonuc= loginController.loginYonlendir(request,response,mail,password,null);
        Assert.assertFalse(sonuc=="redirect:adminpanel");

        // admin/login formundan gönderilen POST isteğinin sonucu cevap == false doğru cevap login
    }
    @Test
    public void adminPanel(){
        MockHttpServletRequest request=new MockHttpServletRequest();
        MockHttpServletResponse response=new MockHttpServletResponse();
        String sonuc=loginController.adminPanel(request,response,null);
        Assert.assertEquals("adminpanel",sonuc);
        //İçerisindeki tüm fonksiyonlar çalıştı cevap == true
    }
    @Test
    public void browserNames(){
        boolean success=loginController.getMainService().loadBrowserName(null);
        Assert.assertTrue(success==true);
    }
    @Test
    public void adminPanelBrowserCount(){
        //daha önceki fonksiyonlarda bazı bileşenlerin değerleri denendiği için bazılarını yazalım.
        Map<String,Integer> browsersCount=loginController.getMainService().totalBrowserCount(null);
        Assert.assertTrue( browsersCount.size()>0);

        // browserlar yüklendi ve browserSayisi >0 dan büyük geldi.
    }
    @Test
    public void findBiggestSessionTime(){
        boolean success=loginController.getMainService().findBiggestSessionTime(null);
        Assert.assertFalse(success==false);
    }
    @Test
    public void adminPanelTotalCounts(){
        boolean success=loginController.getMainService().totalCounts(null);
        Assert.assertFalse(success==false);

        // True dönmesi gereken iki değerde false döndü cevap == true
    }
    @Test
    public void findLastThirtyDayUser(){
        boolean success2=loginController.getMainService().findLastThirtyDayUsers(null);
        Assert.assertTrue( success2==true);

    }
    @Test
    public void findAverageSessionTime(){
        boolean success=loginController.getMainService().findAverageSessionTime(null);
        Assert.assertTrue(success==true);

        //İkisi de true dönmelidir. cevap == true

    }
    @Test
    public void bringUserId5(){
        String sonuc=loginController.bringUserId(5l,null);
        Assert.assertEquals("userinf",sonuc);
        // id si 5 olan bir istek yolladık cevap == true
    }
    @Test
    public void getMainService(){
        MainService mainService=loginController.getMainService();
        Assert.assertTrue(mainService!=null);
        //Main Service nesnesi cevap == true
    }


}
