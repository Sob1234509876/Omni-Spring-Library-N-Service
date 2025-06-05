module osp.client {
    requires static lombok;
    requires osp.plf;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.web;

    exports top.sob.osp.client.bean;
    exports top.sob.osp.client.runner;
    exports top.sob.osp.client.configuration;
}