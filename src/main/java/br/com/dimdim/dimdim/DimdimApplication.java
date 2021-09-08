package br.com.dimdim.dimdim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DimdimApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DimdimApplication.class, args);
    }

}
