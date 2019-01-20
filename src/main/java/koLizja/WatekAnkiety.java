package koLizja;

import koLizja.generatory.GeneratorWynikowAnkiet;

public class WatekAnkiety extends Thread {

    private Thread thread;
    private GeneratorWynikowAnkiet generatorWynikowAnkiet;
    private int from;
    private int to;

    public WatekAnkiety(GeneratorWynikowAnkiet generatorWynikowAnkiet, int from, int to) {
        this.generatorWynikowAnkiet = generatorWynikowAnkiet;
        this.from = from;
        this.to = to;
    }

//    public void run() {
//        generatorWynikowAnkiet.create(from,to);
//    }



}
