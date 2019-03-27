package com.casterwx;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-03-27-14:36
 */
public class NotificationCenter {
    static void notice(Interfor interfor) {
        Notification n = new Notification(
                "extras",
                interfor.getTitle(),
                interfor.getDesc()+"\n"+interfor.getUrl(),
                NotificationType.INFORMATION);
        Notifications.Bus.notify(n);
    }
}
