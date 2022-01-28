package SourceFileStructure;

class MultipleMainClasses1 {
    public static void main(String[] args) {

    }
}

class MultipleMainClasses2 {
    public static void main(String[] args) {

    }
}

class MultipleMainClasses3 {
    public static void main(String[] args) {

    }
}

class MultipleMainClasses4 {
}

/*
* When we compile this Durga.java, 4 .class files will be generated.
* MultipleMainClasses1.class
* MultipleMainClasses2.class
* MultipleMainClasses3.class
* MultipleMainClasses4.class
*
* No Durga.java
*
* To run:
* java MultipleMainClasses1   -> immediately runs main method of MultipleMainClasses1
* java MultipleMainClasses2   -> immediately runs main method of MultipleMainClasses2
* java MultipleMainClasses3   -> immediately runs main method of MultipleMainClasses3
* java MultipleMainClasses4   -> immediately throws exception and tells us to define main method.
* */