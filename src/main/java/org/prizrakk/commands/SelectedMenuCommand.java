package org.prizrakk.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.components.selections.SelectOption;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;
import org.prizrakk.ICommand;

import java.util.List;


public class SelectedMenuCommand implements ICommand {
    @Override
    public String getName() {
        return "start";
    }

    @Override
    public String getDescription() {
        return "Создает что-то и как-то";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        if(event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Тикеты");
            embed.setDescription("Если у вас проблема с хостингом/сервером, обращайтесь!");
            event.replyEmbeds(embed.build())
                    .setActionRow(StringSelectMenu.create("panelhelp").setPlaceholder("Обратитесь в нашу службу поддержки")
                            .addOptions(SelectOption.of("Жалоба на пользователя", "badsupport")
                                    .withDescription("Нажмите сюда чтобы получить помощь")
                                    .withEmoji(Emoji.fromUnicode("\uD83D\uDE21"))
                                    .withDefault(false))
                            .addOptions(SelectOption.of("Помощь с панелью", "panelsupport")
                                    .withDescription("Нажмите сюда чтобы получить помощь")
                                    .withEmoji(Emoji.fromUnicode("\uD83D\uDE21"))
                                    .withDefault(false))
                            .addOptions(SelectOption.of("Помощь с сервером", "serversupport")
                                    .withDescription("Нажмите сюда чтобы получить помощь")
                                    .withEmoji(Emoji.fromUnicode("\uD83D\uDE21"))
                                    .withDefault(false))
                            .addOptions(SelectOption.of("Помощь с лаунчером", "launchersupport")
                                    .withDescription("Нажмите сюда чтобы получить помощь")
                                    .withEmoji(Emoji.fromUnicode("\uD83D\uDE21"))
                                    .withDefault(false))
                            .addOptions(SelectOption.of("Обновление тарифа", "Tarifsupport")
                                    .withDescription("Нажмите сюда чтобы подать заявку на обновление тарифа")
                                    .withEmoji(Emoji.fromUnicode("\uD83D\uDE21"))
                                    .withDefault(false))
                            .build()).queue();
        } else {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("ERROR 403");
            embed.setDescription("Ошибка доступа пожалуйста обратитесь к администратору");
            embed.setThumbnail("https://i.gifer.com/76cI.gif");
            event.replyEmbeds(embed.build()).queue();
        }
    }
}
