package apresentacao;

import negocio.Videogame;
import negocio.games.Fight;
import negocio.games.Race;
import negocio.games.Soccer;
import negocio.joystick.JoystickFight;
import negocio.joystick.JoystickRace;
import negocio.joystick.JoystickSoccer;

public class Main {
    public static void main(String[] args) {
        Videogame videogame = new Videogame();
        JoystickSoccer soccer = new JoystickSoccer(new Soccer("Futebol"));
        JoystickFight fight = new JoystickFight(new Fight("Luta"));
        JoystickRace race = new JoystickRace(new Race("Corrida"));

        videogame.InsertDisk(soccer);
        videogame.pressA();
        videogame.pressB();

        videogame.InsertDisk(fight);
        videogame.pressA();
        videogame.pressB();

        videogame.InsertDisk(race);
        videogame.pressA();
        videogame.pressB();

        
        
    }
}