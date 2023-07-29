package GameShop;

import java.io.FileWriter;
import java.util.*;

public class PlayedToys extends Shop {
    private final ArrayList<Toy> award = new ArrayList<>();

    public void addAward(Toy toy) {
        award.add(toy);
    }

    public void played() {
        Random rnd = new Random();
        sortToysBackFreq();
        ArrayList<Integer> idToys = new ArrayList<>(); // т.к. удаляем игрушку по id, создаем массив id игрушек
        ArrayList<Integer> freqToys = new ArrayList<>();
        int sum = sumFreq(idToys, freqToys);
        int rndNumber = rnd.nextInt(1, sum);
        randomOnlyToys(idToys, freqToys, rndNumber);
        sortToysUpId(); // сортируем по id (для вывода на консоль)
    }

    public ArrayList<Toy> getAward() {
        return award;
    }

    public void writeAward() throws Exception {
        FileWriter writer = new FileWriter("GameShop/Award.txt", false);
        int count = 1;
        for (Toy toy : award) {
            String text = String.format("Награда %d: id: %s, name: %s, freq: %d\n", count++, toy.getId(), toy.getName(),
                    toy.getFreq());
            writer.write(text);
        }
        writer.close();
    }

    private void sortToysBackFreq() {
        getToys().sort(Comparator.comparing(Toy::getFreq, Comparator.reverseOrder())); // соритруем массив по убыванию
                                                                                       // весов игрушек
    }

    private void sortToysUpId() {
        getToys().sort(Comparator.comparing(Toy::getId));
    }

    // Суммирует веса игрушек и заполняет массивы idToys и freqToys
    private int sumFreq(ArrayList<Integer> idToys, ArrayList<Integer> freqToys) {
        int sum = 0;
        for (Toy element : getToys()) {
            sum += element.getFreq(); // сумма весов игрушек
            idToys.add(element.getId());
            freqToys.add(sum);
        }
        return sum;
    }

    /*
     * При выборе игрушки используется следующая логика:
     * Например: 1 игрушка вес 30, вторая игрушка вес 100 и третяя игрушка вес 5
     * 1) Суммируем веса(от большего к меньшему): получается 100 + 30 + 5 = 135
     * 2) у нас имеется три диапазона: от 0 до 100, от 101 до 130 и от 131 до 135
     * 3) Генерим случайное число в диапазоне от 0 до 135
     * 4) Допустим выпало число 120, оно входит в диапазон от 101 до 130,
     * следовательно выпадит вторая игрушка.
     */
    private void randomOnlyToys(ArrayList<Integer> idToys, ArrayList<Integer> freqToys, int rndNumber) {
        int sizeToys = idToys.size();
        // Если игрушка одна
        if (sizeToys == 1) {
            addAward(getToys().get(0));
            System.out.printf("Поздравляю Вы выйграли: %s.\n", getToys().get(0).getName());
            delToy(idToys.get(0));
        } else {
            for (int i = 0; i < sizeToys - 1; i++) {
                // смотрим в какой диапазон весов попало случайное число
                if (rndNumber > freqToys.get(i) && rndNumber <= freqToys.get(i + 1)) {
                    System.out.printf("Выпало число: %d которое находится в диапазоне от %d до %d включительно.\n",
                            rndNumber,
                            freqToys.get(i) + 1, freqToys.get(i + 1));
                    addAward(getToys().get(i + 1));
                    System.out.printf("Поздравляю Вы выйграли: %s.\n", getToys().get(i + 1).getName());
                    delToy(idToys.get(i + 1));
                    break;
                } else if (rndNumber > 0 && rndNumber < freqToys.get(i)) {
                    System.out.printf("Выпало число: %d которое находится в диапазоне от 0 до %d включительно.\n",
                            rndNumber, freqToys.get(i));
                    addAward(getToys().get(i));
                    System.out.printf("Поздравляю Вы выйграли: %s.\n", getToys().get(i).getName());
                    delToy(idToys.get(i));
                    break;
                }
            }
        }
    }
}
