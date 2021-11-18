package io.jonathanlee.observables;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class HeadRobot extends Observable implements Robot {

    private final List<Robot> childRobots;

    public HeadRobot() {
        this.childRobots = new ArrayList<>();
    }

    @Override
    public void move(int x, int y) {
        this.childRobots.forEach(robot -> robot.move(x, y));
    }

    public void addRobot(Robot robot) {
        this.childRobots.add(robot);
    }

}
