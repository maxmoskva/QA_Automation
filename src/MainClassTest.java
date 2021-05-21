import org.junit.Test;

public class MainClassTest extends MainClass{
    public String testGetLocalNumber()
    {
        int a = this.getLocalNumber();
        if (a==14){
            return "Right is it 14";
        } else {
            return "Wrong is it not 14";
        }
    }

    public String testGetClassNumber()
    {
        int b = this.getClassNumber();
        if (b>45){
            return "Right is it biggest 45";
        } else {
            return "Wrong is it not biggest 45";
        }
    }
}
