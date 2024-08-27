package com.david.curso.springboot.app.interceptor.springboot_interceptor.interceptors;

import java.util.Random;
import java.util.Map;
import java.util.Date;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("TimeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HandlerMethod controller = ((HandlerMethod) handler);
        logger.info("LoadingTimeInterceptor: preHandle() entrando...." + controller.getMethod().getName());

        long start = System.currentTimeMillis();
        request.setAttribute("start", start);

        Random random = new Random();
        int delay = random.nextInt(500);
        Thread.sleep(delay);

        /*
         * Para personalizar respuestas al retornar false en el interceptor
         * Map<String, String> json = new HashMap<>();
         * json.put("error", "no tienes acceso a este recurso");
         * json.put("date", new Date().toString());
         * 
         * ObjectMapper mapper = new ObjectMapper();
         * String jsonString = mapper.writeValueAsString(json);
         * response.setContentType("application/json");
         * response.setStatus(401);
         * response.getWriter().write(jsonString);
         * return false;
         */

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

        long end = System.currentTimeMillis();
        long start = (long) request.getAttribute("start");
        long result = end - start;
        logger.info("Tiempo transcurrido " + result + " milisegundos");
        logger.info(
                "LoadingTimeInterceptor: prostHandle() saliendo...." + ((HandlerMethod) handler).getMethod().getName());

    }

}