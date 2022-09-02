package com.qiao.bean;

import com.qiao.util.CMUtility;

/**
 * @ClassName Customer
 * @Description TODO
 * @Author liuyuqiao
 * @Data 2022/9/2 4:31 AM
 * @Version 1.0
 **/
public class Customer {
    //属性
    private String name;    //客户姓名
    private char gender;    //性别
    private int age;    //年龄
    private String phone;   //电话
    private String email;   //邮箱

    //构造器
    public Customer(){

    }

    public Customer(String name, char gender, int age, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    //访问器

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public static void main(String[] args) {
//        CMUtility test = new CMUtility();
//        Customer customer = new Customer("张三",'男',30,"123456789","123456789@qq.com");
//        System.out.println(customer.name + customer.gender + customer.age + customer.phone + customer.email);
//    }
}
