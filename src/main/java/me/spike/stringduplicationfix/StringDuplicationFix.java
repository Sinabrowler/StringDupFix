package me.spike.stringduplicationfix;

import org.bukkit.plugin.java.JavaPlugin;

public final class StringDuplicationFix extends JavaPlugin {

    private static StringDuplicationFix instance;
    public static StringDuplicationFix getInstance(){
        return instance;
    }
    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new AntiDup(), this);

    }
}
