public class CityMap extends Map {


    public CityMap (int rows, int columns) {
        super(rows,columns);
    }
    @Override
    protected Tile createTile() {
        int tileType = random.nextInt(3);
        return switch (tileType) {
            case 0 -> new Road();
            case 1 -> new Forest();
            case 2 -> new Building();
            default -> null;
        };
    }
}
