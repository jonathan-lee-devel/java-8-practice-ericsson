package io.jonathanlee.observables;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Observable;

@RequiredArgsConstructor
@Slf4j
public class SimpleRobot extends Observable implements Robot {

    private final String name;

    @Override
    public void move(int x, int y) {
        log.info("Robot {} is moving x = {} and y = {}", this.name, x, y);
        this.setChanged();
        this.notifyObservers(new MovementEvent(x, y));
    }

}
