package com.example.vania.loveserials.fragments.serial;
 import com.example.vania.loveserials.fragments.serial.SerialContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ivan.hrynchyshyn on 24.07.2017.
 */

public class SerialContent {
    /**
     * An array of sample (dummy) items.
     */
    public static final List<SerialContent.SerialItem> ITEMS = new ArrayList<SerialItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, SerialContent.SerialItem> ITEM_MAP = new HashMap<String, SerialItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(SerialContent.SerialItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static SerialContent.SerialItem createDummyItem(int position) {
        return new SerialContent.SerialItem(String.valueOf(position), "Item " + position, makeDetails(position), "");
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class SerialItem {
        public final String id;
        public final String content;
        public final String details;
        public String imgSrc;

        public SerialItem(String id, String content, String details, String imgSrc) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.imgSrc = imgSrc;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
