package com.azagade.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee("Aditya Zagade", 25);
        Employee e2 = new Employee("Shyam Pasupula", 28);
        Employee e3 = new Employee("Lalit Joshi", 26);
        Employee e4 = new Employee("Vijay Chavan", 45);
        Employee e5 = new Employee("Mayank Tankiwale", 30);
        Employee e6 = new Employee("Dhananjay Pawar", 35);
        Employee e7 = new Employee("Aishwarya Soma", 24);

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        employees.add(e6);
        employees.add(e7);

//        for (Employee emp : employees) {
//            if (emp.getAge() <= 30) {
//                System.out.println(emp.getAge() + " " + emp.getName());
//            }
//        }
//
//        System.out.println("====================================================================");
//
//        for (Employee emp : employees) {
//            if (emp.getAge() > 30) {
//                System.out.println(emp.getAge() + " " + emp.getName());
//            }
//        }

        //looks hacky
//        printEmployees(employees,true);
//        printEmployees(employees,false);

//        printEmployees(employees, emp -> emp.getAge() > 30);
//        printEmployees(employees, e -> e.getAge() <=30);

//        int age = 15;
//        IntPredicate p1 = a -> {
//            if (a > 10) {
//                System.out.println(a + " is greater than 10");
//                return true;
//            }
//            return false;
//        };
//
//        IntPredicate p2 = a -> {
//            if(a < 100){
//                System.out.println(a + " is less than 100");
//            }
//            return false;
//        };
//
//        p1.and(p2).test(age);


        // get 10 random numbers:
//        Random r = new Random();
//        for (int i = 0; i < 10; i++) {
//            System.out.println(r.nextInt(1000));
//        }

//        Supplier randomSupplier = () -> {
//            return new Random().nextInt(1000);
//        };
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(randomSupplier.get());
//        }

//        IntSupplier randomSupplier = () -> {
//            return new Random().nextInt(1000);
//        };
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(randomSupplier.getAsInt());
//        }

        Function<Employee, String> getFirstName = employee -> {
            return employee.getName().substring(0, employee.getName().indexOf(" ") + 1);
        };
        Function<Employee, String> getLastName = employee -> {
            return employee.getName().substring(employee.getName().indexOf(" ") + 1);
        };

//        System.out.println(getFirstName.apply(employees.get(0)));
//        System.out.println(getLastName.apply(employees.get(0)));

        System.out.println(getAName(getFirstName, employees.get(0)));
        System.out.println(getAName(getLastName, employees.get(0)));
    }

    public static String getAName(Function<Employee, String> f, Employee e) {
        return f.apply(e);
    }

//    public static void printEmployees(List<Employee> employees, boolean greaterThan30) {
//        for (Employee emp : employees) {
//            if (greaterThan30) {
//                if (emp.getAge() > 30) {
//                    System.out.println(emp.getAge() + " " + emp.getName());
//                }
//            } else {
//                if (emp.getAge() <= 30) {
//                    System.out.println(emp.getAge() + " " + emp.getName());
//                }
//            }
//        }
//    }

    public static void printEmployees(List<Employee> employees, Predicate<Employee> p) {
        for (Employee e : employees) {
            if (p.test(e)) {
                System.out.println(e.getAge() + " " + e.getName());
            }
        }
    }
}