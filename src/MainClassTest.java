import org.junit.Test;

public class MainClassTest extends MainClass{
    @Test
    public void testGetLocalNumber()
    {
        int a = this.getLocalNumber();
        if (a==14){
            System.out.println("Right is it 14");
        } else {
            System.out.println("Wrong it it not 14");
        }
    }
}
