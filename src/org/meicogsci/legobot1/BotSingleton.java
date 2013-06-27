package org.meicogsci.legobot1;

public final class BotSingleton {
    private static final BotSingleton INSTANCE = new BotSingleton();
    private BotSingleton() {
    	
    }
    public static BotSingleton getInstance() {
        return INSTANCE;
    }

    public History history = new History();
    public String nextAction = "";
}