package task6;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class Application {

    @Inject
    private ServiceClass serviceClass;

    public void initApplication() {
        serviceClass.doSomething("hello world ;)");
    }

}
