package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/*")
public class LocaleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    	
    	HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        
        Locale locale = (Locale) session.getAttribute("userLocale");
        
        if (locale == null) {
            String localeParam = request.getParameter("lang");
            if (localeParam != null && !localeParam.isEmpty()) {
                String[] parts = localeParam.split("_");
                if (parts.length == 2) {
                    locale = new Locale(parts[0], parts[1]);
                } else {
                    locale = new Locale(localeParam);
                }
            } else {
                locale = request.getLocale();
            }
            session.setAttribute("userLocale", locale);
        }
        
        chain.doFilter(request, response);
    }

}
