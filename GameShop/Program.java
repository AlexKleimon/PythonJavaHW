package GameShop;

import GameShop.Model.PlayedToys;

public class Program {
    public static void main(String[] args) throws Exception {
        Presenter p = new Presenter(new PlayedToys(), new View());
        p.buttonClick();
    }

}
