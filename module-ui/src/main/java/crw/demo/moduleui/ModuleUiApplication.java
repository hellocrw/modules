package crw.demo.moduleui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"crw.demo"})
public class ModuleUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleUiApplication.class, args);
    }

}
