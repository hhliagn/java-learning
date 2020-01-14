package com.javalearning.demo.test.generics;

class ClassAsFactory<T> {
    T x;
    public ClassAsFactory(Class<T> kind){
        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
class Employee{

}
public class InitantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> employeeClassAsFactory = new ClassAsFactory<>(Employee.class);
        System.out.println("employeeClassAsFactory success");
        try {
            ClassAsFactory<Integer> integerClassAsFactory = new ClassAsFactory<>(Integer.class);
        }catch (Exception e){
            System.out.println("integerClassAsFactory fail"); //Integer没有默认构造器
        }
    }
}
