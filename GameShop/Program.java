package GameShop;

public class Program {
    public static void main(String[] args) throws Exception {
        Presenter p = new Presenter(new PlayedToys(), new View());
        p.buttonClick();
    }

}
