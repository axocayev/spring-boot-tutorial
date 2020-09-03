package az.atl.academy.hrapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyComp4 {

    MyService myService;
    @Autowired
    public void setMyService(MyService myService){
        this.myService=myService;
    }
}
