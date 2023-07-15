package org.prizrakk;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.Category;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.channel.concrete.CategoryManager;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;
import org.prizrakk.commands.SelectedMenuCommand;
import org.prizrakk.commands.events.SelectedMenu;
import org.prizrakk.commands.events.modals.Modal;
import org.prizrakk.manager.CommandManager;

import java.util.Collections;

import static org.prizrakk.Values.categoryIds;


public class Main extends ListenerAdapter {
    public static JDA jda;
    public static void main(String[] args) {
        String token = "MTEyOTE4ODE5NzAyNTQ2NDQwMA.GcIsrR.G_0vRM2SpHx8Z-JPlbepoAZgjYLH8CBL-HWsmQ";
        jda = JDABuilder.createDefault(token).enableIntents(GatewayIntent.MESSAGE_CONTENT).build();
        jda.addEventListener(new SelectedMenu());
        jda.addEventListener(new Modal());
        CommandManager manager = new CommandManager();
        manager.add(new SelectedMenuCommand());
        jda.addEventListener(manager);
        jda.addEventListener(new Main());
    }
    @Override
    public void onReady(@NotNull ReadyEvent event) {
        Guild guild = event.getJDA().getGuildById("1078282995418533938");
        String[] categoryNames = {"Архив", "панели", "лаунчер", "сервер", "тариф", "жалобы"};
        categoryIds = new Long[categoryNames.length];

        for (int i = 0; i < categoryNames.length; i++) {
            String categoryName = categoryNames[i];
            int i2 = i;
            // Проверяем наличие категории
            Category category = guild.getCategoriesByName(categoryName, true).stream().findFirst().orElse(null);

            if (category == null) {
                // Категория не существует, создаем новую категорию
                guild.createCategory(categoryName).queue(createdCategory -> {
                    // Категория успешно создана
                    categoryIds[i2] = createdCategory.getIdLong();
                    System.out.println("=================================================="
                            + "\n" +"Категория '" + categoryName + "' успешно создана!"
                            + "\n" + "Индефикатор: " + categoryIds[i2] + " Масив categotyIds[" + i2 + "]"
                            + "\n" +"==================================================" );
                });
            } else {
                // Категория уже существует
                categoryIds[i] = category.getIdLong();
                System.out.println("=================================================="
                        + "\n" +"Категория '" + categoryName + "' уже существует!"
                        + "\n" + "Индефикатор: " + categoryIds[i2] + " Масив categotyIds[" + i2 + "]"
                        + "\n" +"==================================================" );

            }
        }
    }
}