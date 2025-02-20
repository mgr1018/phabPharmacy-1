import Website.Entities.Email;
import org.junit.Assert;
import org.junit.jupiter.api.Test; //Note that import org.junit.Test; will not work

public class TestEmailValidation {
    @Test
    public void testEmail(){
        // INVALID ENTRIES //
        //invalid character i.e. not '.' , '_' , '-' or any alphanumeric characters
        Email e = new Email("te(st@gmail.com");
        Email ea = new Email("te*st@gmail.com");
        Assert.assertEquals(e.validEmail(),false);
        Assert.assertEquals(ea.validEmail(),false);

        //consecutive special character i.e. '..' , '__' or '--'
        Email e1 = new Email("te..st@gmail.com");
        Email e1a = new Email("te__st@gmail.com");
        Email e1b = new Email("te--st@gmail.com");
        Assert.assertEquals(e1.validEmail(),false);
        Assert.assertEquals(e1a.validEmail(),false);
        Assert.assertEquals(e1b.validEmail(),false);

        //starting with a non alphanumeric character
        Email e2 = new Email("-test@gmail.com"); //special char
        Email e2a = new Email("%test@gmail.com"); //invalid char
        Assert.assertEquals(e2.validEmail(),false);
        Assert.assertEquals(e2a.validEmail(),false);

        //too few characters
        Email e3 = new Email("@gmail.com"); //0
        Email e3a = new Email("t@gmail.com"); //1
        Assert.assertEquals(e3.validEmail(),false);
        Assert.assertEquals(e3a.validEmail(),false);

        //extra @
        Email e4 = new Email("test@@gmail.com");
        Assert.assertEquals(e4.validEmail(),false);
        //too many characters
        Email e5 = new Email("testtesttesttesttesttesttesttesttesttesttesttest@googlemail.co.uk"); //65 char
        Assert.assertEquals(e5.validEmail(),false);

        // VALID ENTRIES //
        Email e6 = new Email("testtesttesttesttesttesttesttesttesttesttesttes@googlemail.co.uk"); //64 char
        Assert.assertEquals(e6.validEmail(),true);
    }
}
