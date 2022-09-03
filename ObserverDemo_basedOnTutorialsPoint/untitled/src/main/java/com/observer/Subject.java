
package com.observer;

import java.util.ArrayList;
import java.util.List;

//Step 2: define Subject class
public class Subject {

    //Step 2.1. Create private list of observers and state
    private final List<Observer> observers = new ArrayList<>();
    private String state;
    public String getState(){
        return this.state;
    }

    //Step 2.2. Create setState method
    public void setState(String state){
        this.state = state;
        this.notifyAllObservers();
    }

    //Step 2.3. Create attach method
    public void attach(Observer observer){
        this.observers.add(observer);
    }

    //Step 2.4. Create notifyAllObserver method
    public void notifyAllObservers(){
        this.observers.forEach(Observer::update);
    }
}
