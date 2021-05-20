package com.bridgelabz;

import java.util.Random;

public class SnakeLadder {
    static Random random = new Random();
    public static void main(String[] args) {
        int position_player1 = 0, position_player2 = 0, optionSelect, rollDie = 0, flag = 0, win, dice_count = 0;
        Random random = new Random();
        while (position_player1 != 100 || position_player2 != 100) {
            optionSelect = random.nextInt(3) + 1;
            if (flag == 0) {
                if (optionSelect == 1) {
                    System.out.println("No Play");
                } else if (optionSelect == 2) {
                    System.out.println("Ladder Comes");
                    rollDie = random.nextInt(6) + 1;
                    if (position_player1 + rollDie <= 100)
                        position_player1 += rollDie;
                    flag = 1;
                } else {
                    System.out.println("Snake Comes");
                    rollDie = random.nextInt(6) + 1;
                    if ((position_player1 - rollDie) < 0)
                        position_player1 = 0;
                    else
                        position_player1 -= rollDie;
                }
                System.out.println("Die rolled as " + rollDie);
                System.out.println("1st Player Position Is " + position_player1);
                dice_count++;
                System.out.println("Dice rolled Count:" + dice_count);
                win = WinCheck(position_player1);
                if (win == 1) {
                    System.out.print("Player 1 Wins");
                    break;
                } else {
                    continue;
                }
            } else {
                if (optionSelect == 1) {
                    System.out.println("No Play");
                } else if (optionSelect == 2) {
                    System.out.println("Ladder Comes");
                    rollDie = random.nextInt(6) + 1;
                    if (position_player2 + rollDie <= 100)
                        position_player2 += rollDie;
                    flag = 0;
                } else {
                    System.out.println("Snake Comes");
                    rollDie = random.nextInt(6) + 1;
                    if ((position_player2 - rollDie) < 0)
                        position_player2 = 0;
                    else
                        position_player2 -= rollDie;
                }
                System.out.println("Dies turn as " + rollDie);
                System.out.println("2nd Player Position Is " + position_player2);
                dice_count++;
                System.out.println("Dice rolled Count:" + dice_count);
                win = WinCheck(position_player2);
                if (win == 1) {
                    System.out.print("Player 2 Wins");
                    break;
                }
            }
            if (flag == 0)
                flag = 1;
            else
                flag = 0;
        }
    }
    public static int WinCheck(int position) {
        if (position == 100) {
            return 1;
        } else {
            return 0;
        }
    }
}
