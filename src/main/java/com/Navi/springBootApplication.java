package com.Navi;

import com.Navi.Service.impl.naviServicesImpl;
import com.Navi.Service.naviServices;
//import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication()
@EnableAsync
@Configuration
@EnableConfigurationProperties
//@EnableJpaRepositories(basePackages = {"com.navi.*"},
//        entityManagerFactoryRef = "entityManagerFactory",
//        enableDefaultTransactions = false)
public class springBootApplication {

    public static void main(String[] args){
//        args[0]= springBootApplication.class.getClassLoader().getResource("ivtest2.csv").getFile();
        if (args.length < 1) {
            System.err.println("Please provide an input!");
            System.exit(0);
        }
//        System.out.println(sha256hex(args[0]));
        naviServicesImpl naviServices = new naviServicesImpl();
        boolean x = naviServices.processFile(args[0]);
//        SpringApplication.run(springBootApplication.class, args);
}
//    public static String sha256hex(String input) {
//        return DigestUtils.sha256Hex(input);
//    }
}
