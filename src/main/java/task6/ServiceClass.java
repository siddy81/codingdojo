package task6;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Dependent;

@Dependent
public class ServiceClass implements IService {
    @PostConstruct
    public void initialize() {
        System.out.println("Initializing");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Cleaning");
    }

    private void serviceMethod(String job) {
        System.out.println(job + " done...");
    }

    @Override
    public void doSomething(String job) {
        serviceMethod(job);
    }
}
