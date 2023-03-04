package com.siigo.automation.utils;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.siigo.automation.model.models.client.Client;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class PropertyHelper {

    private static Client activeClient = null;
    private static final Set<Client> allClients = new HashSet<>();

    public static Client getAClientFromConfig(String clientName) {
        generatedClientList();
        for (Client client : allClients) {
            if (client.getName().equals(clientName)) {
                activeClient = client;
            }
        }
        return activeClient;
    }
    public static Set<Client> generatedClientList() {
        YamlReader reader;
        Client client;
        try {
            reader = new YamlReader(new FileReader(Constants.USERS_PATH));
            while ((client = reader.read(Client.class)) != null) {
                allClients.add(client);
            }
        } catch (FileNotFoundException | YamlException exception) {
            log.error("Error loading files from " + Constants.USERS_PATH, exception);
            exception.getStackTrace();
        }
        return allClients;
    }
}

