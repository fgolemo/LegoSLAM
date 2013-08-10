package org.meicogsci.legobot1;

import org.meicogsci.legobot1.map.Map;
import org.meicogsci.legobot1.map.MapForm;

public final class BotSingleton {

    private static final BotSingleton INSTANCE = new BotSingleton();

    private BotSingleton() {
    }

    public static BotSingleton getInstance() {
        return INSTANCE;
    }
    public History history = new History();
    public String nextAction = "";
    public Map map = new Map();
    public MapForm mapForm;
}