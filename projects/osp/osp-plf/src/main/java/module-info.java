open module osp.plf {
    requires static lombok;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires org.slf4j;

    exports top.sob.osp.plf;
    exports top.sob.osp.plf.configuration;
    exports top.sob.osp.plf.runner;
    exports top.sob.osp.plf.loader;
    exports top.sob.osp.plf.bean;
    exports top.sob.osp.plf.annotation;
}