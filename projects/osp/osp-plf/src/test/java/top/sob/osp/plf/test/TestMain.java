package top.sob.osp.plf.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import top.sob.osp.plf.test.basicUnit.configuration.BasicUnitConfiguration;

public class TestMain {
    @Test
    public void basicUnit() {
        SpringApplication.run(BasicUnitConfiguration.class);
    }
}
