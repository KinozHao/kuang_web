package top.session;

/**
 * @author kinoz
 * @Date 2022/7/3 - 19:23
 * @apiNote 测试session的attribute方法可以存放一个类参数
 */
public class JavaBean {
    private String name;
    private int age;

    public JavaBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "JavaBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
