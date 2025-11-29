import com.wintmain.mybatis.mapper.DynamicSQLMapper;
import com.wintmain.mybatis.pojo.Emp;
import com.wintmain.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-04-03 14:59:13
 */
public class DynamicSQLMapperTest {
    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByCondition(new Emp(null, "", null, "", null,null));
        System.out.println(list);
    }

    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByChoose(new Emp(null, "", null, "", "",null));
        System.out.println(list);
    }

    @Test
    public void testDeleteMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int res = mapper.deleteMoreByArray(new Integer[]{6,7,8});
        System.out.println(res);
    }

    @Test
    public void testInsertMoreByList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"a1",23,"男","123@qq.com",null);
        Emp emp2 = new Emp(null,"a2",23,"男","123@qq.com",null);
        Emp emp3 = new Emp(null,"a3",23,"男","123@qq.com",null);
        List<Emp> list = Arrays.asList(emp1,emp2,emp3);
        System.out.println(mapper.insertMoreByList(list));
    }
}
