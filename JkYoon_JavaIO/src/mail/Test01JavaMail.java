package mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * @class : Test01JavaMail.java
 * @title : 
 * @author : Yoon
 * @desciption : java mail을 보내기위해서는 
 * D:\JkYoon\workspace\javaToddler_library\mail.jar 가 필요하다. 
 */
public class Test01JavaMail {

	public static void main(String[] args) throws AddressException, MessagingException {
		 // 메일 관련 정보

        String host = "smtp.naver.com";

        final String username = "web20000";       //네이버 이메일 주소중 @ naver.com앞주소만 기재합니다.

        final String password = "패스워드";   //네이버 이메일 비밀번호를 기재합니다.

        int port = 465;
         

        // 메일 내용
        String recipient = "web20000@naver.com";    //메일을 발송할 이메일 주소를 기재해 줍니다.
        String subject = "네이버를 사용한 발송 테스트입니다.";
        String body = "내용 무";


        Properties props = System.getProperties();
          
        /* 메일 서버의 설정 */
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");		
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.trust", host);

        /* 메일 보내는 사이트의 세션을 생성 */
        Session session = Session.getDefaultInstance(props, new Authenticator() {

            String un= username;
            String pw=password;
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(un, pw);
            }

        });

        session.setDebug(true); //for debug

        Message mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress("web20000@naver.com"));
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        mimeMessage.setSubject(subject);
        mimeMessage.setText(body);
        
        Transport.send(mimeMessage);

	}
}
