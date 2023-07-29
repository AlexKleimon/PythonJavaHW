package GameShop;

public class Presenter {
    protected PlayedToys pt;
    protected View v;

    public Presenter(PlayedToys pt, View v) {
        this.pt = pt;
        this.v = v;
    }

    public void buttonClick() throws Exception {
        boolean flag = true;
        int id = 1;
        while (flag) {
            System.out.println(
                    "Список команд: add - добавить игрушку, play - разыграть игрушки, all - посмотреть список разыгрываемых игрушек,"
                            +
                            " allp - список выйгранных игрушек, fr - сменить частоту выпадения игрушки, exit - для выхода");
            switch (v.getName("Введите команду")) {
                case "add" -> addPlayShop(id++);
                case "all" -> v.outToys(pt.getToys());
                case "allp" -> v.outToys(pt.getAward());
                case "fr" -> pt.setFreq(v.getIdFreq("Введите частоту в %"), v.getIdFreq("Введите id игрушки"));
                case "play" -> {
                    pt.played();
                    pt.writeAward();
                }
                case "exit" -> flag = false;
            }
        }
    }

    private void addPlayShop(int index) {
        pt.addToys(new Toy(v.getName("Введите название игрушки"), index));
    }
}
