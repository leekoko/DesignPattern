package com.geely.design.pattern.creational.prototype;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();
        mail.setContent("初始化模板");
        System.out.println("初始化mail："+mail);
        for (int i = 0; i < 10; i++) {
            Mail mail1Temp = (Mail) mail.clone();
            mail1Temp.setName("姓名"+i);
            mail1Temp.setEmailAddress("姓名"+i+"@imooc.com");
            mail1Temp.setContent("恭喜你，此次活动中奖了");
            MailUtil.sendMail(mail1Temp);
            System.out.println("克隆的mailTemp" + mail1Temp);
        }
        MailUtil.saveOriginMailRecord(mail);
    }
}
