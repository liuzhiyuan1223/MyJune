package com.june.project_javaparser.tomassetti.examples;

import android.util.Log;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;

public class CodeGenerationExample {

    private static final String TAG = "july";

    public static void printJavaCodes() {

        CompilationUnit compilationUnit = new CompilationUnit();
        compilationUnit.setPackageDeclaration("my.example.javaparser");

        // Add an asterisk import for java.util //为java.util添加星号导入
        compilationUnit.addImport("java.util", false, true);

        // Create a class (not an interface, so the 2nd parameter is false) //创建一个类（不是接口，因此第二个参数为false）
        ClassOrInterfaceDeclaration myClass = compilationUnit.addClass("MyClass", Modifier.Keyword.PUBLIC);
        myClass.addField("List<String>", "elements", Modifier.Keyword.PRIVATE);

        // Method to add an element to the field  //将元素添加到字段的方法
        MethodDeclaration addElement = myClass.addMethod("addElement", Modifier.Keyword.PUBLIC);

        // our method get a parameter: the value to add to the field //我们的方法获取一个参数：要添加到字段中的值
        addElement.addParameter("String", "newElement");

        // the body consists in one expression wrapped into a statement //主体包含一个包装在语句中的表达式
        // the expression is in invocation of elements.add to which we //表达式是对我们要添加到的elements.add的调用
        // pass the parameter //传递参数
        addElement.getBody().get().getStatements().add(new ExpressionStmt(
                new MethodCallExpr(new NameExpr("elements"), new SimpleName("add"),
                        NodeList.nodeList(new NameExpr("newElement")))
        ));

        // Method to get elements //获取元素的方法
        MethodDeclaration getElements = myClass.addMethod("getElements", Modifier.Keyword.PUBLIC);
        // we specify that we are returning a Collection of String  //我们指定要返回的是String的集合
        getElements.setType("Collection<String>");
        // The body consists of just a return statement. We return the //主体仅由return语句组成。我们返回
        // field //栏位
        getElements.getBody().get().getStatements().add(new ReturnStmt(
                new NameExpr("elements")));

//        System.out.println(compilationUnit);
        Log.d(TAG, "compilationUnit: " + compilationUnit);
    }
}
