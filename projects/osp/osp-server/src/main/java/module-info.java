module osp.server {
    requires static lombok;
    requires osp.plf;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.core;
    requires spring.web;

    exports top.sob.osp.server.bean;
    exports top.sob.osp.server.configuration;
    exports top.sob.osp.server.annotation;
    exports top.sob.osp.server.controller;
    exports top.sob.osp.server.service;
}