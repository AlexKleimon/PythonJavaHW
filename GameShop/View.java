package GameShop;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    protected Scanner sc = new Scanner(System.in);

    public String getName(String title) {
        System.out.printf("%s: ", title);
        return sc.nextLine();
    }

    public int getIdFreq(String title) {
        System.out.printf("%s: ", title);
        int value;
        if (sc.hasNextInt()) {
            value = sc.nextInt();
            sc.nextLine();
        } else {
            System.out.println("Ошибка!Ведите целое число!");
            sc.nextLine();
            value = getIdFreq(title);
        }
        return value;
    }

    public void outToys(ArrayList<Toy> toys) {
        int count = 1;
        System.out.println("Список возможных(или полученных) наград: ");
        for (Toy element : toys) {
            System.out.printf("Награда %d: id: %s, name: %s, freq: %d\n", count++, element.getId(), element.getName(),
                    element.getFreq());
        }
    }
}
