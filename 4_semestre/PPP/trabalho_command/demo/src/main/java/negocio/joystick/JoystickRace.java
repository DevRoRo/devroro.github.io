package negocio.joystick;

import negocio.games.Race;

public class JoystickRace implements Joystick {
    Race game;

    public JoystickRace(Race game) {
        this.game = game;
    }

    @Override
    public void pressA() {
        this.game.accelerate();
    }

    @Override
    public void pressB() {
        this.game.brake();
    }
    
}