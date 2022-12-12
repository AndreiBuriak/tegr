package ru.pets.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.pets.AppProperties;

@Log4j
@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Autowired
    protected AppProperties properties;

    @Override
    public String getBotUsername() {
        return properties.getName();
    }

    @Override
    public String getBotToken() {
        return properties.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        log.debug(message.getText());
    }
}
