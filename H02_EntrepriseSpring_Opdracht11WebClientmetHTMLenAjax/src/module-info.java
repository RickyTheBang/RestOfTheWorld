open module house.com {
    requires spring.core;
    //requires spring.orm;
    requires spring.context;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    //requires spring.boot.starter.jdbc;
    requires java.sql;

    //REST
    requires spring.web;
    //JEE annotations
    requires java.annotation;
    //XML binding
    requires java.xml.bind;
    requires com.sun.xml.bind;
    //JSON binding
    requires jackson.annotations;
    //Tomcat JEE classes
   // requires tomcat.embed.core;
    //Bean Validation API
    requires java.validation;






}
