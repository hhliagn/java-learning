package com.javalearning.demo.design_pattern.chain_of_responsibility.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    public static void init(){
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        Middleware middleware = new ThrottingMiddleware(2);
        middleware
                .linkWith(new UserExistingMiddleware(server))
                .linkWith(new RoleCheckMiddleware());
        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();
        boolean success;
        do {
            System.out.println("Enter email:");
            String email = bufferedReader.readLine();
            System.out.println("Enter password:");
            String password = bufferedReader.readLine();
            success = server.logIn(email, password);
        }while (!success);
    }
}
