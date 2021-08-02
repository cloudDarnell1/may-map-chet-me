package thaovan.lab8.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import thaovan.lab8.service.CategoriesService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@Component
public class GlobalInterceptor implements HandlerInterceptor {

    private CategoriesService categoriesService;

    public GlobalInterceptor(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.setAttribute("categories", this.categoriesService.findAll());
        return true;
    }


}
