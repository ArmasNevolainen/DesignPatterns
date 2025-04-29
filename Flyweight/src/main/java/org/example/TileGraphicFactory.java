package org.example;

import javafx.scene.image.Image;
import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {
    private static final Map<String, Image> tileImages = new HashMap<>();

    public static Image getImage(String tileType) {
        if (tileImages.containsKey(tileType)) {
            return tileImages.get(tileType);
        }

        String imagePath = switch (tileType) {
            case "Building" -> "/images/building.png";
            case "Forest" -> "/images/forest.png";
            case "Road" -> "/images/road.png";
            case "Swamp" -> "/images/swamp.png";
            case "Water" -> "/images/water.png";
            default -> "/images/default.png";
        };

        Image image = new Image(TileGraphicFactory.class.getResourceAsStream(imagePath));
        tileImages.put(tileType, image);
        return image;
    }
}
