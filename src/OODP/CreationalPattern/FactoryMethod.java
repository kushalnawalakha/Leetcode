package OODP.CreationalPattern;
/*
How can an object be created so that subclasses can redefine which class to instantiate?
How can a class defer instantiation to subclasses?

A class implementing factory design pattern works as bridge between multiple classes.
Consider an example of using multiple database servers like SQL Server and Oracle.
If you are developing an application using SQL Server database as backend, but in future need to change backend database to oracle,
you will need to modify all your code, if you haven’t written your code following factory design pattern.

Factory Method: creation through inheritance. Prototype: creation through delegation.
Prototype doesn't require subclassing, but it does require an "initialize" operation. Factory Method requires subclassing, but doesn't require Initialize.


 */
/**
 * Created by kushaln on 4/29/2018.
 */
public class FactoryMethod {
    public static void main(String[] args) {
        MazeGame mazeGame1=new OrdinaryMazeGame();
        MazeGame mazeGame2=new MagicMazeGame();
    }
}

class Room{
}
class MagicRoom extends Room{
    @Override
    public String toString(){
        return "MagicRoom";
    }
}
class OrdinaryRoom extends Room{
    @Override
    public String toString(){
        return "OrdinaryRoom";
    }
}
abstract class MazeGame{
    Room room;
    public MazeGame(){
        System.out.println("in constructor of MazeGame");
        this.room=makeRoom();
        System.out.println("object room of type:"+ room);
        System.out.println("------------------------------------");
    }
    abstract public Room makeRoom();
}

class OrdinaryMazeGame extends MazeGame{
    @Override
    public Room makeRoom() {
        System.out.println("in make room of Ordinary Maze Game");
        return new OrdinaryRoom();
    }
}
class MagicMazeGame extends MazeGame{
    @Override
    public Room makeRoom() {
        System.out.println("in make room of Magic Maze Game");
        return new MagicRoom();
    }
}