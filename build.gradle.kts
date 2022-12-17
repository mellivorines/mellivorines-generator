import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.12.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    id("com.google.devtools.ksp") version "1.7.10-1.0.6"
}

group = "com.mellivorines"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.babyfish.jimmer:jimmer-sql-kotlin:0.5.13")
    ksp("org.babyfish.jimmer:jimmer-ksp:0.5.13")

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation ("org.springframework.boot:spring-boot-starter-web")
    implementation ("com.github.xiaoymin:knife4j-spring-boot-starter:3.0.3")
    implementation ("org.springframework.boot:spring-boot-starter-jdbc")

    implementation ("mysql:mysql-connector-java:8.0.30")
    implementation ("org.postgresql:postgresql:42.5.0")
    implementation ("com.oracle.database.jdbc:ojdbc6:11.2.0.4")
    implementation ("com.microsoft.sqlserver:mssql-jdbc:11.2.1.jre8")

    implementation ("org.apache.commons:commons-lang3:3.12.0")
    implementation ("org.freemarker:freemarker:2.3.31")

    testImplementation ("org.springframework.boot:spring-boot-starter-test")
}
kotlin {
    sourceSets.main {
        kotlin.srcDir("build/generated/ksp/main/kotlin")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
