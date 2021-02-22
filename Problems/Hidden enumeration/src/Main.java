public class Main {

    public static void main(String[] args) {
    // write your program here
        int count = 0;
        String res = "STAR";
        for (Secret secret: Secret.values()
             ) {
            if (secret.name().equals(res) || secret.name().substring(0, 4).equals(res)) {
                count++;
            }
        }
        System.out.println(count);
    }
}

/* sample enum for inspiration
   enum Secret {
    STAR, CRASH, START
}
*/