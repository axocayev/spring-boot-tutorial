package az.atl.academy.hrapp.controller;

import org.springframework.stereotype.Component;

@Component
public class MyComp3 {

    MyService myService;

    public MyComp3(MyService myService) {
        this.myService = myService;
    }
}
