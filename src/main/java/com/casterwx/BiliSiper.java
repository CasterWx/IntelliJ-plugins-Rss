package com.casterwx;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-03-27-15:06
 */
public class BiliSiper {

    public static void getBili(String url,HashSet<Interfor> arrayList) throws IOException {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault() ;
        HttpGet httpPost = new HttpGet(url);
        httpPost.setHeader("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
        CloseableHttpResponse response=closeableHttpClient.execute(httpPost);
        HttpEntity entity=response.getEntity();
        String ux = EntityUtils.toString(entity,"utf-8") ;

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
            arrayList.add(interfor) ;
        }
    }


    public static void getBili(String url,ArrayList<Interfor> arrayList) throws IOException {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault() ;
        HttpGet httpPost = new HttpGet(url);
        httpPost.setHeader("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
        CloseableHttpResponse response=closeableHttpClient.execute(httpPost);
        HttpEntity entity=response.getEntity();
        String ux = EntityUtils.toString(entity,"utf-8") ;

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
            arrayList.add(interfor) ;
        }
        arrayList.remove(0) ;
    }
}
