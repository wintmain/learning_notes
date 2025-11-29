import com.wintmain.mybatis.mapper.CacheMapper;
import com.wintmain.mybatis.pojo.Emp;
import com.wintmain.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-04-04 9:23:28
 */
public class CacheMapperTest {
    @Test
    public void testOneCache(){
        SqlSession sqlSession1 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpByEid(2);
        System.out.println(emp1);
//        mapper1.insertEmp(new Emp(null,"abc",23,"男","123@qq.com",null));
        sqlSession1.clearCache(); //手动
        Emp emp2 = mapper1.getEmpByEid(2);
        System.out.println(emp2);
        /*//不同的SqlSession
        SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpByEid(1);
        System.out.println(emp2);
        */
    }

    @Test
    public void testTwoCache() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        System.out.println(mapper1.getEmpByEid(2));
        sqlSession1.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        System.out.println(mapper2.getEmpByEid(2));
        sqlSession2.close();

    }
}
