package exercise;

class App {

    public static void main(String[] args) {
        // BEGIN

        SafetyList sl = new SafetyList();

        ListThread listThread01 = new ListThread(sl);
        ListThread listThread02 = new ListThread(sl);

        listThread01.start();
        listThread02.start();

        try {
            listThread01.join();
            listThread02.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sl.getSize());

        // END
    }
}

