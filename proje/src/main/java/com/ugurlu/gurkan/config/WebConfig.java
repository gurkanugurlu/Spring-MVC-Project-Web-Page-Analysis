package com.ugurlu.gurkan.config;

import com.ugurlu.gurkan.analysis.Application;
import com.ugurlu.gurkan.analysis.Runner;
import com.ugurlu.gurkan.interceptors.AdminInterceptor;
import com.ugurlu.gurkan.service.MainService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.ugurlu.gurkan"})
    public class WebConfig implements WebMvcConfigurer {
    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setContentType("text/html;charset=UTF-8");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/")
                .setCachePeriod(3600).resourceChain(true).addResolver(new PathResourceResolver());
    }
    // public void addViewControllers(ViewControllerRegistry registry) {
    //     registry.addViewController("/").setViewName("index");
    // }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        return source;
    }

    @Bean
    @Qualifier("threads")
    public List<Runner> runners() {
        List<Runner> runners = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Runner r = new Runner();
            r.setApplication(application());
            r.setMainService(mainService());
            runners.add(r);

        }
        return runners;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns(new String[] { "/admin/adminpanel", "/admin/users","/admin/webpages" });
    }

        @Bean
    @Qualifier("app")
    public Application application() {
        Application application = new Application();
        return application;
    }
    @Bean
    @Qualifier("service")
    public MainService mainService(){
        MainService mainService =new MainService();
        return mainService;
    }
    // public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {   configurer.enable(); }
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
        List<MediaType> mediaTypeList = new ArrayList<>();
        mediaTypeList.add(new MediaType("text", "plain", Charset.forName("UTF-8")));
        mediaTypeList.add(new MediaType("text", "html", Charset.forName("UTF-8")));
        mediaTypeList.add(new MediaType("application", "json", Charset.forName("UTF-8")));
        mediaTypeList.add(new MediaType("text", "javascript", Charset.forName("UTF-8")));
        stringConverter.setSupportedMediaTypes(mediaTypeList);
        converters.add(stringConverter);
    }

}
