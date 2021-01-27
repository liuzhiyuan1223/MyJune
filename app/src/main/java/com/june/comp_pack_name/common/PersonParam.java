package com.june.comp_pack_name.common;

public class PersonParam {

    public String name;
    public int age;

    public static class Builder{

        public String name = "default";
        public int age = -1;

        public Builder(){

        }

        public Builder buildName(String name){
            this.name = name;
            return this;
        }

        public Builder buildAge(int age){
            this.age = age;
            return this;
        }

        public PersonParam build(){

            PersonParam personParam = new PersonParam();

            personParam.name = this.name;
            personParam.age = this.age;

            return personParam;
        }
    }
}
