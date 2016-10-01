package com.example;
 
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.MyUser;
import com.example.jpa.MyUserRepository;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;


@Controller
@EnableAutoConfiguration
public class HelloController {
 
    @RequestMapping("/")
    public String index(Model model) {
        ArrayList<ViewData> list = new ArrayList<ViewData>();
        for (int i = 0; i < 5; i++) {
            ViewData data = new ViewData();
            StringBuffer buffer = new StringBuffer();
            buffer.append("メッセージ");
            buffer.append(i);
            data.setNo(i + 1);
            data.setMessage(buffer.toString());
            list.add(data);
        }
        
        //test sendmail
        //this.sendMail();
        
        //db dataset test
        //this.dbset();
        
        
        model.addAttribute("msg", list);
        return "index";
    }
    



    // db
    @Autowired
    private MyUserRepository repository;

    public void dbset() {
        this.repository.save(new MyUser("test"));
        //this.repository.findAll().forEach(System.out::println);
    }





    
    
    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);

        return "hello";
    }
    

    // input formを表示
    @RequestMapping("/input")
    public String input() {
        return "input"; // input form
    }
     
    // inputフォームから受け取ってhello.htmlへ
    @RequestMapping("/send")
    public String send(Model model, @RequestParam("name") String name) {
      model.addAttribute("name", name);
      return "hello";    // View file is templates/hello.html
    }
    


    
    // mail    
    @Autowired
    private MailSender sender;

    public void sendMail() {
    	System.out.println("send mail test");
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setFrom("test@mail.com");
        msg.setTo("---@gmail.com");
        msg.setSubject("テストメール"); //タイトルの設定
        msg.setText("Spring Boot より本文送信"); //本文の設定

        this.sender.send(msg);
    }
    
}




// out class
class ViewData {
    private int no;
    private String message;
 
    public int getNo() {
        return no;
    }
 
    public void setNo(int no) {
        this.no = no;
    }
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public String toString() {
        return message;
    }
}