package com.javalearning.demo.test.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OSExcute {

    public static void command(String command){
        boolean err = false;

        try {
            Process process = new ProcessBuilder(command.split(" ")).start();

            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String s;
            while ( (s = in.readLine()) != null){
                System.out.println(s);
            }

            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            while ( (s = errors.readLine()) != null){
                System.err.println(s);
                err = true;
            }

        }catch (Exception e){
            if (!command.startsWith("CMD /C")){
                command("CMD /C " + command);
            }else {
                throw new RuntimeException(e);
            }
        }

        if (err){
            throw new OSExcuteException("Errors executing : " + command);
        }
    }
}
