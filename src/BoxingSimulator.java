import java.util.Random;
public class BoxingSimulator {
    public static void main(String[] args) {
        Boxer boxer1 = new Boxer("Ali", 100, 20);
        Boxer boxer2 = new Boxer("Mike", 100, 25);

        // Randomly decide who starts first
        Random random = new Random();
        boolean isFirstBoxerTurn = random.nextBoolean();

        System.out.println("Boks maçı başlıyor!");
        System.out.println(boxer1.getName() + " vs. " + boxer2.getName());

        while (boxer1.isAlive() && boxer2.isAlive()) {
            if (isFirstBoxerTurn) {
                System.out.println(boxer1.getName() + " saldırıyor...");
                boxer2.takeDamage(boxer1.getDamage());
                System.out.println(boxer2.getName() + " hasar aldı. Sağlık durumu: " + boxer2.getHealth());
            } else {
                System.out.println(boxer2.getName() + " saldırıyor...");
                boxer1.takeDamage(boxer2.getDamage());
                System.out.println(boxer1.getName() + " hasar aldı. Sağlık durumu: " + boxer1.getHealth());
            }

            isFirstBoxerTurn = !isFirstBoxerTurn;
        }

        if (boxer1.isAlive()) {
            System.out.println(boxer1.getName() + " kazandı!");
        } else {
            System.out.println(boxer2.getName() + " kazandı!");
        }
    }
}