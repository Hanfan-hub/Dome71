package com.version;

import java.util.Scanner;

public class Reservation2 {
    String[] dishNames={"红烧带鱼","鱼香肉丝","时令鲜蔬"};
    double[] prices = new double[] {38.0,20.0,10.0};
    int[] praiseNums = new int[3];
    Scanner input = new Scanner(System.in);
    Reservation shuzu = new Reservation();

    public void initial(){
        shuzu.names[0] = "张晴";
        shuzu.dishMegs[0] = "红烧带鱼2份";
        shuzu.times[0] = 12;
        shuzu.address[0] = "天成路207号";
        shuzu.sumPrices[0] = 76.0;
        shuzu.states[0] = 1;
        shuzu.names[1] = "张晴";
        shuzu.dishMegs[1] = "鱼香肉丝2份";
        shuzu.times[1] = 18;
        shuzu.address[1] = "天成路207号";
        shuzu.sumPrices[1] = 20.0;
        shuzu.states[1] = 0;
    }
    boolean ding() {
        boolean isci = false;
        for (int i = 0; i < shuzu.names.length; i++) {
            if (shuzu.names[i]==null){
                isci=true;
                System.out.printf("请输入您的姓名：");
                String name=input.next();
                System.out.println("序号"+"\t"+"菜名"+"\t \t"+"单价"+"\t"+"点赞数");
                for (int j = 0;j < prices.length; j++){
                    String yuan = prices[j]+"元";
                    String dian = (praiseNums[j])>0?praiseNums[i]+"赞":"0";
                    System.out.println((j + 1) + "\t" + dishNames[j] + "\t" +yuan+ "\t" + dian);
                }
                System.out.printf("请输入您选择的菜品编号：");
                int cai=input.nextInt();
                System.out.printf("请输入您需要的份数：");
                int fen = input.nextInt();
                double qian = prices[cai-1]*fen;
                String meg = dishNames[cai-1]+""+ fen +"份";
                double fei = 0.0;
                if (fei<50){
                    fei=5;
                }else{
                    fei=0;
                }
                System.out.println("请输入送餐时间（送餐时间是10点至20点间整点送餐）：");
                int time = input.nextInt();
                while(time < 10 || time>20){
                    System.out.println("您的输入有误，请输入10~20间的整数！");
                    time = input.nextInt();
                }
                System.out.println("请输入送餐地址：");
                String address = input.next();
                System.out.println("订餐成功！");
                System.out.println("您订的是："+meg);
                System.out.println("送餐时间：" + time + "时");
                System.out.println("餐费："+qian+"元，送餐费"+fei+"元，总计："+(qian+fei)+"元。");
                shuzu.names[i] = name;
                shuzu.dishMegs[i] = dishNames[cai-1];
                shuzu.times[i] = time;
                shuzu.address[i] = address;
                shuzu.sumPrices[i] = qian+fei;
                break;
            }
        }
                if (!isci){
                    System.out.println("您的餐袋已满");
                    return false;
               }else {
                    return true;
        }
    }
                void  cip(){
                    System.out.printf("序号\t订餐人\t餐品信息\t\t送餐时间\t\t送餐地址\t\t总金额\t订单状态");
                    for (int i = 0; i < shuzu.names.length;i++){
                        if (shuzu.names[1]!=null){
                            String state = (shuzu.states[i]==0)?"已预订":"已完成";
                            String date  = shuzu.times[i]+"时";
                            String sumPrice=shuzu.sumPrices[i]+"元";
                            System.out.println((i+1)+"\t"+shuzu.names[i] + "\t"+ "\t"+shuzu.dishMegs[i]+"\t"+date+"\t"+ shuzu.address[i]+"\t"+sumPrice+"\t"+state);
                        }
                    }
                }
                void  yic(){
                    boolean unjun=false;
                    System.out.printf("请选择要签收的订单序号：");
                    int sig = input.nextInt();
                    for (int i = 0; i < shuzu.names.length; i++){
                        if (shuzu.names[i]!=null && shuzu.states[i]==1 & sig==i+1){
                            shuzu.states[i] = 1;
                            System.out.println("订单签收成功!");
                            unjun = true;
                        }
                    }
                    if (!unjun){
                        System.out.println("您选择的订单不存在");
                    }
                }
                void jian(){
                    boolean chun=false;
                    System.out.println("请输入您要查询的订单序号：");
                    int xu=input.nextInt();
                    for (int i = 0; i < shuzu.names.length;i++){
                        if (shuzu.names[i]!=null && shuzu.states[i]==1 && xu==i+1){
                            chun = true;
                            for (int j=xu-1;j<shuzu.names.length-1;j++){
                                shuzu.names[j] = shuzu.names[j+1];
                                shuzu.dishMegs[j] = shuzu.dishMegs[j+1];
                                shuzu.times[j] = shuzu.times[j+1];
                                shuzu.address[j] = shuzu.address[j+1];
                                shuzu.states[j] = shuzu.states[j+1];
                            }
                    int nu = shuzu.names.length-1;
                    shuzu.names[nu] = null;
                    shuzu.dishMegs[nu] = null;
                    shuzu.times[nu] = 0;
                    shuzu.address[nu] = null;
                    shuzu.states[nu] =0;

                    System.out.println("删除订单成功！");
                    break;
                        }
                    }
                if (!chun){
                    System.out.println("您要删除的订单不存在！");
                }
            }
                void ping(){
                    System.out.println("序号" + "\t" + "菜名" + "\t" + "单价" + "\t" + "点赞数");
                    for (int i = 0;i < dishNames.length;i++){
                        String price = dishNames[i] + "元";
                        String zhang;
                        if (praiseNums[i] > 0)
                            zhang = praiseNums[i] + "赞";
                        else
                            zhang = "";
                        //price报错的话改为prices
                        System.out.println((i + 1)+ "\t" + dishNames[i] + "\t" + price+ "\t" + zhang);
                    }
                int priaiseNum;
                do {
                    System.out.printf("请选择您要点赞的序号：");
                    priaiseNum = input.nextInt();
                }while (priaiseNum<=0 || priaiseNum>dishNames.length);
                praiseNums[priaiseNum-1]++;
                System.out.println("点赞成功！");
                }
            public void niu(){
        int num = -1;
        boolean isc = false;
        System.out.println("欢迎使用吃货联盟订餐系统");
        do{
            System.out.println("*********************************************");
            System.out.println("1、我要订餐");
            System.out.println("2、查看餐袋");
            System.out.println("3、签收订单");
            System.out.println("4、删除订单");
            System.out.println("5、我要点赞");
            System.out.println("6、退出系统");
            System.out.println("*******************************************************************");
            System.out.printf("请选择：");
            int oose = input.nextInt();
            switch (oose){
                case 1:
                    System.out.println("***我要订餐***");
                    ding();
                    break;
                case 2:
                    System.out.println("***查看餐袋***");
                    cip();
                    break;
                case 3:
                    System.out.println("***签收订单***");
                    yic();
                    break;
                case 4:
                    System.out.println("***删除订单***");
                    jian();
                    break;
                case 5:
                    System.out.println("***我要点赞***");
                    ping();
                    break;
                case 6:
                    isc = true;
                    break;
                default:
                    isc = true;
                    break;
            }
            if (!isc){
                System.out.printf("输入0返回：");
                num = input.nextInt();
            }else{
                break;
            }
        }while (num==0);
                System.out.println("谢谢使用，欢迎下次光临！");
            }
}

