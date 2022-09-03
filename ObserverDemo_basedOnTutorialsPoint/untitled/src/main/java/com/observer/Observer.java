package com.observer;

//Step 1: Create observer class
public abstract class Observer {

    //Step 1.1. Setup subject object
    protected Subject subject;

    //Step 1.2. Prepare an abstract update method (abstract requires child classes to override this method)
    public abstract void update();
}
