package TrenTestTinkoff;

import java.util.Scanner;

/**
 * Костя подключен к мобильному оператору «Мобайл». Абонентская плата Кости составляет
 * A рублей в месяц. За эту стоимость Костя получает ﻿
 * �
 * B﻿ мегабайт интернет-трафика. Если Костя выйдет за лимит трафика, то каждый следующий мегабайт будет стоить ему ﻿
 * �
 * C﻿ рублей.
 *
 * Костя планирует потратить ﻿
 * �
 * D﻿ мегабайт интернет-трафика в следующий месяц. Помогите ему сосчитать, во сколько рублей ему обойдется интернет.
 */

public class Мобайл {

    public static void main(String[] args) {
        new Мобайл().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int D = scanner.nextInt();
        if(D - B > 1) {
            System.out.println(A + (D - B) * C);
        } else {
            System.out.println(A);
        }
    }
}
