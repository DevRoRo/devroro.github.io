package negocio.joystick;

import negocio.games.Soccer;

public class JoystickSoccer implements Joystick {
    Soccer game;

    public JoystickSoccer(Soccer game) {
        this.game = game;
    }

    @Override
    public void pressA() {
        this.game.run();
    }

    @Override
    public void pressB() {
        this.game.kick();
    }
    
}
