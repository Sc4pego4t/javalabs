import java.lang.reflect.Method;

class SomeClass {

    @InvocationCount(count = 2)
    private void func1() {
        System.out.println("IN FUNC1");
    }

    @InvocationCount(count = 9)
    private void func2() {
        System.out.println("IN FUNC2");
    }

    private void func3() {
        System.out.println("IN FUNC3");
    }

    private void func4() {
        System.out.println("IN FUNC4");
    }
}

public class lab8 {
    
    public static void main(String[] args) {
        try {
            SomeClass exampleClass = new SomeClass();
            Class<?> reflecedClass = exampleClass.getClass();
            for (Method method: reflecedClass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(InvocationCount.class)) {
                    method.setAccessible(true);
                    for(int i=0; i < method.getAnnotation(InvocationCount.class).count(); i++) {
                        method.invoke(exampleClass);
                    }
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
