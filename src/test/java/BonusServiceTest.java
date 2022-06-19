import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {
    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNoRegisteredAndUnderLimit_01() {
        BonusService service = new BonusService();
        long amount = 1_000;
        boolean registered = false;
        long expected = 10;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForNoRegisteredAndBorderLimit_02() {
        BonusService service = new BonusService();
        long amount = 50_000;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForNoRegisteredAndBorderToLimit_03() {
        BonusService service = new BonusService();
        long amount = 49_999;
        boolean registered = false;
        long expected = 499;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForNoRegisteredAndBorderAfterLimit_04() {
        BonusService service = new BonusService();
        long amount = 50_001;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndBorderToLimit_05() {
        BonusService service = new BonusService();
        long amount = 16_666;
        boolean registered = true;
        long expected = 499;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateForRegisteredAndBorderAfterLimit_06() {
        BonusService service = new BonusService();
        long amount = 16_667;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

}
