package com.abhilash.codinginterview.threads;

public class PrintSequenceWithThreads {

    /* 
     * Print a1 b2 c3 sequence using two threads
     */
    private static boolean printCharacter = true;
    private static Object lock = new Object();

    private void printCharacters() {
        char[] characters = { 'a', 'b', 'c' };
        for (char c: characters) {
            synchronized(lock) {
                if (printCharacter) {
                    System.out.println(c);
                    printCharacter = false;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void printNumbers() {
        int[] numbers = { 1, 2, 3 };
        for (int num: numbers) {
            synchronized(lock) {
                if (!printCharacter) {
                    System.out.println(num);
                    printCharacter = true;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintSequenceWithThreads sequence = new PrintSequenceWithThreads();
        Thread t1 = new Thread(sequence::printCharacters, "Thread1");
        Thread t2 = new Thread(sequence::printNumbers, "Thread2");
        t1.start();
        t2.start();
    }
}
