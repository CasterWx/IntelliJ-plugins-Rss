package com.casterwx;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-03-27-15:18
 */
public class RssBiliBiliAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {

        Init init = new Init() ;
        Thread thread = new Thread(init) ;
        thread.start();
        // TODO: insert action logic here
    }
}
