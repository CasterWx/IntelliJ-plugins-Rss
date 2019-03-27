package com.casterwx;

import java.io.IOException;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-03-27-15:05
 */
public class Init implements Runnable{
    @Override
    public void run() {
        try {
            BiliSiper.getBili("https://rsshub.app/toutiao/today",Utils.toutiao);
//            BiliSiper.getBili("https://rsshub.app/weibo/user2/5893163236",Utils.weibo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Interfor interfor : Utils.toutiao){
            System.out.println(interfor.toString());
        }
        for (Interfor interfor : Utils.weibo){
            System.out.println(interfor.toString());
        }
        BiliBiliThread biliBiliThread = new BiliBiliThread() ;
        GetThread getThread = new GetThread() ;
        Thread thread2 = new Thread(biliBiliThread) ;
//        Thread thread4 = new Thread(getThread) ;
        thread2.start();
//        thread4.start();
    }
}
