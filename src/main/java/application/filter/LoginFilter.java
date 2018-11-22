package application.filter;

import persistent.pojo.user.User;

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

@WebFilter("*.jsp")
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


//        获取Cookies并查询session中的信息
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("CNC");
        Cookie[] cks = req.getCookies();
        for (Cookie ck : cks) {
            if ("CNCID".equals(ck.getName()) &&
                    ck.getValue().equals(session.getAttribute("CNCID"))) {
                session.setAttribute("INFO", "true");
            }
        }

        String regex = "http:\\/\\/(\\w.*((index)|(login)|(register)).jsp)|(\\w.*\\/)";
        boolean isVaild = Pattern.matches(regex, req.getRequestURL());
        boolean islogged = session.getAttribute("INFO") != null;

        if (!islogged && !isVaild) {
            String ip = req.getRemoteAddr();
            System.out.println(ip + " 试图访问 " + req.getRequestURL() + "，但未登录，页面开始跳转");
            resp.sendRedirect("/index.jsp");
        }

        Map<String, String> map = getCookiesMap(req.getCookies());


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
