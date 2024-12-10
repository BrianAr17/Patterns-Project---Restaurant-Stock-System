package Products;

import java.time.LocalDateTime;

public class PerishableClass extends Product {
    private static LocalDateTime expirationDate;

    public PerishableClass() {
    }

    public static void setExpirationDate(LocalDateTime expirationDate) {
        PerishableClass.expirationDate = expirationDate;
    }

    public static LocalDateTime getExpirationDate() {
        return expirationDate;
    }
}
