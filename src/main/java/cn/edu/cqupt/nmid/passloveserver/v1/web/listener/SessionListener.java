package cn.edu.cqupt.nmid.passloveserver.v1.web.listener;

import javax.annotation.Resource;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Resource
    private LoginSessionContext lsc;

    @Resource
    private RegisterSessionContext rsc;

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
//        HttpSession session = httpSessionEvent.getSession();
//        myc.addSession(session);
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        lsc.delSession(session);
        rsc.delSession(session);
    }
}
