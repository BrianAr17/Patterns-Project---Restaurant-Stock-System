package Products;

import java.time.LocalDateTime;

public class NonPerishableClass extends Product {
    private static LocalDateTime bestBeforeDate;

    public static void setBestBeforeDate(LocalDateTime bestBeforeDate) {
        NonPerishableClass.bestBeforeDate = bestBeforeDate;
    }

    public static LocalDateTime getBestBeforeDate() {
        return bestBeforeDate;
    }
}
