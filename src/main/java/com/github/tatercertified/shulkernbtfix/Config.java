package com.github.tatercertified.shulkernbtfix;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.util.Objects;
import java.util.Properties;

public class Config {
    public static int stackSize;

    private static final String configVer = "1.0";
    public static final Properties properties = new Properties();
    public static final Logger LOGGER = LoggerFactory.getLogger("Shulker NBT Fix");

    public static void init() {
        var path = FabricLoader.getInstance().getConfigDir().resolve("shulkernbtfix.properties");

        if (Files.notExists(path)) {
            mkfile();
            LOGGER.info("Creating Shulker NBT Fix config");
        } else {
            loadcfg();
            if (!(Objects.equals(properties.getProperty("config-version"), configVer))) {
                mkfile();
                LOGGER.info("Updating Creating Shulker NBT Fix config");
            } else {
                parse();
            }
        }
    }

    private static void mkfile() {
        try (OutputStream output = Files.newOutputStream(FabricLoader.getInstance().getConfigDir().resolve("shulkernbtfix.properties"))) {
            if (!properties.contains("config-version")) {
                properties.setProperty("config-version", configVer);
            }
            if (!properties.contains("stack-size")) {
                properties.setProperty("stack-size", "64");
            }
            properties.store(output, null);
        } catch (IOException e) {
            LOGGER.warn("Failed to create config");
            throw new RuntimeException(e);
        }
        parse();
    }

    public static void loadcfg() {
        try (InputStream input = Files.newInputStream(FabricLoader.getInstance().getConfigDir().resolve("shulkernbtfix.properties"))) {
            properties.load(input);
        } catch (IOException e) {
            LOGGER.warn("Failed to load config");
            throw new RuntimeException(e);
        }
    }

    public static void parse() {
        stackSize = Integer.parseInt(properties.getProperty("stack-size"));
    }
}
