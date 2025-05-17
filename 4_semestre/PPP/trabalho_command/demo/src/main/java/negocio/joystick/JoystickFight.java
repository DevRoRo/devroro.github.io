package negocio.joystick;

import negocio.games.Fight;

public class JoystickFight implements Joystick {
    Fight game;

    public JoystickFight(Fight game) {
        this.game = game;
    }

    @Override
    public void pressA() {
        this.game.punch();
    }

    @Override
    public void pressB() {
        this.game.kick();
    }
    
}
