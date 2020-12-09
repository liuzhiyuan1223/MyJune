//package com.june.generics_kotlin;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PersonTestCl {
//
//    private Number number;
//    private Integer in;
//
//    List<Number> list1 = new ArrayList<>();
//    List<Integer> list2 = new ArrayList<>();
//
//    private void runTest(){
////        list1.addAll(); //boolean addAll(Collection<? extends E> c);
////        list2.addAll(5); //boolean addAll(Collection<? extends E> c);
//
//        //1.
//        List<String> strs = new ArrayList<String>();
//        List<Object> objs = strs; // ！！！即将来临的问题的原因就在这里。Java 禁止这样！
//        objs.add(1); // 这里我们把一个整数放入一个字符串列表
//        String s = strs.get(0); // ！！！ ClassCastException：无法将整数转换为字符串
//
//        //2.
//        List<? extends Fruit> fruits = new ArrayList<Orange>();
//        //编译错误:不能添加任何类型的对象
//        fruits.add(new Orange());
//        fruits.add(new Fruit());
//        fruits.add(new Object());
//
//        //以下可以通过编译
//        fruits.contains(new Orange());
//
//        fruits.add(null);//可以这么做，但是没有意义
//        //我们知道，返回值肯定是Fruit
//        Fruit f = fruits.get(0);
//    }
//
//    // 元素类型可以有三种型变：协变、逆变、不变
//    // 型变是指我们是否允许对参数类型进行子类型转换
//    // * Java中的泛型是不型变的 -> 可以保证类型安全作出的设计
//
//
//
//    private void test2(){
//
//        List<Object> objs = new ArrayList<Object>();
//        objs.add(new Object());
//
//        List<? super Fruit> canContainFruits = objs;
//        //没有问题，可以写入Fruit类及其子类
//        canContainFruits.add(new Orange());
//        canContainFruits.add(new Banana());
//        canContainFruits.add(new Fruit());
//
//        //无法安全地读取,canContainFruits完全可能包含Fruit基类的对象，比如这里的Object
//        //Fruit f = canContainFruits.get(0);
//
//        //总是可以读取为Object，然而这并没有太多意义
//        Object o = canContainFruits.get(1);
//    }
//
//
//    class Fruit{
//    }
//    class Orange extends Fruit{
//    }
//
//
//
//    /**
//     * @param <T>
//     */
//    interface Source<T> {
//        T nextT();
//    }
//
//    // Java
//    void demo(Source<Orange> oranges) {
//        Source<Fruit> fruits = oranges; // ！！！在 Java 中不允许
//
//        Source<Fruit> fruits = new Source<Orange>(); // ！！！在 Java 中不允许
//    }
//}
