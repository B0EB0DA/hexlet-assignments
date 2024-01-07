package exercise;

// BEGIN
class Flat implements Home {
    private Double area;
    private Double balconyArea;
    private Double totalAria;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
        this.totalAria = area + balconyArea;
    }

    @Override
    public Double getAria() {
        return totalAria;
    }

    @Override
    public int compareTo(Home h) {
        return totalAria.compareTo(h.getAria());
    }

    @Override
    public String toString() {
        return "Квартира площадью " + totalAria + " метров на " + floor + " этаже";

    }
}

// END
