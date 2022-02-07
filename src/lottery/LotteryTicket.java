package lottery;

import java.util.Arrays;
import java.util.Random;

public class LotteryTicket {

    private static final int LENGHT = 10;
    private static final int MIN_TICKET_NUMBER = 1;
    private static final int MAX_TICKET_NUMBER = 80;

    public static void main(String[] args) {
        int[] ticket = generateNumbers();
        System.out.println("Liczby to:");
        Arrays.sort(ticket);
        printTicket(ticket);
    }

    public  static  int[] generateNumbers() {
        int[] ticket = new int[LENGHT];

        Random random = new Random();

        for (int i = 0; i < LENGHT; i++) {
            int randomNumber;
            do {
                randomNumber = random.nextInt(MIN_TICKET_NUMBER, MAX_TICKET_NUMBER);
            } while(search(ticket,randomNumber));
            ticket[i] = randomNumber;
        }

        return ticket;
    }

    public  static  void printTicket(int ticket[]) {
        for(int i = 0; i < LENGHT; i++) {
            System.out.print("|" + ticket[i] + "| ");
        }
    }

    /**
     * Does sequential search on array to find a value
     * @param array Array to search through
     * @param numberToSearchFor Value to search for
     * @return true if found, false if not
     */
    public static boolean search(int[] array, int numberToSearchFor) {
        for (int value : array) {
            if(value == numberToSearchFor) {
                return true;
            }
        }
        return false;
    }
}
