package com.version;

public class Reservation {
    //数据主题：一组订单信息
    String[] names = new String[4];  //保存订单人信息
    String[] dishMegs = new String[4];  //保存所选信息，包括菜品名及份数
    int[] times = new int [4];   //保存送餐时间
    String[] address = new String[4];  //保存送餐地址
    int[] states = new int [4];   //保存订单状态：0已预订，1已完成
    double[] sumPrices = new double[4];   //保存订单的金额
}
