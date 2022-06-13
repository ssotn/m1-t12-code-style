import java.util.Scanner; // С импортом все хорошо

public class DepositCalculator {

    double calculateComplexPercent( double a, double y, int d ) { // Лишние пробелы после открытия скобки и перед закрытием скобки. 
       double pay = a * Math.pow((1 + y / 12), 12 * d); // Лучше не называть переменные одной буквой, а придумать им содержательное название
       return round(pay,2);
    }

    double calculateSimplePercent(double doubleAmount, double double_year_rate, int deposit_period) { // Переменные необходимо переименовать в соответствии с lowerСamelCase, вместо нижнего подчеркиваня заглавная первая буква слова
         return round(doubleAmount + doubleAmount * double_year_rate * deposit_period, 2); // в названии переменных не нужно указывать их тип (double)
    }

    double round(double value, int places) {
       double ScaLe= Math.pow(10, places); // не хватает пробела перед знаком =
       return Math.round(value * ScaLe) / ScaLe; // переменную ScaLe лучше переименовать в scale, верхний регистр здесь не нужен
    }

    void result() { // названия методов лучше начинать с глагола, например calculateResult
        int period, 
              action; // лучше для каждой переменной указывать тип при объявлении: int period; (новая строка) int action;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println( "Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:"); // Лишник пробел после открытия скобки
        action = scanner.nextInt();
        double out = 0; // можно сделать более наглядное название переменной: totalAmount или resultOfDepozit
        if (action == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) { // С отступами и разделением пустыми строками все отлично
        new DepositCalculator().result(); 
    }
}
