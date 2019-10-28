package cn.edu.cqupt.nmid.passloveserver.v1.web.listener;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Component
public class RegisterSessionContext {
    private HashMap<String, HttpSession> sessionMap;

    public RegisterSessionContext() {
        sessionMap = new HashMap<String, HttpSession>();
    }

    public synchronized void addSession(HttpSession session) {
        if (session != null) {
            sessionMap.put(session.getId(), session);
        }
    }

    public synchronized void delSession(HttpSession session) {
        if (session != null) {
            sessionMap.remove(session.getId());
        }
    }

    public synchronized HttpSession getSession(String sessionID) {
        if (sessionID == null) {
            return null;
        }
        return sessionMap.get(sessionID);
    }
}
