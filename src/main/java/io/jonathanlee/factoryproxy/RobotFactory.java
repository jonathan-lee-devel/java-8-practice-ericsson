package io.jonathanlee.factoryproxy;

import io.jonathanlee.observables.Robot;
import io.jonathanlee.observables.SimpleRobot;

import java.util.UUID;

public class RobotFactory {

    public enum ROBOT_TYPE {
        SIMPLE
    }

    public static Robot createRobot(final ROBOT_TYPE robotType) {
        if (robotType == ROBOT_TYPE.SIMPLE) {
            return new SimpleRobot(UUID.randomUUID().toString());
        }

        return null;
    }

}
