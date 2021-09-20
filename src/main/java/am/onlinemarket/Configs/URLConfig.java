package am.onlinemarket.Configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class URLConfig implements WebMvcConfigurer {
    @Value("${static.img.path}")
    private String imagePath;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login").setViewName("redirect:/login");
//        registry.addViewController("/reg").setViewName("registracia");
//        registry.addViewController("/").setViewName("redirect:/index");
//        registry.addViewController("/index").setViewName("redirect:/index");
//        registry.addViewController("/index").setViewName("redirect:/index");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:/" + imagePath + "/");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
