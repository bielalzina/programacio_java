
package exercici02;

import java.time.LocalDate;

public class DiesAbansDiesDespres {

    public static void main(String[] args) {

        LocalDate avui = LocalDate.now();

        for (int i = 10; i > 0; i--) {
            System.out.println(avui.plusDays(-i));

        }

        System.out.println("**" + avui);

        for (int i = 1; i < 11; i++) {
            System.out.println(avui.plusDays(i));
        }

    }

}
