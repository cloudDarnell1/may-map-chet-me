package thaovan.lab8.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import thaovan.lab8.interceptor.GlobalInterceptor;
import thaovan.lab8.service.CategoriesService;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private GlobalInterceptor globalInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.globalInterceptor)
                .excludePathPatterns("/assets**", "/rest**", "/admin**");
    }
}
