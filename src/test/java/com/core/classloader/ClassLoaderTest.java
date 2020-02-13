package com.core.classloader;

public class ClassLoaderTest {

	public static void main(String[] args) {

		/*
		* Bootstrap Classloader for java.lang classes is written
		* in native language. So getClassLoader() will return Null
		*/
		System.out.println("class loader for HashMap: "
				+ java.util.HashMap.class.getClassLoader());
		/* Extensions classloader */
		System.out.println("class loader for ZipInfo: " + com.sun.nio.zipfs.ZipInfo.class.getClassLoader());
		/* Application class loader */
		System.out.println("class loader for this class: "
				+ ClassLoaderTest.class.getClassLoader());

	}

}
