package com.github.assemblyDir.keepInventory;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public final class KeepInventoryPermissions {

    private static final List<Permission> permissions = List.of(
            new Permission(Permissions.COMMAND_SELF.get(), Permission.DEFAULT_PERMISSION),
            new Permission(Permissions.COMMAND_OTHER.get(), Permission.DEFAULT_PERMISSION, Map.of(Permissions.COMMAND_SELF.get(), true))
    );

    public static void register(@NotNull JavaPlugin instance) {
        for (Permission permission : permissions) instance.getServer().getPluginManager().addPermission(permission);
    }

    enum Permissions {
        COMMAND_SELF("keepinventory.command.self"),
        COMMAND_OTHER("keepinventory.command.other");

        private final String permission;

        Permissions(String permission) {
            this.permission = permission;
        }

        public String get() {
            return permission;
        }
    }

}
