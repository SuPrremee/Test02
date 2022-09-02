package com.qiao.ui;

//每个客户的信息被保存Customer对象中
//以一个Customer类型的数组来记录当前所有的客户
//每次"添加客户"(菜单1)后，客户(Customer)对象被添加到数组中
//每次"修改客户"(菜单2)后，修改后的客户(Customer)对象替换数组中原对象
//每次"删除客户"(菜单3)后，客户(customer)对象被从数组中清除
//执行"客户列表"(菜单4)后，将列出数组中所有客户的信息

import com.qiao.bean.Customer;
import com.qiao.service.CustomerList;
import com.qiao.util.CMUtility;

/**
 * @ClassName CustomerView
 * @Description TODO
 * @Author liuyuqiao
 * @Data 2022/9/2 6:38 AM
 * @Version 1.0
 **/
public class CustomerView {
    //属性
    private CustomerList customerList = new CustomerList(10);
    //测试
//    public CustomerView(){
//        Customer customer = new Customer("张三",'男',30,"010-562538256",
//                "abc@email.com");
//        customerList.addCustomer(customer);
//    }

    //打印菜单
    public void enterMainMenu(){
        boolean loopFlog = true;
        do{
            System.out
                    .println("\n------------------客户信息管理系统------------------\n");
            System.out.println("                    1.添加用户");
            System.out.println("                    2.修改用户");
            System.out.println("                    3.删除用户");
            System.out.println("                    4.用户列表");
            System.out.println("                    5.退   出\n");
            System.out.print("                    请选择(1-5):");
            char key = CMUtility.readChar();
            System.out.println();
            switch (key){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.println("确认是否退出(Y/N):");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y'){
                        loopFlog = false;
                    }else {
                        continue;
                    }
            }
        }while(loopFlog);
    }

    public void addNewCustomer(){
        System.out
                .println("\n------------------添加客户------------------\n");
        System.out.println("姓名：");
        String name = CMUtility.readString(10);
        System.out.println("性别：");
        char gender = CMUtility.readChar();
        System.out.println("年龄：");
        int age = CMUtility.readInt();
        System.out.println("电话：");
        String phone = CMUtility.readString(13);
        System.out.println("邮箱：");
        String email = CMUtility.readString(30);

        //将上述数据封装到对象中
        Customer customer = new Customer(name,gender,age,phone,email);
        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess){
            System.out
                    .println("\n------------------添加成功------------------\n");
        }else {
            System.out
                    .println("\n------------------添加失败------------------\n");
        }
    }

    public void modifyCustomer(){
        System.out
                .println("\n-------------------修改用户------------------\n");
        Customer customer;
        int num;
        while (true){
            System.out.print("请选择待修改的客户编号(-1)退出：");
            num = CMUtility.readInt();
            if (num == -1){
                return;
            }
            customer = customerList.getCustomer(num-1);
            if (customer == null){
            }else {
                break;
            }
        }
        //修改用户信息
        System.out.println("姓名(" + customer.getName() + "):");
        String name = CMUtility.readString(10,customer.getName());

        System.out.println("性别(" + customer.getGender() + "):");
        char gender = CMUtility.readChar(customer.getGender());

        System.out.println("年龄(" + customer.getAge() + "):");
        int age = CMUtility.readInt(customer.getAge());

        System.out.println("电话(" + customer.getPhone() + "):");
        String phone = CMUtility.readString(13,customer.getPhone());

        System.out.println("邮箱(" + customer.getEmail() + "):");
        String email = CMUtility.readString(30,customer.getEmail());

        Customer newCustomer = new Customer(name,gender,age,phone,email);

        boolean isReplaced = customerList.replaceCustomer(num - 1,newCustomer);
        if (isReplaced){
            System.out
                    .println("\n-------------------修改完成------------------\n");
        }else {
            System.out
                    .println("\n-------------------修改失败------------------\n");
        }
    }

    public void deleteCustomer(){
        System.out
                .println("\n-------------------删除客户------------------\n");
        int num;
        while (true){
            System.out.println("请选择待删除的客户编号(-1退出)：");
            num = CMUtility.readInt();
            if (num == -1){
                return;
            }
            Customer customer = customerList.getCustomer(num - 1);
            if (customer == null){
                continue;
            }else {
                break;
            }
        }
        System.out.println("是否确认要删除(Y/N)");
        char isDelete = CMUtility.readChar();
        if (isDelete == 'Y'){
            boolean isDeleteSuccess = customerList.deleteCustomer(num - 1);
            if (isDeleteSuccess){
                System.out
                        .println("\n-------------------删除成功------------------\n");
            }else {
                return;
            }
        }
    }

    public void listAllCustomer(){
        System.out
                .println("\n------------------客户列表------------------\n");
        int total = customerList.getTotal();
        if (total == 0){
            System.out.println("没有客户记录");
        }else {
            System.out.println("编号" + "\t\t" + "姓名" + "\t\t\t" + "性别" + "\t\t" + "年龄" + "\t\t" + "电话" + "\t\t\t" + "邮箱");
            Customer[] customers = customerList.getAllCustomers();
            for (int i = 0; i < customers.length; i++) {
                System.out.println((i + 1) + "\t\t" + customers[i].getName() + "\t\t" + customers[i].getGender() + "\t\t" + customers[i].getAge() + "\t\t" + customers[i].getPhone() + "\t\t" + customers[i].getEmail());
            }
            System.out
                    .println("\n------------------客户列表完成------------------\n");
        }
    }

    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }
}
