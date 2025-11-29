import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-24 10:23:55
 */
public class JDKproxy {
    public static void main(String[] args) {
        //创建接口实现类代理对象
        Class[] interfaces = {UserDao.class};
        UserImpl userDao = new UserImpl();
        UserDao dao = (UserDao)Proxy.newProxyInstance(JDKproxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int res = dao.add(1,3);
        System.out.println("result:"+res);

//        Proxy.newProxyInstance(JDKproxy.class.getClassLoader(), interfaces, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });


    }

    //创建代理对象代码
    static class UserDaoProxy implements InvocationHandler{
        //1 把创建的是谁的代理对象，把谁传递过来
        //有参数构造传递
        private Object obj;
        public UserDaoProxy(Object obj){
            this.obj = obj;
        }
        // 2 写增强的逻辑
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //方法之前
            System.out.println("方法之前执行...."+method.getName()+" :传递的参数..."+ Arrays.toString(args));
            //被增强的方法执行
            Object res = method.invoke(obj,args);

            //方法之后
            System.out.println("方法之后执行...."+obj);

            return res;
        }
    }
}
