import Website.Entities.CreditCard;
import org.junit.Assert;
import org.junit.jupiter.api.Test; //Note that import org.junit.Test; will not work

public class TestCardInfo {
    @Test
    public void testCardInfo(){
        CreditCard ci = new CreditCard("1234567812345678","123","12-34-56","12345678");
        Assert.assertEquals(ci.getCensoredCardNumber(),"123456781234xxxx");
    }
}
