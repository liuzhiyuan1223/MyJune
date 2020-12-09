package com.june.test_string;

public class stringBuilderDemo {

    public static void main(String[] args) {

        String line = "今天学习Java感觉如何？";
        StringBuilder builder = new StringBuilder(line);

        /*
         *今天学习Java感觉如何？真是神清气爽
         */
        builder.append("真是神清气爽");//增加在原有基础上增加字符
        line = builder.toString();
        System.out.println(line);

        /*
         * 今天学习Java感觉如何？真是神清气爽
         * 今天学习Java感觉如何？呼吸都顺畅了
         */
        builder.replace(13, 19, "呼吸都顺畅了");//替换 真是神清气爽 为 呼吸都顺畅了
        line = builder.toString();
        System.out.println(line);
        /*
         * 今天学习Java感觉如何？呼吸都顺畅了
         * 呼吸都顺畅了
         */
        builder.delete(0, 13);//删除 今天学习Java感觉如何？
        line = builder.toString();
        System.out.println(line);

        /*
         * 呼吸都顺畅了
         * 打开窗户,
         */
        builder.insert(0, "打开窗户,");//在某个位子插入
        line = builder.toString();
        System.out.println(line);
    }

}
