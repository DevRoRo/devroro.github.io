package negocio;

import negocio.joystick.Joystick;

public class Videogame {
    Joystick game;

    public void InsertDisk(Joystick game) {
        this.game = game;
    }

    public void pressA() {
       game.pressA(); 
    }

    public void pressB() {
        game.pressB();
    }
}