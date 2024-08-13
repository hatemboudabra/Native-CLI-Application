package com.example.native_CLI_Application;

import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

public class HintsRegistrar implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints.resources().registerPattern("*.pdf");
        hints.resources().registerPattern("*.st");
        hints.resources().registerPattern("*.txt");
    }
}
