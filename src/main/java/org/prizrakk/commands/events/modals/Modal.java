package org.prizrakk.commands.events.modals;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.Category;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;
import org.prizrakk.Values;

import java.awt.*;
import java.util.Collections;


public class Modal extends ListenerAdapter {
    Button button = Button.primary("closeTicket", "Закрыть тикет");

    public long idChanel;
    @Override
    public void onModalInteraction(@NotNull ModalInteractionEvent event) {

        Member member = event.getMember();
        String username = member.getEffectiveName();
        Button delete = Button.primary("deleteConfirm", "Да мне помогли!");

        if (event.getModalId().equals("Tarifsupport")) {
            /** TarifTarif Ваш текущий тариф(ы) (строка)
             * TarifDoTarif Тариф до которого(ых) хотите обновить (строка)
             * TarifUrl Укажите ссылку на ваш сервер. (строка)
             * TarifBal Достаточно ли у вас деняг на балансе? (строка)
             * TarifEmail Укажите ваш EMAIL (строка)
             * Tarifsupport - внутрений Id модального окна
             **/

            /** иницализация текста в переменую String **/
            String TarifTarif = event.getValue("TarifTarif").getAsString();
            String TarifDoTarif = event.getValue("TarifDoTarif").getAsString();
            String TarifUrl = event.getValue("TarifUrl").getAsString();
            String TarifBal = event.getValue("TarifBal").getAsString();
            String TarifEmail = event.getValue("TarifBal").getAsString();
            /** Создание канала**/
            Guild guild = event.getGuild();
            Category category = guild.getCategoryById(Values.categoryIds[4]);
            TextChannel channel = category.createTextChannel("Тариф-" + username)
                    .addPermissionOverride(guild.getPublicRole(),null, Collections.singleton(Permission.VIEW_CHANNEL))
                    .addMemberPermissionOverride(member.getIdLong(), Collections.singleton(Permission.VIEW_CHANNEL), null)
                    .reason("Запрос на обновления тарифа")
                    .complete();
            idChanel = channel.getIdLong();
            /** Отправка сообщения **/
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Запрос на обновление тарифа!");
            embed.setColor(Color.GREEN);
            embed.setDescription("Пользователь пожалуйста если вы ошиблись при заполнение данных пожалуйста напишите их тут дабы поддержка выполнила свою работу более эфективно");
            embed.addField("Текущий тариф", TarifTarif ,true);
            embed.addField("Тариф до которого вы хотите обновится", TarifDoTarif, true);
            embed.addField("URL панели", TarifUrl, true);
            embed.addField("Достаточно ли деняг на балансе?", TarifBal , true);
            embed.addField("Email", TarifEmail ,true);
            event.reply("Заявка создана в: " + channel.getName()).setEphemeral(true).queue();


            channel.sendMessageEmbeds(embed.build())
                    .setActionRow(button)
                    .queue();
            channel.pinMessageById(channel.getLatestMessageId()).queue();
        } else if (event.getModalId().equals("bad")) {
            /** badNakogo На кого вы хотите подать жалобу?
             *  badUser Дискорд ник и тег нарушителя
             *  badIp IP сервера (если в 1 выбрали сервер)
             *  badEmail Ваш EMAIL
             *  badDocs Доказательства
             *  bad - id модального окна **/
            /** иницализация текста в переменую String **/
            String badNakogo = event.getValue("badNakogo").getAsString();
            String badUser = event.getValue("badUser").getAsString();
            String badIp = event.getValue("badIp").getAsString();
            String badEmail = event.getValue("badEmail").getAsString();
            String badDocs = event.getValue("badDocs").getAsString();
            /** Создание канала**/
            Guild guild = event.getGuild();
            Category category = guild.getCategoryById(Values.categoryIds[5]);
            TextChannel channel = category.createTextChannel("Жалобы-" + username)
                    .addPermissionOverride(guild.getPublicRole(), null, Collections.singleton(Permission.VIEW_CHANNEL))
                    .addMemberPermissionOverride(member.getIdLong(), Collections.singleton(Permission.VIEW_CHANNEL), null)
                    .reason("Запрос на обновления тарифа")
                    .complete();
            idChanel = channel.getIdLong();
            /** Отправка сообщения **/
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Жалоба");
            embed.setDescription("Вы уверены? если это окажется клеветой это может плохо для вас закончится вам могут выдать блокировку");
            embed.addField("На кого жалоба", badNakogo, true);
            embed.addField("Дискорд ник и тег нарушителя", badUser, true);
            embed.addField("сервера (если в 1 выбрали сервер)", badIp, true);
            embed.addField("Ваш EMAIL", badEmail, true);
            embed.addField("Доказательства", badDocs, true);
            embed.setColor(Color.GREEN);
            event.reply("Заявка создана в: " + channel.getName()).setEphemeral(true).queue();
            channel.sendMessageEmbeds(embed.build())
                    .setActionRow(button)
                    .queue();
            channel.pinMessageById(channel.getLatestMessageId()).queue();
        } else if (event.getModalId().equals("panel")) {
            /** panelProblem Кратко опишите проблему
             *  panelDocs Опишите проблему
             *  panelTime Укажите время в которое произошла ошибка.
             *  panelEmail Укажите ваш EMAIL
             *  panel - id модального окна **/
            /** иницализация текста в переменую String **/
            String panelProblem = event.getValue("panelProblem").getAsString();
            String panelDocs = event.getValue("panelDocs").getAsString();
            String panelTime = event.getValue("panelTime").getAsString();
            String panelEmail = event.getValue("panelEmail").getAsString();
            /** Создание канала**/
            Guild guild = event.getGuild();
            Category category = guild.getCategoryById(Values.categoryIds[1]);
            TextChannel channel = category.createTextChannel("Панель-" + username)
                    .addPermissionOverride(guild.getPublicRole(), null, Collections.singleton(Permission.VIEW_CHANNEL))
                    .addMemberPermissionOverride(member.getIdLong(), Collections.singleton(Permission.VIEW_CHANNEL), null)
                    .reason("Запрос на панель")
                    .complete();
            idChanel = channel.getIdLong();
            /** Отправка сообщения **/
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Жалоба");
            embed.setDescription("Вы уверены? если это окажется клеветой это может плохо для вас закончится вам могут выдать блокировку");
            embed.addField("Кратко опишите проблему", panelProblem, true);
            embed.addField("Опишите проблему", panelDocs, true);
            embed.addField("Укажите время в которое произошла ошибка.", panelTime, true);
            embed.addField("Укажите ваш EMAIL", panelEmail, true);
            embed.setColor(Color.GREEN);
            event.reply("Заявка создана в: " + channel.getName()).setEphemeral(true).queue();
            channel.sendMessageEmbeds(embed.build())
                    .setActionRow(button)
                    .queue();
            channel.pinMessageById(channel.getLatestMessageId()).queue();

        } else if (event.getModalId().equals("launcher")) {
            /** launcherVersion Ваш ланучсервер и версия
             *  launcherDocs Опишите проблему
             *  launcherUrl Укажите ссылку на ваш сервер.
             *  launcherEmail Укажите ваш EMAIL
             *  launcher - id модального окна **/
            /** иницализация текста в переменую String **/
            String launcherVersion = event.getValue("launcherVersion").getAsString();
            String launcherDocs = event.getValue("launcherDocs").getAsString();
            String launcherUrl = event.getValue("launcherUrl").getAsString();
            String launcherEmail = event.getValue("launcherEmail").getAsString();
            /** Создание канала**/
            Guild guild = event.getGuild();
            Category category = guild.getCategoryById(Values.categoryIds[2]);
            TextChannel channel = category.createTextChannel("Лаунчер-" + username)
                    .addPermissionOverride(guild.getPublicRole(), null, Collections.singleton(Permission.VIEW_CHANNEL))
                    .addMemberPermissionOverride(member.getIdLong(), Collections.singleton(Permission.VIEW_CHANNEL), null)
                    .reason("Запрос на лаунчер")
                    .complete();
            idChanel = channel.getIdLong();
            /** Отправка сообщения **/
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Лаунчер");
            embed.addField("Ваш ланучсервер и версия", launcherVersion, true);
            embed.addField("Опишите проблему", launcherDocs, true);
            embed.addField("Укажите ссылку на ваш сервер.", launcherUrl, true);
            embed.addField("Укажите ваш EMAIL", launcherEmail, true);
            embed.setColor(Color.GREEN);
            event.reply("Заявка создана в: " + channel.getName()).setEphemeral(true).queue();
            channel.sendMessageEmbeds(embed.build())
                    .setActionRow(button)
                    .queue();
            channel.pinMessageById(channel.getLatestMessageId()).queue();
        } else if (event.getModalId().equals("server")) {
            /** serverCore Какое у вас ядро сервера?
             *  serverJava Какая у вас версия java на сервере?
             *  serverVersion Какая у вас версия MINECRAFT?
             *  serverLink Укажите ссылку на ваш сервер.
             *  serverTarif Укажите тариф вашего сервера?
             *  server - id модального окна **/
            /** иницализация текста в переменую String **/
            String serverCore = event.getValue("serverCore").getAsString();
            String serverJava = event.getValue("serverJava").getAsString();
            String serverVersion = event.getValue("serverVersion").getAsString();
            String serverLink = event.getValue("serverLink").getAsString();
            String serverTarif = event.getValue("serverTarif").getAsString();
            /** Создание канала**/
            Guild guild = event.getGuild();
            Category category = guild.getCategoryById(Values.categoryIds[3]);
            TextChannel channel = category.createTextChannel("Сервер-" + username)
                    .addPermissionOverride(guild.getPublicRole(), null, Collections.singleton(Permission.VIEW_CHANNEL))
                    .addMemberPermissionOverride(member.getIdLong(), Collections.singleton(Permission.VIEW_CHANNEL), null)
                    .reason("Запрос на сервер")
                    .complete();
            idChanel = channel.getIdLong();
            /** Отправка сообщения **/
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Сервер");
            embed.addField("Какое у вас ядро сервера?", serverCore, true);
            embed.addField("Какая у вас версия java на сервере?", serverJava, true);
            embed.addField("Какая у вас версия MINECRAFT?", serverVersion, true);
            embed.addField("Укажите ссылку на ваш сервер.", serverLink, true);
            embed.addField("Укажите тариф вашего сервера?", serverTarif , true);
            embed.setColor(Color.GREEN);
            event.reply("Заявка создана в: " + channel.getName()).setEphemeral(true).queue();
            channel.sendMessageEmbeds(embed.build())
                    .setActionRow(button)
                    .queue();
            channel.pinMessageById(channel.getLatestMessageId()).queue();
        }

    }
    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        Button deleteNoConf = Button.primary("deleteConfirm", "Да мне помогли!");
        Member member = event.getMember();
        Guild guild = event.getGuild();
        if (event.getComponentId().equals("closeTicket")) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Вы уверены?");
            embed.setDescription("Вы уверены? вам точно помогли?");
            embed.setColor(Color.red);

            Button cansel = Button.primary("cansel", "Нет мне не помогли!");
            event.replyEmbeds(embed.build())
                    .setActionRow(deleteNoConf, cansel)
                    .queue();
        } else if (event.getComponentId().equals("deleteConfirm")) {
            Category newParentCategory = guild.getCategoryById(Values.categoryIds[0]);
            TextChannel channel = guild.getTextChannelById(idChanel);
            channel.getManager().setParent(newParentCategory).queue();
            channel.getManager().putMemberPermissionOverride(member.getIdLong(), null, Collections.singleton(Permission.VIEW_CHANNEL)).queue();
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Админ панель");
            embed.setDescription("Удалить?");
            Button delete = Button.primary("delete", "Удалить");
            event.replyEmbeds(embed.build()).setActionRow(delete).queue();
        }else if (event.getComponentId().equals("delete")) {
            event.reply("Ок").queue();
            guild.getTextChannelById(idChanel).delete().queue();
        } else if (event.getComponentId().equals("cansel")) {
            event.reply("Отменено")
                    .setActionRow(deleteNoConf.asDisabled())
                    .queue();
        }
    }
}
