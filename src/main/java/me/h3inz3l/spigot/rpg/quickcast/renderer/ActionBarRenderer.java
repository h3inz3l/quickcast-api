package me.h3inz3l.spigot.rpg.quickcast.renderer;

import me.h3inz3l.spigot.rpg.quickcast.QuickcastAPI;
import me.h3inz3l.spigot.rpg.quickcast.QuickcastRenderer;
import me.h3inz3l.spigot.rpg.quickcast.model.MouseKey;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class ActionBarRenderer implements QuickcastRenderer {

    private String color;

    public ActionBarRenderer(QuickcastAPI quickcastAPI) {
        color = quickcastAPI.getQuickcastConfig().getRenderColor();
    }

    @Override
    public void render(Player player, List<MouseKey> mouseKeys) {
        String text = mouseKeys.stream()
                .map(Enum::name)
                .collect(Collectors.joining(" - "));
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(color + text));
    }
}
