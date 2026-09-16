public class UnitTest {
    public static void main(String[] args){

        ValidationTest();

        SoundTest();
    }

    public static void ValidationTest(){
        System.out.println("Test 1: testing if data is valid");
        Monkey monkey = new Monkey("", 5, "Brown", 10.0, 5);

        if (!monkey.IsValid()) {
            System.out.println("Validation has fired");
        } else {
            System.out.println("Validation was not fired");
        }
    }

    public static void SoundTest(){
        System.out.println("Test 1: testing if data is valid");
        Spider spider = new Spider("peg", 1, "Black", 2.0, 20);

        if (spider.makeSound().contains("Hiss")) {
            System.out.println("Sound matches spider [makeSound] function");
        } else {
            System.out.println("Sound does not match spider [makeSound] function");
        }
    }
}
