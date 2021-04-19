package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run(){
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move(){
        for (Horse horse: getHorses()) {
            horse.move();
        }
    }

    public void print(){
        for (Horse horse: getHorses()) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
        Horse winner = null;
        double maxDistance = 0;

        for (Horse horse : getHorses()) {
            if (horse.getDistance() > maxDistance){
                maxDistance = horse.getDistance();
            }
        }

        for (Horse horse : getHorses()) {
            if (horse.getDistance() == maxDistance) {
                winner = horse;
                break;
            }
        }

        return winner;
    }

    public void printWinner(){
        System.out.println(" Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {
        List <Horse> horseList = new ArrayList<>();

        Horse horse1 = new Horse("Пегас", 3,0);
        Horse horse2 = new Horse("Сивка-Бурка", 3,0);
        Horse horse3 = new Horse("Буцефал", 3,0);

        horseList.add(horse1);
        horseList.add(horse2);
        horseList.add(horse3);

        game = new Hippodrome(horseList);

        game.run();
        game.printWinner();

    }
}
