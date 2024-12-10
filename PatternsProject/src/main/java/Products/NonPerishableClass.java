package Products;

import java.time.LocalDateTime;

public class NonPerishableClass extends Product {
    private LocalDateTime bestBeforeDate;

    public void setBestBeforeDate(LocalDateTime bestBeforeDate) {
        this.bestBeforeDate = bestBeforeDate;
    }

    public LocalDateTime getBestBeforeDate() {
        return bestBeforeDate;
    }
}
