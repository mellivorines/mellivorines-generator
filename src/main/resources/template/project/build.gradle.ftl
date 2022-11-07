plugins {

id 'org.springframework.boot' version '2.7.5'
id 'io.spring.dependency-management' version '1.0.15.RELEASE'
id 'java'
}

group = 'com.mellivorines'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '1.8'

repositories {
mavenCentral()
}

dependencies {
implementation 'org.springframework.boot:spring-boot-starter-web'
implementation 'com.github.xiaoymin:knife4j-spring-boot-starter:3.0.3'
implementation 'mysql:mysql-connector-java:8.0.30'
implementation 'org.springframework.boot:spring-boot-starter-jdbc:2.7.5'
implementation 'org.apache.commons:commons-lang3:3.12.0'
implementation 'org.babyfish.jimmer:jimmer-sql:0.3.5'
annotationProcessor 'org.babyfish.jimmer:jimmer-apt:0.3.5'
testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

tasks.named('test') {
useJUnitPlatform()
}