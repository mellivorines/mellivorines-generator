server:
  port: 3000

spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/mellivorines?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false
    username: root
    password: 777888love@#
    driver-class-name: com.mysql.cj.jdbc.Driver
  mvc:
    format:
      date: dd/MM/yyyy HH:mm:ss
    pathmatch:
      matching-strategy: ANT_PATH_MATCHER
    log-request-details: true
