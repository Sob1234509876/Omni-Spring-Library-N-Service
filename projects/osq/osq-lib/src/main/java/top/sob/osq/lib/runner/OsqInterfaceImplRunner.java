package top.sob.osq.lib.runner;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class OsqInterfaceImplRunner implements ApplicationRunner, ApplicationContextAware {

    @NonNull
    ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) {
    }
}
