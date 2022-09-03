package com.observer;

//Step 3. Create subscriber class, inherit from Observer class
public class Subscriber extends Observer{
    //3.1. Set a subject attribute, initialize on constructor
    private final Subject subject;
    private final String name;
    public String status;

    public Subscriber(String name, Subject subject){
        this.subject = subject;
        this.subject.attach(this);
        this.name = name;
        this.status = "";
    }

    //3.2. Override the update method from Observer, define according to how you want to acknowledge the notification
    @Override
    public void update() {
        String output = String.format("My name is %s, I am a subscriber. The message is: %s", this.name, this.subject.getState());
        System.out.println(output);
        this.status = output;
    }
}
