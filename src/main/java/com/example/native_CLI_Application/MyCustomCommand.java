package com.example.native_CLI_Application;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class MyCustomCommand {

    @ShellMethod(key = "hello")
    public String hello(@ShellOption(defaultValue = "me") String name,
                        @ShellOption(defaultValue = "1") int counter){
        StringBuilder stringBuilder= new StringBuilder();
        for (int i = 0; i < counter; i++) {
            stringBuilder.append("Hello "+name+" iteration "+i+" \n");
        }
        return stringBuilder.toString();
    }
    @ShellMethod(key = "test")
    public String test(){
        return "Test Shell";
    }
}
