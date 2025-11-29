import com.wintmain.mybatis.mapper.ParameterMapper;
import com.wintmain.mybatis.pojo.User;
import com.wintmain.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-29 16:06:52
 */
public class ParameterMapperTest {

//    @Test
//    public void testJDBC() throws ClassNotFoundException, SQLException {
//        String username = "admin";
//        Class.forName("");
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis","root","123456*");
//        PreparedStatement ps = connection.prepareStatement("selelt * from t_user where username = ?");
//        ps.setString(1,username);
//    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);
    }

    @Test
    public void testGetUserByName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUsername("lisi");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("admin","12345");
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","admin");
        map.put("password","12345");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int i = mapper.insertUser(new User(null, "李四", "123", 23, "男", "123@qq.com"));
        System.out.println(i);
    }

    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("admin","12345");
        System.out.println(user);
    }

}
