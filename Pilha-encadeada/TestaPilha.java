public class TestaPilha{
    public static void main(String [] args) throws Epilhavazia{
        Pilhae p1 = new Pilhae();
        System.out.println(p1.isEmpty());
        p1.push(2);
        p1.push(3);
        System.out.println(p1.top());
        System.out.println(p1.pop());
        System.out.println(p1.top());
        System.out.println(p1.isEmpty());
        
    }
}
