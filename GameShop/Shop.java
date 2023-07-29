package GameShop;

import java.util.ArrayList;

public class Shop implements addToy {
    private final ArrayList<Toy> toys = new ArrayList<>();

    @Override
    public void addToys(Toy toy) {
        toys.add(toy);
    }

    public void delToy(int id) {
        toys.removeIf(element -> element.getId() == id);
    }

    public void setFreq(int freq, int id) {
        for (Toy element : toys) {
            if (element.getId() == id) {
                element.setFreq(freq);
            }
        }
        System.out.println("Вес игрушки успешно изменен.");
    }

    public ArrayList<Toy> getToys() {
        return toys;
    }
}
