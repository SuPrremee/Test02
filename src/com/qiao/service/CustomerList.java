package com.qiao.service;

import com.qiao.bean.Customer;
import com.qiao.util.CMUtility;

/**
 * @ClassName CustomerList
 * @Description TODO
 * @Author liuyuqiao
 * @Data 2022/9/2 4:40 AM
 * @Version 1.0
 **/
public class CustomerList {
    //属性
    private Customer[] customers;   //用户对象数组
    private int total = 0;

    //构造器
    public CustomerList(){

    }

    public CustomerList(int totalCustomer) {
        //构造器动态初始化
        customers = new Customer[totalCustomer];
    }

    /**
     *
     * @Description //TODO
     * 将参数customer添加组中最后一个客户对象记录之后
     * @Author liuyuqiao
     * @Date 2022/9/2 4:50 AM
     * @Param [customer]
     * customer指定要添加的客户对象
     * @return boolean
     * 添加成功返回true；false表示数组已满，无法添加
     * @Version v1.0
     **/

    public boolean addCustomer(Customer customer){
        if (total >= customers.length){
            System.out.println("添加用户失败");
            return false;
        }else {
            customers[total++] = customer;
            System.out.println("添加用户成功");
            return true;
        }
    }

    public boolean replaceCustomer(int index,Customer customer){
        if (index >= total || index < 0){
            System.out.println("修改失败，用户不存在");
            return false;
        }else {
            customers[index] = customer;
            System.out.println("用户信息修改成功");
            return true;
        }
    }

    public boolean deleteCustomer(int index){
        if (index < 0 || index >= total){
            System.out.println("删除用户失败");
            return false;
        }else {
            for (int i = index; i < total-1; i++) {
                customers[i] = customers[i+1];
            }
            customers[total-1] = null;
            total--;
            System.out.println("删除用户成功");
        }
        return true;
    }

    public Customer[] getAllCustomers(){
        Customer[] customers = new Customer[total];
        for (int i = 0; i < total; i++) {
            customers[i] = this.customers[i];
        }
        return customers;
    }

    public Customer getCustomer(int index){
        if (index < 0 || index >= total){
            System.out.println("索引失败");
            return null;
        }else return customers[index];
    }

    public int getTotal(){
        return total;
    }
}
