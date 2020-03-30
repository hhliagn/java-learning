package com.javalearning.demo.test.util;

import com.javalearning.demo.test.io.Directory;

import java.io.File;
import java.io.IOException;

public class ProcessFilesxxx {
    public interface Strategy{
        void process(File file);
    }

    private Strategy strategy;
    private String ext;

    public ProcessFilesxxx(Strategy strategy, String ext){
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args){
        try {
            if (args.length == 0){
                processDiretoryTree(new File("."));
            }else {
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory()){
                        processDiretoryTree(fileArg);
                    }else {
                        if (!arg.endsWith("." + ext)){ //如果是文件，而且是没加后缀名的，会自动添加后缀名
                            arg += "." + ext;
                        }
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    private void processDiretoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)) {
            strategy.process(file.getCanonicalFile());
        }
    }

    public static void main(String[] args) {
        new ProcessFilesxxx(new Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        },"java").start(args);
    }

}
