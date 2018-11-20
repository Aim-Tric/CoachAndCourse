package application.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    private Map<String, String> getCookiesMap(Cookie[] cks) {
        Map<String, String> map = new HashMap<>();
        for (Cookie c : cks) {
            map.put(c.getName(), c.getValue());
        }
        return map;
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String regex = "(index|register)+.jsp/g";
        boolean isVaild = !Pattern.matches(regex, req.getRequestURL());
        if(!isVaild){
            return;
        }
        HttpSession session = req.getSession();
        Map<String, String> map = getCookiesMap(req.getCookies());

        String v = map.get("CNCSID");
//        boolean isLogged = v.equals(session.getAttribute("CNCSID"));

        // TODO: 写正则表达式来过滤掉


//        // 在不是主页或登录页里没登录则跳转到主页
//        if (isVaild && !isLogged) {
//            resp.sendRedirect("/index.jsp");
//            return;
//        }


        filterChain.doFilter(req, resp);

    }

    @Override
    public void destroy() {

    }
}
