package evs.org.springchat;

import evs.org.model.ChatServerClass;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ChatSrvr {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("SpringXMLConfig.xml");
        ChatServerClass Srvr = (ChatServerClass) context.getBean("SrvrBean");
    }
}
