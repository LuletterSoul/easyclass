package edu.vero.easyclass.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"edu.vero.easyclass"}) // 扫描该包路径下的所有spring组件
@EntityScan({"edu.vero.easyclass.domain"})
@SpringBootApplication
public class EasyClassApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(EasyClassApplication.class, args);
    }
}
