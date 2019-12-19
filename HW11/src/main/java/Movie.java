public class Movie extends NamedObject {
    public static final int CHILDRENS = 0;
    public static final int NEW_RELEASE = 1;
    public static final int REGULAR = 2;

    private int priceCategory;

    public static Movie get(String name) {
        return (Movie) Registry.get("Movies", name);
    }

    public Movie(String name, int priceCategory) {
        super(name);
        this.priceCategory = priceCategory;
    }

    public int getPriceCategory() {
        return priceCategory;
    }

    public void register() {
        Registry.add("Movies", this);
    }
}
