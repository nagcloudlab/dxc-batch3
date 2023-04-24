package org.example;

import java.time.LocalDateTime;

class DxcTraining {
    public void getJavaTraining() {
        System.out.println("Dxc Java Training");
    }

    public void getJavascriptTraining() {
        System.out.println("Dxc Java Training");
    }
}

class Log{
    public void log() {
        System.out.println("Log: "+ LocalDateTime.now());
    }
}

class Auth{
    public void authorize() {
        System.out.println("Authorized:");
    }
}

class DxcTrainingProxy extends DxcTraining{

    Log log = new Log();
    Auth auth = new Auth();
    DxcTraining dxcTraining=new DxcTrainingProxy();

    @Override
    public void getJavaTraining() {
        log.log();
        auth.authorize();
        dxcTraining.getJavaTraining();
    }

    @Override
    public void getJavascriptTraining() {
        log.log();
        auth.authorize();
        dxcTraining.getJavascriptTraining();
    }
}

public class ProxyPatternEx {
    public static void main(String[] args) {

        DxcTrainingProxy dxcTraining = new DxcTrainingProxy();
        dxcTraining.getJavaTraining();

    }
}
