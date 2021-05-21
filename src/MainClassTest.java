import org.junit.Test;

public class MainClassTest extends MainClass{
    public String testGetLocalNumber()
    {
        int a = this.getLocalNumber();
        if (a==14){
            return "Right is it 14";
        } else {
            return "Wrong it it not 14";
        }
    }
}
