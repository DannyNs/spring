package com.dannyns.shop.interceptors;

import com.dannyns.shop.annotations.ThymeleafLayout;

import javaslang.Tuple;
import javaslang.Tuple2;
import javaslang.collection.Stream;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Objects;

public class ThymeleafLayoutInterceptor extends HandlerInterceptorAdapter {

    private static final String DEFAULT_LAYOUT = "default";
    private static final String DEFAULT_VIEW_ATTRIBUTE_NAME = "view";

    private static final String DEFAULT_VIEWS_DIR = "views";
    private static final String DEFAULT_LAYOUTS_DIR = "layouts";

    private static final String CONTROLLER_SUFFIX = "Controller";

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView == null || !modelAndView.hasView()) return;

        String originalViewName = modelAndView.getViewName();

        if (isRedirectOrForward(originalViewName)) return;

        Tuple2<String, String> layoutAndView = getLayoutAndView(handler);

        modelAndView.setViewName(layoutAndView._1());
        modelAndView.addObject(DEFAULT_VIEW_ATTRIBUTE_NAME, createPath(layoutAndView._2(), originalViewName));
    }

    private boolean isRedirectOrForward(String viewName) {
        return viewName.startsWith("redirect:") || viewName.startsWith("forward:");
    }

    private Tuple2<String, String> getLayoutAndView(Object handler) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Class<?> beanType = handlerMethod.getBeanType();

        String layoutName = getLayoutName(
                handlerMethod.getMethodAnnotation(ThymeleafLayout.class),
                beanType.getAnnotation(ThymeleafLayout.class)
        );

        String viewName = getViewName(beanType.getSimpleName());

        return Tuple.of(
                createPath(DEFAULT_LAYOUTS_DIR, layoutName),
                createPath(DEFAULT_VIEWS_DIR, viewName)
        );
    }

    private String getLayoutName(ThymeleafLayout methodAnnotation, ThymeleafLayout classAnnotation) {
        return Stream.of(methodAnnotation, classAnnotation)
                .filter(Objects::nonNull)
                .map(ThymeleafLayout::value)
                .getOrElse(DEFAULT_LAYOUT);
    }

    private String getViewName(String simpleName) {
        return simpleName
                .replace(CONTROLLER_SUFFIX, "")
                .toLowerCase();
    }

    private String createPath(String left, String right) {
        return new StringBuilder(left)
                .append("/")
                .append(right)
                .toString();
    }
}
