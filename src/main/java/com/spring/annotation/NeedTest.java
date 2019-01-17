package com.spring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解， 采用 @interface 
 * 一个注解可以拥有多个成员，成员声明与接口方法声明类似，
 * 成员声明的限制:
 * 1.成员以无入参,无抛出异常的方式，如；boolean value(String str)throws exception为非法
 * 2.可以通过default为成员指定一个默认值，如 String value(String str) default 'abc'
 * 3.成员类型是受限制的，合法类型包括原始类型以及封装类，String,Class,enums,而List为非法的。
 * 4.如果注解只有一个成员，则成员名必须去买为value(),在使用时可以忽略成员名和赋值符号，
 * 如:NeedTest(true),如果注解有多个成员时，如果仅对value成员进行赋值，则也可不使用赋值号，如果同时
 * 对多个成员赋值，则必须用赋值符号，如：DeclareParents(value='abc',default='22')
 * @author jwh
 *
 */
//声明注解的 保留期,为运行时
//1.RUNTIME:注解信息在目标类加载到jvm后依然保留，在运行期可以通过反射机制读取类中的注解信息。
//2.class:注解信息将进入目标类代码的字节码中， 当类加载器加载字节码文件时不会将注解加载到jvm中，即运行期不能获取注解信息
//3.source:注解信息保留在目标类代码文件中，但对应的字节码文件将不再保留

//@target 声明可以使用该注解的目标类型
// 1.METHOD 方法声明处，
// 2.type 类，接口，注解类，enum声明处， 称为类型注解
//....
@Retention(RetentionPolicy.RUNTIME) //java 元注解 meta-annotation 他们会被java编译器使用，
@Target(ElementType.METHOD) //java 元注解 meta-annotation 他们会被java编译器使用，表示
//NeedTest这个注解可以在运行期被jvm读取，
public @interface NeedTest {  //定义注解

	boolean value() default true; //声明注解成员
}
