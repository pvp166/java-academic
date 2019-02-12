/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slot.machine;

import java.util.Scanner;

/**
 *
 * @author Pham Van Phuc Id 000761144
 */
public class PlayerScreen {

    public static void main(String[] args) {
        /**
         * set the the money for each machine *
         */
        SlotMachine machine1 = new SlotMachine(0.5);

        SlotMachine machine2 = new SlotMachine(2);

        Scanner input = new Scanner(System.in);
        boolean exit = false;
        //The menu 
        while (exit == false) {
            System.out.println("Select an option : \n"
                    + "[a] = Play with the Slot Machine 1 \n"
                    + "[s] = Play with the Slot Machine 2 \n"
                    + "[d] = Show the balance of Slot Machine 1 \n"
                    + "[f] = Show the balance of Slot Machine 2 \n"
                    + "[z] = Add 1 quarters to the Slot Machine 1\n"
                    + "[c] = Add 1 quarters to the Slot Machine 2 \n"
                    + "[x] = Exit the program \n"
                    + "Enter Option : ");
            String option = input.next();
            switch (option) {
                case "a":
                    /**
                     * First I check the balance of the machine whether it have
                     * more than 0 dollar or not Then I get random numbers and
                     * compare them to the list of fruit. Then I print the
                     * fruits that player gets. After that I check winning
                     * condition and print
                     */
                    if (machine1.getBalance() > 0) {
                        machine1.startMachine();
                        machine1.spinningWheel();
                        System.out.println("The machine showing: ");
                        machine1.fruitResult(machine1.getFruit1());
                        machine1.fruitResult(machine1.getFruit2());
                        machine1.fruitResult(machine1.getFruit3());
                        machine1.addMoneyForWinner();
                    } else {
                        System.out.println("Please add more quaters into the "
                                + "machine ");
                    }
                    break;

                case "s":
                    /**
                     * It is the same as case "a"
                     */
                    if (machine2.getBalance() > 0) {
                        machine2.startMachine();
                        machine2.spinningWheel();
                        System.out.println("The machine showing: ");
                        machine2.fruitResult(machine2.getFruit1());
                        machine2.fruitResult(machine2.getFruit2());
                        machine2.fruitResult(machine2.getFruit3());
                        machine2.addMoneyForWinner();
                    } else {
                        System.out.println(" Please add more quaters into the "
                                + "machine ");
                    }
                    break;
                case "d":
                    // check balance in machine 1
                    System.out.println(machine1.toString());
                    break;
                case "f":
                    // check balance in machine 2
                    System.out.println(machine2.toString());
                    break;
                case "z":
                    // put 1 quaters to machine 1
                    machine1.putMoreMoney();
                    break;
                case "c":
                    // put 1 quaters to machine 2
                    machine2.putMoreMoney();
                    break;
                case "x":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option - please try again");
                    break;

            }
        }
    }

}
