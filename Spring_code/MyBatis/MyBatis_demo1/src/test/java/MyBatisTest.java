import com.wintmain.mybatis.mapper.UserMapper;
import com.wintmain.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-27 13:04:05
 */
public class MyBatisTest {
    /**
     * SqlSession默认不自动提交事务，若需要自动提交事务
     * 可以使用SqlSessionFactory.openSession(true);
     */

    @Test
    public void testAdd() throws IOException{
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取SqlSession
        //参数true表示自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //测试功能
        int result = mapper.insertUser();
        //提交事务
        //sqlSession.commit();
        System.out.println("result:"+result);
    }

    @Test
    public void testUD() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

//        mapper.updateUser();
        mapper.deleteUser();
    }

    @Test
    public void testCheck() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        User user = mapper.getUserById();
//        System.out.println(user);

        List<User> userList = mapper.getAllUser();
        userList.forEach(user -> System.out.println(user));
    }
}
