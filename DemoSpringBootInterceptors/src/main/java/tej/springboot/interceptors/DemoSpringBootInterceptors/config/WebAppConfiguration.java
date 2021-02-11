package tej.springboot.interceptors.DemoSpringBootInterceptors.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tej.springboot.interceptors.DemoSpringBootInterceptors.interceptor.BookHandlerInterceptor;

@Component
public class WebAppConfiguration implements WebMvcConfigurer {

    @Autowired
    private BookHandlerInterceptor bookHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bookHandlerInterceptor);
    }
}
