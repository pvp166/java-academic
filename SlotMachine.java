/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slot.machine;

import java.util.Random;

/**
 *
 * @author VanPhuc Pham. Student: 000761144.
 */
public class SlotMachine {

    private double money; // The money that I will add for the winners
    private int fruit1;   // Get the number of random fruit 1
    private int fruit2;   // Get the number of random fruit 2
    private int fruit3;   // Get the number of random fruit 3
    private double balance = 0; // User's wallet
    private String nameOfFruit; //print out the name's fruit that player have

    public int getFruit1() {
        return fruit1;
    }

    public int getFruit2() {
        return fruit2;
    }

    public int getFruit3() {
        return fruit3;
    }

    public double getBalance() {
        return balance;
    }

    public SlotMachine(double money) {
        this.money = money;
    }

    // decrease 0.25 dollar to start the machine
    public double startMachine() {
        return balance -= 0.25;
    }

    // get random number to decide which kind of fruit.
    public void spinningWheel() {
        fruit1 = (int) (Math.random() * 7 + 1);
        fruit2 = (int) (Math.random() * 7 + 1);
        fruit3 = (int) (Math.random() * 7 + 1);
    }

    /**
     * get the name of fruit that player will have depends on the random number
     * from spinningWheel() method *
     */
    public String fruitResult(int item) {
        switch (item) {
            case 1:
                nameOfFruit = "LEMON";
                break;
            case 2:
                nameOfFruit = "GRAPE";
                break;
            case 3:
                nameOfFruit = "ORANGE";
                break;
            case 4:
                nameOfFruit = "WATERMELON";
                break;
            case 5:
                nameOfFruit = "APPLE";
                break;
            case 6:
                nameOfFruit = "PEAR";
                break;
            case 7:
                nameOfFruit = "PEACH";
                break;

        }
        System.out.println(nameOfFruit);
        return nameOfFruit;
    }

    /**
     * add money for winner. The money of winner will receive depends on the
     * number of the same fruits that player have If player get only 2 of 3 the
     * same fruit, they only receive one third money that they receive when they
     * get 3 the same fruit *
     */
    public double addMoneyForWinner() {

        if (fruit1 == fruit2 || fruit2 == fruit3 || fruit1 == fruit3) {
            if (fruit1 == fruit2 && fruit2 == fruit3) // The situation that people win money *3
            {
                balance += (money * 3); // Add money the to the balance
                System.out.println("Congratulation! You've got in 3 items in "
                        + "a row:" + "Your balance "
                        + "gets more " + (money * 3) + " dollars");

            } else {
                balance += (money);
                System.out.println("You've 2 items in a row. Your balance "
                        + "gets more " + (money) + " dollars");
            }

        } else {
            System.out.println("You have won 0.0 dollar");
        }
        return balance; // return the total
    }

    // add more money to player's balance
    public double putMoreMoney() {
        return balance += 0.25;
    }

    // To show the current balance
    public String toString() {
        return String.format("Your current balance is " + balance + " dollars");

    }
}
