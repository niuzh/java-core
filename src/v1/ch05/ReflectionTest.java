/**
 * 
 */
package v1.ch05;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * @author zhihuan.niu
 * @date 2017-11-22 11:36:00 AM
 * @Description: TODO
 */
public class ReflectionTest {

	/**
	 * @Description: TODO
	 */
	public static void main(String[] args) {
		String name;
		if(args.length>0)name=args[0];
		else {
			Scanner in=new Scanner(System.in);
			System.out.println("entry class name(eg: java.util.Date)");
			name=in.next();
		}
		try {
			Class class1=Class.forName(name);
			Class superCl=class1.getSuperclass();
			String modifiers=Modifier.toString(class1.getModifiers());
			if(modifiers.length()>0)System.out.print(modifiers+"");
			System.out.print("class "+name);
			if(superCl!=null&&superCl!=Object.class)System.out.print( "extends "+superCl.getName());
			
			System.out.print("\n{\n");
			printConstructors(class1);
			System.out.println();
			printMethods(class1);
			System.out.println();
			printFields(class1);
			System.out.println("}");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @Description: TODO
	 */
	private static void printFields(Class class1) {
		Field[] fields=class1.getFields();
		for (Field field : fields){
			Class type=field.getType();
			String name=field.getName();
			System.out.print(" ");
			String modifiers=Modifier.toString(field.getModifiers());
			if(modifiers.length()>0)System.out.print(modifiers+"");
			System.out.println(type.getName()+" "+name);
		}
		
	}

	/**
	 * @Description: TODO
	 */
	private static void printMethods(Class class1) {
		Method[] constructors=class1.getDeclaredMethods();
		for(Method c:constructors){
			String name=c.getName();
			System.out.print(" ");
			String modifiers=Modifier.toString(c.getModifiers());
			if(modifiers.length()>0)System.out.print(modifiers+" ");
			String returnType=c.getReturnType().getName();
			System.out.print(returnType+" ");
			System.out.print(name+"(");
			Class[] paramTypes=c.getParameterTypes();
			for(int j=0;j<paramTypes.length;j++){
				if(j>0)System.out.print(",");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
		
	}

	/**
	 * @Description: TODO
	 */
	private static void printConstructors(Class class1) {
		Constructor[] constructors=class1.getDeclaredConstructors();
		for(Constructor c:constructors){
			String name=c.getName();
			System.out.print(" ");
			String modifiers=Modifier.toString(c.getModifiers());
			if(modifiers.length()>0)System.out.print(modifiers+" ");
			System.out.print(name+"(");
			Class[] paramTypes=c.getParameterTypes();
			for(int j=0;j<paramTypes.length;j++){
				if(j>0)System.out.print(",");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
		
	}

}
