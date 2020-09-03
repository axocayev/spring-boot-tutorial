package az.atl.academy.hrapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MyComp1 {

    @Autowired
    private  MyService myService;

    public MyService getMyService() {
        return myService;
    }

    public void setMyService(MyService myService) {
        this.myService = myService;
    }
}
