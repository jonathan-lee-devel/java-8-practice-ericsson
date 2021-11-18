package io.jonathanlee.observables;

import java.util.Observable;
import java.util.UUID;

public class RobotDriver {

    public static void main(String[] args) {
        final RootObserver rootObserver = new RootObserver();

        final HeadRobot headRobot = new HeadRobot();
        for (int i = 0; i < 3; i++) {
            headRobot.addRobot(new SimpleRobot(UUID.randomUUID().toString()));
        }
        final Observable robotObservable = (Observable) headRobot;
        robotObservable.addObserver(rootObserver);
        headRobot.move(10, 5);
        headRobot.move(15, 10);
        headRobot.move(20, 15);
        headRobot.move(25, 20);
        headRobot.move(30, 25);
    }

}
