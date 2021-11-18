package io.jonathanlee.observables;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MovementEvent {

    private final int x;
    private final int y;

}
