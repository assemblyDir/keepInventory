package com.github.assemblyDir.keepInventory.api;

import net.kyori.adventure.text.Component;
import org.bukkit.damage.DamageSource;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KeepInventoryDeathEvent extends PlayerDeathEvent {

    private static final HandlerList HANDLER_LIST = new HandlerList();
    private final boolean keepInventoryState;
    private boolean cancelled;

    public KeepInventoryDeathEvent(@NotNull Player player, @NotNull DamageSource damageSource, @NotNull List<ItemStack> drops, int droppedExp, @Nullable Component deathMessage, boolean showDeathMessages, boolean keepInventoryState) {
        super(player, damageSource, drops, droppedExp, deathMessage, showDeathMessages);
        this.keepInventoryState = keepInventoryState;
    }

    public boolean getKeepInventoryState() {
        return keepInventoryState;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

}
