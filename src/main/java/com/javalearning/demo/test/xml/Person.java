package com.javalearning.demo.test.xml;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class Person {

    private String first, last;

    public Person(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public Element getXML(){
        Element person = new Element("person");
        Element firstName = new Element("firstName");
        Element lastName = new Element("lastName");

        firstName.appendChild(first);
        lastName.appendChild(last);

        person.appendChild(firstName);
        person.appendChild(lastName);

        return person;
    }

    public Person(Element person){
        first = person.getFirstChildElement("firstName").getValue();
        last = person.getFirstChildElement("lastName").getValue();
    }

    public static void format(OutputStream out, Document doc) throws IOException {
        Serializer serializer = new Serializer(out, "ISO-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException {
        List<Person> persons = Arrays.asList(new Person("AAA", "RED"), new Person("BBB", "BLUE"), new Person("CCC", "GREEN"));

        Element root = new Element("root");
        for (Person person : persons) {
            Element xml = person.getXML();
            root.appendChild(xml);
        }

        Document document = new Document(root);
        format(System.out, document);

        BufferedOutputStream buf = new BufferedOutputStream(new FileOutputStream("People.xml"));
        format(buf, document);
    }
}
