package utility;

public class GenerateID {

    public static String getRandomID() {
        String ID = "";

        for (int i = 0; i < 8; i++) {
            int b = (int) (Math.random() * (122 - 97) + 97);

            ID += (char) b;
        }

        return ID;
    }
}
