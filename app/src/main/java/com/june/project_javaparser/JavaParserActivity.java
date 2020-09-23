package com.june.project_javaparser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.comments.CommentsCollection;
import com.june.R;
import com.june.project_javaparser.tomassetti.examples.CodeGenerationExample;

import java.lang.reflect.Method;
import java.util.Optional;

public class JavaParserActivity extends AppCompatActivity {

    private static final String TAG = "july";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_parser);

//        testCode();

        CodeGenerationExample.printJavaCodes();
    }

//    private void testCode() {
//        String javaC = "class Test{" +
//                "void myTest1(){}" +
//                "void myTest2(){}" +
//                "}";
//        JavaParser javaParser = new JavaParser();
//
//        ParseResult<CompilationUnit> parseResult = javaParser.parse(javaC);
////        Optional<CompilationUnit> result1 = parseResult.getResult();
//        Optional<CommentsCollection> result = parseResult.getCommentsCollection();
//        Class<? extends Optional> aClass = result.getClass();
//
//        Method[] methods = aClass.getMethods();
//        for (Method mth : methods){
//            Log.d(TAG, "testCode: " + mth);
//        }
//    }
}