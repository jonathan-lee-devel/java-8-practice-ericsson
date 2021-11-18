package io.jonathanlee.observables;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

@Slf4j
public class RootObserver implements Observer {

    private double distance;

    @Override
    public void update(Observable observable, Object o) {
        final MovementEvent movementEvent = (MovementEvent) o;
        this.distance += movementEvent.getX();
        this.distance += movementEvent.getY();
        log.info("Total distance moved: {}", this.distance);
    }

}
