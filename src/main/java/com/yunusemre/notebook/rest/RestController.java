package com.yunusemre.notebook.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Merhaba YouTube!";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name){
        return "Merhaba YouTube! via " + name;
    }

    @GetMapping("/names")
    public String getNames(){

        String username = "root";
        String password = "123Admin";

        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/spring_first?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";

        try{
            System.out.println("Connecting to database:" + jdbcUrl);

            Class.forName(driver);

            Connection myConnection = DriverManager.getConnection(jdbcUrl, username, password);
            PreparedStatement stmt = myConnection.prepareStatement("SELECT * FROM spring_table_first");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            String returnVal = "Success ";
            while(rs.next()){
                returnVal += rs.getString("name") + " ";
            }

            rs.close();
            stmt.close();
            myConnection.close();

            return returnVal;
        }catch (Exception e){
            e.printStackTrace();
            return "Fail";
        }
    }
}
