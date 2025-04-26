open module osp.lib {
    requires static lombok;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires org.slf4j;

    exports top.sob.osp.app;
    exports top.sob.osp.app.configuration;
    exports top.sob.osp.app.runner;
    exports top.sob.osp.app.loader;
    exports top.sob.osp.app.bean;
    exports top.sob.osp.app.annotation;
}