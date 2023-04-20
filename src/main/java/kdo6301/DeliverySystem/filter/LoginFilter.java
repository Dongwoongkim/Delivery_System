package kdo6301.DeliverySystem.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.PatternMatchUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class LoginFilter implements Filter {
    private static final String[] whiteList = {"/","/members/add","/members/login","members/logout","/css/*"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String requestURI = httpRequest.getRequestURI();

        try
        {
            if(isLoginCheckPath(requestURI))
            {
                HttpSession session = httpRequest.getSession(false);

                if(session == null || session.getAttribute("loginMember")==null)
                {
                    httpResponse.sendRedirect("/members/login?redirectURL="+requestURI);
                    return;
                }
            }
            chain.doFilter(request, response);
        } catch (IOException e) {
            throw e;
        }finally {
        }
    }

    private boolean isLoginCheckPath(String requestURI) {
        return !PatternMatchUtils.simpleMatch(whiteList, requestURI);
    }
}
