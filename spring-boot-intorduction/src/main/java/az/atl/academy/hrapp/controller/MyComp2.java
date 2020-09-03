package az.atl.academy.hrapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyComp2 {
    @Autowired
    private  MyService myService;

    public MyService getMyService() {
        return myService;
    }

    public void setMyService(MyService myService) {
        this.myService = myService;
    }
}
