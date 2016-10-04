package com.example;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;

import com.example.config.ConfigReader;

import com.sun.mail.pop3.POP3Store;
import javax.mail.internet.MimeMultipart;


@Component
public class ReceptionMail {
	
	
	@Autowired
	private ConfigReader configReader;
	
	
    ReceptionMail(){}
    
	public void recept() {
		
		
		System.out.println(configReader.getHost());
		
		
		String host = configReader.getHost();
		String username = configReader.getUsername();
		String password = configReader.getPassword();


		try {
			Properties props = new Properties();
			props.setProperty("mail.pop3.host", host);
			Session session = Session.getInstance(props);

			
			POP3Store store = (POP3Store) session.getStore("pop3");
			store.connect(username, password);
			
			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);
			
			Message[] msgs = folder.getMessages();
			for (Message msg : msgs) {
				System.out.println("---------------------------------");
				System.out.println("Email Number " + msg.getMessageNumber());
				System.out.println("Subject: " + msg.getSubject());
				System.out.println("From: " + msg.getFrom()[0]);
				System.out.println("Date: " + msg.getSentDate());

				//System.out.println("Text: " + msg.getContent().toString());
				MimeMultipart mmp = (MimeMultipart) msg.getContent();
				System.out.println("Text: " + mmp.getBodyPart(0).getContent().toString());
				
			}
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
