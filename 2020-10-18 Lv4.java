import java.util.Scanner;

public class Lv4 {
    public static void main(String[] args) {
        //Setup the dishes.
        Dishes[] dishes = new Dishes[5];
        dishes[0] = new Dishes("辣子鸡丁", 38, 1);
        dishes[1] = new Dishes("水煮肉片", 22, 2);
        dishes[2] = new Dishes("糖醋里脊", 18, 3);
        dishes[3] = new Dishes("干锅牛肉", 38, 4);
        dishes[4] = new Dishes("干锅排骨", 29, 5);

        //welcome
        Restaurant.welcome(dishes);
        Restaurant.order(dishes, 2, Restaurant.order(dishes, 1, 0));
        Restaurant.payment();
    }
}

class Dishes {
    private String name;
    private int price;
    private int index;
    private int wanted;

    public Dishes(String aName, int aPrice, int aIndex) {
        this.name = aName;
        this.price = aPrice;
        this.index = aIndex;
        wanted = 0;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setWanted() {
        wanted = 1;
    }

    public int getWanted() {
        return wanted;
    }
}

class Restaurant {
    private String restaurantName;

    public Restaurant() {;}
    public Restaurant(String aName) {
        this.restaurantName = aName;
    }

    public static void welcome(Dishes[] aDishes) {
        System.out.println("欢迎来到国民饭店,这是今天的菜单：");

    }

    public static int order(Dishes[] aDishes, int round, int totalPrice) {
        Scanner in = new Scanner(System.in);

        if (round == 2) {
            System.out.println("还有需要点的菜么？");
        }
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + "." + aDishes[i].getName() + " " + aDishes[i].getPrice() + "元");
        }
        System.out.println("请输入想要点的菜的序号（空格键分割）");

        String num0 = in.nextLine();
        char[] num1 = num0.toCharArray();
        for (int i = 0; i < num1.length; i++) {
            if (num1[i] >= '1' && num1[i] <= '5') {
                aDishes[num1[i] -'1'].setWanted();
                totalPrice += aDishes[num1[i] - '1'].getPrice();
            }
        }

        System.out.println("你一共选择了：");
        for (int i = 0; i < 5; i++) {
            if (aDishes[i].getWanted() == 1) {
                System.out.println(aDishes[i].getName() + " " + aDishes[i].getPrice() + "元");
            }
        }
        System.out.println("共计" + totalPrice + "元");

        return totalPrice;
    }

    public static void payment() {
        System.out.println("请选择支付方式");
        System.out.println("1.支付宝");
        System.out.println("2.微信");
        System.out.println("3.人脸识别");

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if (num == 1 || num == 2)
            System.out.println("请出示付款码....");
    }
}
