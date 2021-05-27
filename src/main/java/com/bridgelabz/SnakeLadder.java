package com.bridgelabz;

public class SnakeLadder {
    //Roll the die
    public static int rollDie()
    {
        int die = (int) (Math.floor(Math.random()*10)%6);
        return die;
    }

    //game play by players
    public static int gamePlay(int position)
    {
        int die;
        int flag = 0;
        die = rollDie();
        System.out.println("Roll the die" + die);
        int option = (int) (Math.floor(Math.random() * 3) + 1);
        flag++;
        switch (option) {
            case 1:
                System.out.println("No Play.");
                break;
            case 2:
                position += die;
                System.out.println("ladder");
                if (position <= 100) {
                    position += die;
                } else if (position > 100) {
                    position = 100;
                }
                break;
            case 3:
                System.out.println("Snake");
                if ((position - die) < 0)
                    position = 0;
                else
                    position -= die;
                break;
            default:
                System.out.println("Wrong choice");
        }
        System.out.println("Dice Rolled:" + flag);
        System.out.println("Position:" + position);
        return position;
    }

    //Two player game
    public static void twoPlayer()
    {
        int player1 = 0;
        int player2 = 0;
        int win = 0;
        while (player1 != 100 || player2 != 100) {
            player1 = gamePlay(player1);
            win = winner(player1);
            if (win == 1) {
                System.out.println("Player 1 wins");
                break;
            }
            player2 = gamePlay(player2);
            win = winner(player2);
            if (win == 1) {
                System.out.println("Player 2 wins");
                break;
            }
        }
    }

    //Check winner
    public static int winner(int win)
    {
        if (win == 100)
            return 1;
        else
            return 0;
    }

    public static void main(String args[]) {
        twoPlayer();
    }
}
