package com.nz.springbootlearning.reflection;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class pigConstructorTest {

    public static  String pigConstructorTest1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Pig> pigClass = Pig.class;
        System.out.println(pigClass.getName());
        Constructor<Pig> pigConstructor = pigClass.getDeclaredConstructor();
        pigConstructor.setAccessible(true);
        Pig pig = pigConstructor.newInstance();
        pig.setPigAge("11");
        pig.setPigName("peiqi");
        pig.setWeight("100kg");
        return pig.getPigAge()+" "+pig.getPigName() + " "+pig.getWeight();
    }

    public static void pigFiledTest(Class<Pig> pigClass) throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Field[] field = pigClass.getFields();
        Field[] pigFileds = pigClass.getDeclaredFields();
        Field weight = pigClass.getDeclaredField("weight");
        weight.setAccessible(true);
        for (Field f : pigFileds){
            System.out.println(f.getType()+"----"+f.getName());
        }
        Pig pig = pigClass.newInstance();
        System.out.println(weight.get(pig));
        weight.set(pig,"333");
        System.out.println(weight.get(pig));
    }

    public static void pigMethod(Class<Pig> pigClass) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        final Method setPigAge = pigClass.getDeclaredMethod("setPigAge", String.class);
        Pig pig = pigClass.newInstance();
        System.out.println("before method invoke:" + pig.getPigAge());
            setPigAge.invoke(pig,"100");
            System.out.println("after method invoke" + pig.getPigAge());
        }

        public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException {
            String pigPeiqi = pigConstructorTest1();
            System.out.println(pigPeiqi);
            Class<Pig> pigClass = (Class<Pig>) Class.forName("com.nz.springbootlearning.reflection.Pig");
            try {
                pigFiledTest(pigClass);
            } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        pigMethod(pigClass);
        PrintSetterAndGetter(pigClass);
    }
    private static  void PrintSetterAndGetter(Class classname){
        Method[] method = classname.getMethods();
        for (Method method1: method) {
            if (isGetter(method1))    System.out.println(method1.getName());
            if (isSetter(method1))    System.out.println(method1.getName());
        }
    }
    private static boolean  isGetter(Method method){
        if (!method.getName().startsWith("get")) {
            return false;
        }
        if(method.getParameterTypes().length != 0){
            return false;
        }
        if(void.class.equals(method.getReturnType())){
            return false;
        }
        return true;
    }

    private  static  boolean isSetter(Method method){
        if (!method.getName().startsWith("set")){
            return false;
        }
        if(method.getParameterTypes().length != 1){
            return false;
        }

        return true;
    }


}
