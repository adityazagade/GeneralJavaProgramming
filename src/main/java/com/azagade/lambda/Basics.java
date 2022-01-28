package com.azagade.lambda;

import java.util.ArrayList;
import java.util.List;

public class Basics {

    public static void main(String args[]){
        new Thread(() -> {
            System.out.println("Line 1");
        }).start();

        List<Employee> employees = new ArrayList<>();

        Employee aditya = new Employee("Aditya",23);
        Employee shyam = new Employee("Shyam",23);
        Employee lalit = new Employee("Lalit",23);

        employees.add(aditya);
        employees.add(shyam);
        employees.add(lalit);

//        for(Employee e : employees){
//            System.out.println(e.getName());
//        }

//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

//        Collections.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));
//        Collections.reverse(employees);
//
//        for(Employee e : employees){
//            System.out.println(e.getName());
//        }

//        UpperConcat uc = new UpperConcat() {
//            @Override
//            public String upperConcat(String s1, String s2) {
//                return s1.toUpperCase() + " " + s2.toUpperCase();
//            }
//        };

//        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + " " + s2.toUpperCase();
//        String ucStr = doUpperConcat(uc,employees.get((0)).getName(), employees.get(1).getName());
//        System.out.println(ucStr);

//        AnotherClass ac = new AnotherClass();
//        System.out.println(ac.toUppeConacat("String 1", "String 2"));

        employees.forEach(employee -> {
            System.out.println(employee.getName() + " " + employee.getAge());
        });
    }

//    public static String doUpperConcat(UpperConcat uc, String s1, String s2){
//        return uc.upperConcat(s1,s2);
//    }
//
    static interface UpperConcat {
        public String upperConcat(String s1, String s2);
    }

    static class Employee {
        private String name;
        private int age;

        public Employee(String name, int age) {
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
    }

    static class AnotherClass {
        public String toUppeConacat(String s1, String s2){
            System.out.println("The classname is " + getClass().getSimpleName());
//            UpperConcat uc = new UpperConcat() {
//                @Override
//                public String upperConcat(String s1, String s2) {
//                    System.out.println("The classname is " + getClass().getSimpleName());
//                    return s1.toUpperCase() + " " + s2.toUpperCase();
//                }

//            UpperConcat uc = (s3,s4) -> {
//                System.out.println("The classname is " + getClass().getSimpleName());
//                return s3.toUpperCase() + " " + s4.toUpperCase();
//            };
            {
                UpperConcat uc = new UpperConcat() {
                    @Override
                    public String upperConcat(String s1, String s2) {
                        return s1.toUpperCase() + " " + s2.toUpperCase();
                    }

                };
                System.out.println("The classname is " + getClass().getSimpleName());
                String result = uc.upperConcat(s1,s2);
                return result;
            }
        }
    }
}
