@SuppressWarnings("Java9RedundantRequiresStatement")
module osp.platform {
    requires java.desktop;
    requires static lombok;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.core;
    requires org.slf4j;

    exports top.sob.osp.platform.annotation;
    exports top.sob.osp.platform.autoconfigure;
    exports top.sob.osp.platform.bean;
}