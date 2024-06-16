package exercise;

// BEGIN
class ListThread extends Thread {
    SafetyList sl;

    public ListThread(SafetyList sl) {
        this.sl = sl;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sl.add(i);
        }
    }
}
// END


