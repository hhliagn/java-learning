package com.javalearning.demo.test.io;

import com.javalearning.demo.test.util.PPrint;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class Directory {
    public static File[] local(File dir, final String regex){
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
    }

    public static File[] local(String path, final String regex){
        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File>{

        public List<File> dirs = new ArrayList<>();
        public List<File> files = new ArrayList<>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        public void addAll(TreeInfo treeInfo){
            dirs.addAll(treeInfo.dirs);
            files.addAll(treeInfo.files);
        }

        @Override
        public String toString() {
            return "dirs: " + PPrint.pformat(dirs)
                    + "\n\nfiles: " + PPrint.pformat(files);
        }
    }

    public static TreeInfo walk(String path, String regex){
        return recurseDirs(new java.io.File(path), regex);
    }

    public static TreeInfo walk(java.io.File dir, String regex){
        return recurseDirs(dir, regex);
    }

    public static TreeInfo walk(String path){
        return recurseDirs(new java.io.File(path), ".*");
    }

    public static TreeInfo walk(File file){
        return recurseDirs(file, ".*");
    }

    private static TreeInfo recurseDirs(java.io.File dir, String regex) {
        TreeInfo treeInfo = new TreeInfo();
        java.io.File[] files = dir.listFiles();
        for (java.io.File file : files) {
            if (file.isDirectory()){
                treeInfo.dirs.add(file);
                treeInfo.addAll(recurseDirs(file, regex));
            }else {
                if (file.getName().matches(regex)){
                    treeInfo.files.add(file);
                }
            }
        }
        return treeInfo;
    }

    public static void main(String[] args) {
        if (args.length == 0){
            TreeInfo walk = walk(".");
            System.out.println(walk);
        }else {
            for (String arg : args) {
                TreeInfo walk = walk(arg);
                System.out.println(walk);
            }
        }
    }
}
