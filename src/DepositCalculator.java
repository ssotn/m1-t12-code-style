import java.util.Scanner;//убрали лишние иморты, огонь!

public class DepositCalculator {
    double calculateComplexPercent(double amount, double percentValue, int depositPeriod) {//с пробелами вроде всё ок
        double profit = amount * Math.pow((1 + percentValue / 12), 12 * depositPeriod);
        return round(profit, 2);
    }

    double calculateSimplePercent(double amount, double percentValue, int depositPeriod) {//с пустыми строчками между методами тоже
        return round(amount + amount * percentValue * depositPeriod, 2);
    }

    double round(double amountWithProfit, int numberOfPlaces) {
        double ScaLe = Math.pow(10, numberOfPlaces);
        return Math.round(amountWithProfit * ScaLe) / ScaLe;
    }

    void calculateDepositProfit() {//и названия методов, переменныч значимые
        int depositPeriod;
        int userAction;
        double amountWithProfit = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        userAction = scanner.nextInt();

        if (userAction == 1) {
            amountWithProfit = calculateSimplePercent(amount, 0.06, depositPeriod);
        } else if (userAction == 2) {
            amountWithProfit = calculateComplexPercent(amount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в "
                + amountWithProfit);
    }

    public static void main(String[] args) {//не вижу недочётов. Огонь!
        new DepositCalculator().calculateDepositProfit();
    }
}
