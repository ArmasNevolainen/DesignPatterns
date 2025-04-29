package org.example;

public class WildernessMap extends Map{


    public WildernessMap (int rows, int columns) {
            super(rows,columns);
        }
        @Override
        protected Tile createTile() {
            int tileType = random.nextInt(3);
            return switch (tileType) {
                case 0 -> new Swamp();
                case 1 -> new Water();
                case 2 -> new Forest();
                default -> null;
            };

        }
}
