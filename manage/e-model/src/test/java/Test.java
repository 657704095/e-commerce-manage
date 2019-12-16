import java.lang.reflect.Field;

public class Test {

    public static void main(String[] args){
        Student stu = new Student();

        Class stuClass = Student.class;
        Field field = null;
        Object obj = null;
        String name = "";
        try {
            field = stuClass.getDeclaredField("name");
            field.setAccessible(true);
            obj = field.get(stu);
            name = (String)obj;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(name);
    }
}

class Student{

    private String name = "张三";
}
