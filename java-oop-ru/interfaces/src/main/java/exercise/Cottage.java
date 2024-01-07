package exercise;

// BEGIN
class Cottage implements Home {
    private Double aria;
    private int floor;

    public Cottage(double aria, int floor) {
        this.aria = aria;
        this.floor = floor;
    }

//    public Cottage(int aria, int floor) {
//        this.aria = Double.valueOf(aria);
//        this.floor = floor;
//    }

    @Override
    public Double getAria() {
        return aria;
    }

    @Override
    public int compareTo(Home h) {
        return aria.compareTo(h.getAria());
    }

    @Override
    public String toString() {
        return floor + " этажный коттедж площадью " + aria + " метров";
    }
}
// END
