package application.servlet;

import com.sun.istack.internal.NotNull;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import persistent.pojo.User;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@WebServlet("/application/servlet/userUpload")
public class UploadAvatarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        uploadAvatar(req, resp);
    }

    private void uploadAvatar(HttpServletRequest req, HttpServletResponse resp) {
        User user = new User();
        try {
            Map<String, List<FileItem>> map = getUploadMap(req);
            for (String key : map.keySet()) {
                List<FileItem> list = map.get(key);
                for (FileItem item : list) {
                    if ("avatar".equals(key)) {
                        user.setAvatar(item.get());
                    } else {
                        packageParam(user, key, new String(item.get(), StandardCharsets.UTF_8));
                    }
                }
            }
            System.out.println(user);
//          调用service;
            UserServiceImpl service = new UserServiceImpl();
            user = service.updateUserInfo(user);
        } catch (FileUploadException
                | IllegalAccessException
                | InvocationTargetException
                | NoSuchFieldException
                | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    private Map<String, List<FileItem>> getUploadMap(HttpServletRequest req) throws FileUploadException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        return upload.parseParameterMap(new ServletRequestContext(req));
    }

    private void packageParam(@NotNull User user, String name, String data) throws InvocationTargetException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        Class c = user.getClass();
        Method[] methods = c.getMethods();
        Field field = c.getDeclaredField(name);
        String fieldTypeName = field.getType().getSimpleName();
        String userMethod = "set" + name;
        for (Method m : methods) {
            if (m.getName().equalsIgnoreCase(userMethod)) {
                if ("string".equalsIgnoreCase(fieldTypeName)) {
                    m.invoke(user, data);
                } else if ("integer".equalsIgnoreCase(fieldTypeName)) {
                    m.invoke(user, Integer.parseInt(data));
                }
            }
        }
    }

}
