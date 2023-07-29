package GameShop;

import java.util.Random;

public class Toy {
    private final int id;
    private String name;
    private int freq = new Random().nextInt(1, 100);

    public Toy(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Integer getFreq() {
        return freq;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }
}
