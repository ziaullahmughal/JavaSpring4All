package evs.org.springchat;

import evs.org.model.ChatClientClass;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author zia
 */
public class ChatClnt {
     public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("SpringXMLConfig.xml");
        ChatClientClass Clnt = (ChatClientClass) context.getBean("ClntBean");
    }
}
