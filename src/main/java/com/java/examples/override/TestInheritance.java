package com.java.examples.override;

public class TestInheritance {

    public static void main(String[] args) {
        Child obj = new Child();
        obj.setI(1);
        obj.j = 2;
        obj.display();
        obj.anotherDisplay();

        Parent objp = new Child();
        objp.setI(12);
        //objp.j = 2;
        objp.display();
        //objp.anotherDisplay();
    }
}

class Parent {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    void display() {
        System.out.println("Parent: i= " + i);
    }
}

class Child extends Parent {
    int j;

    void display() {
        System.out.println("Child: i= " + getI());
    }

    void anotherDisplay() {
        System.out.println("Child: j= " + j);
    }
}
