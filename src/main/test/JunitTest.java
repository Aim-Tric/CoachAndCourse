import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import persistent.mapper.CourseMapper;
import persistent.pojo.Course;
import utils.MybatisUtils;

import java.util.List;

class JunitTest {
    @Test
    void te() {
        long start = System.currentTimeMillis();
        long cnt = 0;
        int max = 100000000;
        for (int i = 0; i < max; i++) {
            cnt += 1;
        }
        long end = System.currentTimeMillis();
        System.out.println(String.format("cnt====%d time===%d",cnt, end-start));
    }

}
