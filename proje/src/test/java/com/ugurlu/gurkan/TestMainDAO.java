package com.ugurlu.gurkan;

import com.ugurlu.gurkan.analysis.Admin;
import com.ugurlu.gurkan.analysis.BrowserDetails;
import com.ugurlu.gurkan.analysis.WebPage;
import com.ugurlu.gurkan.analysis.WebUser;
import com.ugurlu.gurkan.config.AppConfig;
import com.ugurlu.gurkan.config.WebAppInitializer;
import com.ugurlu.gurkan.config.WebConfig;
import com.ugurlu.gurkan.dao.MainDAO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TestMainDAO {
    @Autowired
    private MainDAO dao;

    @Test
    public void loadObject() {
        Object object= dao.loadObject(Admin.class,1l);
        Assert.assertTrue(object!=null);
        // Admin idsi 1 olan nesne var mı diye baktı varsa true döndü. Cevap == true

    }
    @Test
    public void saveOrUpdateObject() {
        Admin admin=new Admin();
        admin.setName("Furkan");
        admin.setMail("furkan_taha_lapanta@gmail.com");
        admin.setPassword("123");
        admin.setSurname("Taha Lapanta");
       Boolean success= dao.saveOrUpdateObject(admin);

        Assert.assertTrue(success);
        // Bir admin ekleme testi. Cevap == true
    }
    @Test
    public void removeObject(){
        boolean success= dao.removeObject(new Admin());
        Assert.assertTrue(success);
        //Bir admin nesnesi yolladık  ve cevap = true
    }
    @Test
    public void loadAdmin(){
        List<Admin> admins= dao.loadAdmin();
        Assert.assertTrue(admins.size()>0);
        //Adminler çekildi cevap == true
    }
    @Test
    public void testAdminName(){
        String name="Gurkan";
        Admin admin=(Admin)dao.loadObject(Admin.class,1l);
        Assert.assertEquals(admin.getName(),name);
        // Adlar kıyaslandı cevap == true

    }

    @Test
    public void loadUsers(){
        List<WebUser> webUsers=dao.loadUsers();
        Assert.assertTrue(webUsers.size()>0);
        //Kullanıcıların bilgileri çekildi cevap == true
    }
    @Test
    public void loadBrowsers(){
        List<BrowserDetails> browsers=dao.loadBrowsers();
        Assert.assertTrue(browsers.size()>0);
        // Kullanıcıların Browser_Detailsleri çekildi cevap == true.

    }
    @Test
    public void loadOsName(){
        Map<String,Integer> values=dao.loadOsName();
        Assert.assertTrue(values.size()>0);
        //İşletim sistemi key value cevap == true
    }
    @Test
    public void loadWebPages(){
        List<WebPage> webPages=dao.loadWebPages();
        Assert.assertTrue(webPages.size()>0);
        // Web Sayfalarının boyutu 0 dan büyük ise cevap == true
    }
    @Test
    public void loadUsersById99999(){
        WebUser webUser=(WebUser) dao.loadObject(WebUser.class,99999l);
        Assert.assertFalse(webUser!=null);

        //9999 id li user var mı diye baktık. cevap == false
    }

}
