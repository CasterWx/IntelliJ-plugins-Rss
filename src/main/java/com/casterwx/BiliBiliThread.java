package com.casterwx;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-03-27-15:04
 */
public class BiliBiliThread implements Runnable {
    @Override
    public void run() {
        for (Interfor interfor : Utils.toutiao) {
            NotificationCenter.notice(interfor);
            try {
                Thread.sleep(120000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
