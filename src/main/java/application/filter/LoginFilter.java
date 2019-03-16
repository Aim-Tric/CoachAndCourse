package application.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * 对一些访问进行限制，并完成简单的免登录验证
 */

@WebFilter("*.jsp")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

//        获取Cookies并查询session中的信息
        HttpSession session = req.getSession();
        Cookie[] cks = req.getCookies();
        session.setAttribute("INFO", "false");
        if (cks != null) {
            for (Cookie ck : cks) {
                if ("CNCID".equals(ck.getName()) &&
                        ck.getValue().equals(session.getAttribute("CNCID"))) {
                    session.setAttribute("INFO", "true");
                    break;
                }
            }
        }

//        权限校验： (1)已登录：学生权限（查看课程、获取已参加课程资料和教学视屏、加入/购买课程、个人空间）
//                          教师权限 （管理课程、所管理课程内的学生管理、个人空间）
//                          管理员权限（管理课程、用户管理、空间管理、评论管理）
//                  （2）未登录：最低权限，仅可浏览课程及评论
//        权限拦截并校验

//        String regex = "http:\\/\\/(\\w.*((index)|(login)|(register)).jsp)|(\\w.*\\/)";
          String regex = "http:\\/\\/(\\w.*(dashboard).jsp)";
//
        boolean unValid = Pattern.matches(regex, req.getRequestURL());
        boolean unLogged = session.getAttribute("INFO").equals("false");
        if (unLogged && unValid) {
            String ip = req.getRemoteAddr();
            System.out.println(ip + " 试图访问 " + req.getRequestURL() + "，但未登录，页面开始跳转");
            resp.sendRedirect("/admin/login.jsp");
            return;
        }

        filterChain.doFilter(req, resp);

    }

    @Override
    public void destroy() {

    }
}
