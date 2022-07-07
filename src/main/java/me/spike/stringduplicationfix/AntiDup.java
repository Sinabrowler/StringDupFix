package me.spike.stringduplicationfix;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class AntiDup implements Listener {
    int lastDelay;

    @EventHandler
    public void onBreak(BlockFromToEvent e){
        Block block = e.getToBlock();
        if(e.getBlock().getType() != Material.WATER))return;
        if(block.getType().equals(Material.TRIPWIRE)){
            e.setCancelled(true);
            breakLater(block);
        }
    }


    private void breakLater(Block block){
        new BukkitRunnable(){
            @Override
            public void run() {
                if(block.getType().equals(Material.TRIPWIRE)) block.breakNaturally();
            }
        }.runTaskLater(StringDuplicationFix.getInstance(), getRandomDelay());
    }


    private long getRandomDelay() {
        Random ran = new Random();
        int delay = ran.nextInt(5);
        if (delay == getLastDelay() || delay == 0) delay += 1;
        setLastDelay(delay);
        return delay * 5;
    }


    private void setLastDelay(int last){
        this.lastDelay = last;
    }


    private int getLastDelay(){
        return lastDelay;
    }

}
