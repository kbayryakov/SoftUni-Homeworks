package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {

        Class reflectionClass = Reflection.class;
        System.out.println(reflectionClass);

        Class superClass = reflectionClass.getSuperclass();
        System.out.println(superClass);

        Class[] interfaces = reflectionClass.getInterfaces();

        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Object reflectionObject = reflectionClass.getDeclaredConstructor().newInstance();
        System.out.println(reflectionObject);

        List<Method> getters = new ArrayList<>();
        List<Method> setters = new ArrayList<>();

        Method[] methods = reflectionClass.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                getters.add(method);
            } else if (method.getName().startsWith("set")) {
                setters.add(method);
            }
        }

        getters.forEach(e -> System.out.printf("%s will return class %s%n", e.getName(), e.getReturnType()));
        setters.forEach(e -> System.out.printf("%s and will set field of class %s%n", e.getName(), Arrays.toString(e.getParameterTypes())));

        Field[] fields = reflectionClass.getDeclaredFields();

        Arrays.stream(fields).filter(f -> {int modifier = f.getModifiers();
            String modifierString = Modifier.toString(modifier);
            return !modifierString.contains("private");}).forEach(f -> System.out.printf("%s must be private!%n", f.getName()));

    }
}
