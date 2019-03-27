package com.casterwx;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-03-27-16:40
 */
public class GetThread implements Runnable {
    @Override
    public void run() {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault() ;
        HttpGet httpPost = new HttpGet("https://rsshub.app/weibo/user2/5893163236");
        httpPost.setHeader("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
        CloseableHttpResponse response= null;
        System.out.println("Get down -----");
        while(true){
            try {
                response = closeableHttpClient.execute(httpPost);
            } catch (IOException e) {
                e.printStackTrace();
            }
            HttpEntity entity=response.getEntity();
            String ux = null;
            try {
                ux = EntityUtils.toString(entity,"utf-8");
            } catch (IOException e) {
                e.printStackTrace();
            }

            Pattern title = Pattern.compile("<title>(.*?)</title>") ;
            Matcher titleMr = title.matcher(ux) ;
            Pattern description =  Pattern.compile("<description>(.*?)</description>") ;
            Matcher descriptionMr = description.matcher(ux) ;
            Pattern link =  Pattern.compile("<link>(.*?)</link>") ;
            Matcher linkMr = link.matcher(ux) ;

            while (titleMr.find()&&descriptionMr.find()&&linkMr.find()){
                Interfor interfor = new Interfor() ;
                interfor.setTitle(titleMr.group().replace("<title><![CDATA[","").replace("]]></title>",""));
                interfor.setDesc(descriptionMr.group().replace("<description><![CDATA[","").replace("]]></description>",""));
                interfor.setUrl(linkMr.group().replace("<link>","").replace("</link>",""));
                if ((!Utils.weibo.contains(interfor))){
                    NotificationCenter.notice(interfor);
                    System.out.println("ºóÔö£º"+Utils.weibo.size()+interfor.toString());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
