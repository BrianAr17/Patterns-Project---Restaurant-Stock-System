package Products;

import java.time.LocalDateTime;

public class PerishableClass extends Product {
    private LocalDateTime expirationDate;

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }
}
