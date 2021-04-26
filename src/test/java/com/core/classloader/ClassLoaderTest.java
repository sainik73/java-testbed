package com.core.classloader;

public class ClassLoaderTest {

    public static void main(String[] args) {

        System.out.println("class loader for bootstrap classes/HashMap: "
                + java.util.HashMap.class.getClassLoader());
        System.out.println("class loader for ZipInfo: " + com.sun.nio.zipfs.ZipInfo.class.getClassLoader());
        System.out.println("class loader for this class: "
                + ClassLoaderTest.class.getClassLoader());

    }

}
