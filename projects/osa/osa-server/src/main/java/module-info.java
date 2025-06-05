module osa.server {
    requires static lombok;
    requires org.apache.tomcat.embed.core;
    requires org.mongodb.driver.core;
    requires osl.lib;
    requires osp.plf;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.core;
    requires spring.data.mongodb;
    requires spring.security.config;
    requires spring.security.core;
    requires spring.security.crypto;
    requires spring.security.web;
    requires spring.web;
    requires spring.data.commons;
}