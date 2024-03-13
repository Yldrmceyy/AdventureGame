import java.util.Scanner;

public class Player {   // encapsulatıon yapabilmek için prıvate tanımlıyoruz.
    private int damage;
    private int health;
    private int orjinalHealth;
    private int money;
    private String name;
    private String charName;  //karakter name
    public Scanner input = new Scanner(System.in);
    private Inventory inventory;


    public Player(String name) {
        this.name = name;  // oyuncunun adını dısrıdan aldıgın name e eşitliyoruz
        this.inventory = new Inventory(); //player olsutugunda otomatık ıcı bos ınverntroy olussun
    }

    public void selectChar() {
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};  //diziye atıyoruzkarakter nesnelerini
        System.out.println("Karakterler");
        System.out.println("--------------------------------------------------------------------------------");
        for (GameChar gameChar : charList) {
            System.out.println("ID: " + gameChar.getId() +
                    "\t Karakter: " + gameChar.getName() +
                    "\t\t Hasar: " + gameChar.getName() +
                    "\t\t Sağlık: " + gameChar.getHealth() +
                    "\t\t Para: " + gameChar.getMoney());
        }
        System.out.println("--------------------------------------------------------------------------------");
        System.out.print("Lütfen Bir Karakter Seçiniz: ");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        /*System.out.println("Karakter: " + this.getCharName() +
                ", Hasar: " + this.getDamage() +
                ", Sağlık: " + this.getHealth() +
                ", Para: " + this.getMoney());*/

    }


    public void initPlayer(GameChar gameChar) {
        this.setCharName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setOrjinalHealth(gameChar.getHealth());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
    }

    public void printInfo() {  //playerın durumunu bastır
        System.out.println(
                "Silah: " + this.getInventory().getWeapon().getName() +
                        ", Zırh: " + this.getInventory().getArmor().getName() +
                        ", Bloklama: " + this.getInventory().getArmor().getBlock() +
                        ", Hasar: " + this.getTotalDamage() +
                        ", Sağlık: " + this.getHealth() +
                        ", Para: " + this.getMoney());

    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}
