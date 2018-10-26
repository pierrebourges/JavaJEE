package ynov.m1.bourges_pierre.projetbanque.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class ConnectionFilter implements Filter {

    public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String loginURI = req.getContextPath() + "/login";
        String restURI = req.getContextPath() + "/rest";
        String restPost = req.getContextPath() + "/resttransaction";

        boolean loggedIn = session != null && session.getAttribute("utilisateur") != null;
        boolean loginRequest = req.getRequestURI().equals(loginURI);
        boolean restfilter = req.getRequestURI().equals(restURI);
        boolean restPostfilter = req.getRequestURI().equals(restPost);

        if (loggedIn || loginRequest || restfilter || restPostfilter) {
            chain.doFilter(request, response);
        } else {
            resp.sendRedirect(loginURI);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
    }

    @Override
    public void destroy(){

    }

}
