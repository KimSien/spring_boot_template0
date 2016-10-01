# spring-boot template

In production.
・・・



## 1 setup

### application.yml


```

spring:

  datasource:
    url: jdbc:mysql://localhost:[ip adress]/[database name]
    username: [user name]
    password: [password]
    driver-class-name: com.mysql.jdbc.Driver
  
  jpa:
    database: MYSQL
    hibernate.ddl-auto: update


  mail:
    host: [sakura domain id].sakura.ne.jp
    port: 587
    username: [ ]@[ ].jp
    password: [password]
    properties.mail.smtp.auth: true
    properties.mail.smtp.starttls.enable: true
    properties.mail.smtp.protocol: Protocol.SMTP

```






