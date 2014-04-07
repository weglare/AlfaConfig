package com.glare.config.Files;

import java.util.logging.Logger;

public class Log
{
  private static final Logger log = Logger.getLogger("Minecraft");
  private static final String prefix = "[AlfaConfig] ";

  public static void info(String output)
  {
    log.info("[AlfaConfig] " + output);
  }

  public static void severe(String output) {
    log.severe("[AlfaConfig] " + output);
  }

  public static void warning(String output) {
    log.warning("[AlfaConfig] " + output);
  }
}