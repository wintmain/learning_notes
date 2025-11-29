/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-24 10:23:05
 */
public class UserImpl implements UserDao{
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public String update(String id) {
        return id;
    }
}
