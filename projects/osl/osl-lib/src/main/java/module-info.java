open module osl.lib {
    requires static lombok;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.data.commons;
    requires spring.data.mongodb;
    requires spring.security.core;

    exports top.sob.osl.lib.util;
    exports top.sob.osl.lib.dao;
    exports top.sob.osl.lib.dao.mongo;
}