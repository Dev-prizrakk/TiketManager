package org.prizrakk.commands.events;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;

public class SelectedMenu extends ListenerAdapter {
    @Override
    public void onStringSelectInteraction(StringSelectInteractionEvent event) {
        if (event.getComponentId().equals("panelhelp")) {
            //event.reply("You chose " + event.getValues().get(0)).queue();
            if(event.getValues().get(0).equals("badsupport")) {
                TextInput badNakogo = TextInput.create("badNakogo", "На кого вы хотите подать жалобу?", TextInputStyle.SHORT)
                        .setPlaceholder("Персонал / Пользователь / Сервер")
                        .setMinLength(5)
                        .setMaxLength(100)
                        .setRequired(true)
                        .build();
                TextInput badUser = TextInput.create("badUser", "Дискорд ник и тег нарушителя", TextInputStyle.PARAGRAPH)
                        .setPlaceholder("bad-user228#0001")
                        .setMinLength(3)
                        .setMaxLength(1000)
                        .setRequired(true)
                        .build();
                TextInput badIp = TextInput.create("badIp", "IP сервера (если в 1 выбрали сервер)", TextInputStyle.PARAGRAPH)
                        .setPlaceholder("IP сервера (пример 127.0.0.1:25565)")
                        .setMinLength(3)
                        .setMaxLength(40)
                        .setRequired(true)
                        .build();
                TextInput badEmail = TextInput.create("badEmail", "Ваш EMAIL", TextInputStyle.PARAGRAPH)
                        .setPlaceholder("example@gmail.com")
                        .setMinLength(3)
                        .setMaxLength(40)
                        .setRequired(true)
                        .build();
                TextInput badDocs = TextInput.create("badDocs", "Доказательства", TextInputStyle.PARAGRAPH)
                        .setPlaceholder("(Отправьте в тикет скриншот или видео)")
                        .setMinLength(3)
                        .setMaxLength(40)
                        .setRequired(true)
                        .build();

                Modal modal = Modal.create("bad", "Заполните информацию о злоупотреблении")
                        .addActionRows(ActionRow.of(badNakogo), ActionRow.of(badUser), ActionRow.of(badIp), ActionRow.of(badEmail), ActionRow.of(badDocs))
                        .build();
                event.replyModal(modal).queue();
            }
            if(event.getValues().get(0).equals("panelsupport")) {
                TextInput panelProblem = TextInput.create("panelProblem", "Кратко опишите проблему", TextInputStyle.SHORT)
                        .setPlaceholder("Доступ / Ошибка")
                        .setMinLength(5)
                        .setMaxLength(100)
                        .setRequired(true)
                        .build();
                TextInput panelDocs = TextInput.create("panelDocs", "Опишите проблему", TextInputStyle.PARAGRAPH)
                        .setPlaceholder("Опишите проблему которая у вас возникла это поможет нам более эфективно вам помочь")
                        .setMinLength(3)
                        .setMaxLength(1000)
                        .setRequired(true)
                        .build();
                TextInput panelTime = TextInput.create("panelTime", "Укажите время в которое произошла ошибка.", TextInputStyle.PARAGRAPH)
                        .setPlaceholder("Например: 17:56")
                        .setMinLength(3)
                        .setMaxLength(40)
                        .setRequired(true)
                        .build();
                TextInput panelEmail = TextInput.create("panelEmail", "Укажите ваш EMAIL", TextInputStyle.PARAGRAPH)
                        .setPlaceholder("example@gmail.com")
                        .setMinLength(3)
                        .setMaxLength(40)
                        .setRequired(true)
                        .build();

                Modal modal = Modal.create("panel", "Предоставьте нам информацию")
                        .addActionRows(ActionRow.of(panelProblem), ActionRow.of(panelDocs), ActionRow.of(panelTime), ActionRow.of(panelEmail))
                        .build();
                event.replyModal(modal).queue();
            }
            if(event.getValues().get(0).equals("launchersupport")) {
                TextInput launcherVersion = TextInput.create("launcherVersion", "Ваш ланучсервер и версия", TextInputStyle.SHORT)
                        .setPlaceholder("Например: GravitLauncher v5.4.1")
                        .setMinLength(5)
                        .setMaxLength(100)
                        .setRequired(true)
                        .build();
                TextInput launcherDocs = TextInput.create("launcherDocs", "Опишите проблему", TextInputStyle.PARAGRAPH)
                        .setPlaceholder("Опишите проблему которая у вас возникла это поможет нам более эфективно вам помочь")
                        .setMinLength(3)
                        .setMaxLength(1000)
                        .setRequired(true)
                        .build();
                TextInput launcherUrl = TextInput.create("launcherUrl", "Укажите ссылку на ваш сервер.", TextInputStyle.PARAGRAPH)
                        .setPlaceholder("https://panel.king-host.ru/server/XXXXX")
                        .setMinLength(3)
                        .setMaxLength(40)
                        .setRequired(true)
                        .build();
                TextInput launcherEmail = TextInput.create("launcherEmail", "Укажите ваш EMAIL", TextInputStyle.PARAGRAPH)
                        .setPlaceholder("example@gmail.com")
                        .setMinLength(3)
                        .setMaxLength(40)
                        .setRequired(true)
                        .build();

                Modal modal = Modal.create("launcher", "Предоставьте нам информацию")
                        .addActionRows(ActionRow.of(launcherVersion), ActionRow.of(launcherDocs), ActionRow.of(launcherUrl), ActionRow.of(launcherEmail))
                        .build();
                event.replyModal(modal).queue();
            }
            if(event.getValues().get(0).equals("Tarifsupport")) {
                TextInput TarifTarif = TextInput.create("TarifTarif", "Ваш текущий тариф(ы)", TextInputStyle.SHORT)
                        .setPlaceholder("Блок земли 1 / Для лаунчера / Bungecord / etc...")
                        .setMinLength(5)
                        .setMaxLength(100)
                        .setRequired(true)
                        .build();
                TextInput TarifDoTarif = TextInput.create("TarifDoTarif", "Тариф до которого(ых) хотите обновить", TextInputStyle.PARAGRAPH)
                        .setPlaceholder("Блок железа 1 / Блок золота 3 / Блок земли 2 / etc.....")
                        .setMinLength(3)
                        .setMaxLength(1000)
                        .setRequired(true)
                        .build();
                TextInput TarifUrl = TextInput.create("TarifUrl", "Укажите ссылку на ваш сервер.", TextInputStyle.PARAGRAPH)
                        .setPlaceholder("https://panel.king-host.ru/server/XXXXX")
                        .setMinLength(3)
                        .setMaxLength(40)
                        .setRequired(true)
                        .build();
                TextInput TarifBal = TextInput.create("TarifBal", "Достаточно ли у вас деняг на балансе?", TextInputStyle.PARAGRAPH)
                        .setPlaceholder("Да / Нет")
                        .setMinLength(3)
                        .setMaxLength(40)
                        .setRequired(true)
                        .build();
                TextInput TarifEmail = TextInput.create("TarifEmail", "Укажите ваш EMAIL", TextInputStyle.PARAGRAPH)
                        .setPlaceholder("example@gmail.com")
                        .setMinLength(3)
                        .setMaxLength(40)
                        .setRequired(true)
                        .build();

                Modal modal = Modal.create("Tarifsupport", "Заполните форму обновления тарифа(ов)")
                        .addActionRows(ActionRow.of(TarifTarif), ActionRow.of(TarifDoTarif), ActionRow.of(TarifUrl), ActionRow.of(TarifBal), ActionRow.of(TarifEmail))
                        .build();
                event.replyModal(modal).queue();
            }
            if(event.getValues().get(0).equals("serversupport")) {
                TextInput serverCore = TextInput.create("serverCore", "Какое у вас ядро сервера?", TextInputStyle.SHORT)
                        .setPlaceholder("spigot / pufferfish / magma / etc.....")
                        .setMinLength(5)
                        .setMaxLength(100)
                        .setRequired(true)
                        .build();
                TextInput serverJava = TextInput.create("serverJava", "Какая у вас версия java на сервере?", TextInputStyle.PARAGRAPH)
                        .setPlaceholder("8 / 9 / 11 / 15 / 16 / 17 / etc...")
                        .setMinLength(3)
                        .setMaxLength(1000)
                        .setRequired(true)
                        .build();
                TextInput serverVersion = TextInput.create("serverVersion", "Какая у вас версия MINECRAFT?", TextInputStyle.PARAGRAPH)
                        .setPlaceholder("1.8.9 / 1.12.2 / 1.16.5 / 1.19 / etc....")
                        .setMinLength(3)
                        .setMaxLength(40)
                        .setRequired(true)
                        .build();
                TextInput serverLink = TextInput.create("serverLink", "Укажите ссылку на ваш сервер.", TextInputStyle.PARAGRAPH)
                        .setPlaceholder("https://panel.king-host.ru/server/XXXXX")
                        .setMinLength(3)
                        .setMaxLength(40)
                        .setRequired(true)
                        .build();
                TextInput serverTarif = TextInput.create("serverTarif", "Укажите тариф вашего сервера?", TextInputStyle.PARAGRAPH)
                        .setPlaceholder("Блок земли 1 / Блок камня 1 / Для лаунчера / Bungecord")
                        .setMinLength(3)
                        .setMaxLength(40)
                        .setRequired(true)
                        .build();

                Modal modal = Modal.create("server", "Предоставте нам информацию")
                        .addActionRows(ActionRow.of(serverCore), ActionRow.of(serverJava), ActionRow.of(serverVersion), ActionRow.of(serverLink), ActionRow.of(serverTarif))
                        .build();
                event.replyModal(modal).queue();
            }
        }
    }
}
