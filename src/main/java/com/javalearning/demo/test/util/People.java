package com.javalearning.demo.test.util;

import com.javalearning.demo.test.xml.Person;
import nu.xom.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class People extends ArrayList<Person> {

    public People(String fileName) throws ParsingException, IOException {
        File file = new File(fileName);
        Document document = new Builder().build(file);
        Elements childElements = document.getRootElement().getChildElements();
        for (int i = 0; i < childElements.size(); i++) {
            Element element = childElements.get(i);
            Person person = new Person(element);
            add(person);
        }
    }
    public static void main(String[] args) throws ParsingException, IOException {
        People people = new People("G:/my_workspace/java-learning/People.xml");
        System.out.println(people);
    }
}
