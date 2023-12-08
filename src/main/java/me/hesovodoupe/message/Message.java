package me.hesovodoupe.message;

import org.bukkit.plugin.java.JavaPlugin;

public final class Message extends JavaPlugin {
    private static Message instance;

    @Override
    public void onEnable() {

        System.out.println("Plugin has started!");
        this.getLogger().warning("There is a new configuration on version 1.4, to update remove the old config");
        //start plugin and information

        this.getLogger().info("---------------------------------------");
        this.getLogger().info("CustomsMessage 1.4 version - ENABLE");
        this.getLogger().info("---------------------------------------");
        //annoucement console

        instance = this;
        saveDefaultConfig();

        this.getCommand("customsmessage").setExecutor(new reload());
        //commands

        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new LeaveListener(this), this);
        getServer().getPluginManager().registerEvents(new UniqueListener(this), this);
        //register Join and Leave

        new UpdateCheck ( this , 113825 ) . getVersion ( version -> {
            if ( this . getDescription ( ) . getVersion ( ) . equals ( version ) ) {
                getLogger ( ) . info ( "There is not a new update available." ) ;
            } else {
                getLogger ( ) . info ( "There is a new update available." ) ;
                //Update check plugin
            }
        } ) ;
    }

    @Override
    public void onDisable() {
        System.out.println("Plugin has stopped!");
        //disable plugin

        this.getLogger().info("---------------------------------------");
        this.getLogger().info("CustomsMessage 1.4 version - DISABLE");
        this.getLogger().info("---------------------------------------");
        //annoucement console {
    }

    public static Message getInstance() {
        return instance;
    }
}
