/*
 * This file is part of TweakerAll, licensed under the
 * GNU Lesser General Public License v3.0 only.
 * Copyright (C) 2026 JohnMuyuan
 */
package dev.tweakerall.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.options.BooleanHotkeyGuiWrapper;
import fi.dy.masa.malilib.gui.GuiConfigsBase;
import fi.dy.masa.malilib.gui.button.ButtonBase;
import fi.dy.masa.malilib.gui.button.ButtonGeneric;
import fi.dy.masa.malilib.gui.button.IButtonActionListener;
import fi.dy.masa.malilib.render.GuiContext;
import fi.dy.masa.malilib.util.StringUtils;
import fi.dy.masa.tweakeroo.config.Configs;
import fi.dy.masa.tweakeroo.config.Hotkeys;
import fi.dy.masa.tweakeroo.gui.GuiConfigs;
import me.fallenbreath.tweakermore.config.Config;
import me.fallenbreath.tweakermore.config.TweakerMoreConfigs;
import me.fallenbreath.tweakermore.config.TweakerMoreOption;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screens.Screen;
import xyz.eclipseisoffline.eclipsestweakeroo.client.config.EclipsesDisableConfig;
import xyz.eclipseisoffline.eclipsestweakeroo.client.config.EclipsesFixesConfig;
import xyz.eclipseisoffline.eclipsestweakeroo.client.config.EclipsesGenericConfig;
import xyz.eclipseisoffline.eclipsestweakeroo.client.config.EclipsesHotkeys;
import xyz.eclipseisoffline.eclipsestweakeroo.client.config.EclipsesListsConfig;
import xyz.eclipseisoffline.eclipsestweakeroo.client.config.EclipsesTweaksConfig;

public final class TweakerAllConfigScreen extends GuiConfigsBase {
    private static Tab tab = Tab.TWEAKS;

    public TweakerAllConfigScreen(Screen parent) {
        super(10, 50, "tweakerall", parent, "tweakerall.gui.title", "1.0.6");
        setParent(parent);
    }

    @Override
    public void initGui() {
        super.initGui();
        clearOptions();

        int x = 10;
        for (Tab candidate : Tab.values()) {
            ButtonGeneric button = new ButtonGeneric(x, 26, -1, 20, candidate.displayName());
            button.setEnabled(tab != candidate);
            addButton(button, new TabListener(candidate));
            x += button.getWidth() + 2;
        }
    }

    @Override
    protected int getConfigWidth() {
        return switch (tab) {
            case GENERIC -> 170;
            case FIXES -> 60;
            case LISTS -> 200;
            default -> 260;
        };
    }

    @Override
    protected boolean useKeybindSearch() {
        return tab == Tab.ALL || tab == Tab.TWEAKS || tab == Tab.HOTKEYS || tab == Tab.DISABLES;
    }

    @Override
    protected void drawTitle(GuiContext context, int mouseX, int mouseY, float partialTicks) {
        super.drawTitle(context, mouseX, mouseY, partialTicks);
        String notice = StringUtils.translate("tweakerall.gui.free_notice");
        int titleWidth = getStringWidth(getTitleString());
        drawString(context, notice, 24 + titleWidth, 11, 0xFF55FF55);
    }

    @Override
    public List<ConfigOptionWrapper> getConfigs() {
        return tab == Tab.ALL ? allConfigs() : categoryConfigs(tab);
    }

    @Override
    public void removed() {
        super.removed();
        Configs.checkBaseLanguage();
    }

    private static List<ConfigOptionWrapper> allConfigs() {
        List<ConfigOptionWrapper> result = new ArrayList<>();
        for (Tab category : Tab.values()) {
            if (category != Tab.ALL) addSection(result, category.displayName(), categoryConfigs(category));
        }
        return result;
    }

    private static List<ConfigOptionWrapper> categoryConfigs(Tab category) {
        List<ConfigOptionWrapper> result = new ArrayList<>();
        if (category == Tab.HOTKEYS) {
            addSection(result, "TweakerAll", ConfigOptionWrapper.createFor(List.of(Hotkeys.OPEN_CONFIG_GUI)));
        }
        addSection(result, "Tweakeroo", tweakerooConfigs(category));
        addSection(result, "TweakerMore", tweakerMoreConfigs(category));
        addSection(result, "Eclipse's Tweakeroo", eclipseConfigs(category));
        return result;
    }

    private static void addSection(List<ConfigOptionWrapper> target, String label, List<ConfigOptionWrapper> configs) {
        if (configs.isEmpty()) return;
        target.add(new ConfigOptionWrapper(label));
        target.addAll(configs);
    }

    private static List<ConfigOptionWrapper> tweakerooConfigs(Tab category) {
        return switch (category) {
            case GENERIC -> ConfigOptionWrapper.createFor(Configs.Generic.OPTIONS);
            case FIXES -> ConfigOptionWrapper.createFor(Configs.Fixes.OPTIONS);
            case LISTS -> ConfigOptionWrapper.createFor(Configs.Lists.OPTIONS);
            case TWEAKS -> ConfigOptionWrapper.createFor(GuiConfigs.TWEAK_LIST.stream()
                    .map(config -> new BooleanHotkeyGuiWrapper(config.getName(), config, config.getKeybind()))
                    .toList());
            case HOTKEYS -> ConfigOptionWrapper.createFor(Hotkeys.HOTKEY_LIST.stream()
                    .filter(config -> config != Hotkeys.OPEN_CONFIG_GUI)
                    .toList());
            case DISABLES -> ConfigOptionWrapper.createFor(GuiConfigs.YEET_LIST);
            case ALL -> List.of();
        };
    }

    private static List<ConfigOptionWrapper> tweakerMoreConfigs(Tab category) {
        boolean debug = TweakerMoreConfigs.TWEAKERMORE_DEBUG_MODE.getBooleanValue();
        boolean development = FabricLoader.getInstance().isDevelopmentEnvironment();
        List<IConfigBase> configs = TweakerMoreConfigs.getOptions(category.tweakerMoreType).stream()
                .filter(option -> option.getConfig() != TweakerMoreConfigs.OPEN_TWEAKERMORE_CONFIG_GUI)
                .filter(option -> debug || !option.isDebug())
                .filter(option -> debug && development || !option.isDevOnly())
                .filter(option -> debug || option.worksForCurrentMCVersion())
                .map(TweakerMoreOption::getConfig)
                .map(IConfigBase.class::cast)
                .toList();
        return ConfigOptionWrapper.createFor(configs);
    }

    private static List<ConfigOptionWrapper> eclipseConfigs(Tab category) {
        List<? extends IConfigBase> configs = switch (category) {
            case GENERIC -> EclipsesGenericConfig.values();
            case FIXES -> EclipsesFixesConfig.values();
            case LISTS -> EclipsesListsConfig.values();
            case TWEAKS -> EclipsesTweaksConfig.values();
            case HOTKEYS -> EclipsesHotkeys.values().stream()
                    .filter(config -> config != EclipsesHotkeys.OPEN_CONFIG_GUI)
                    .toList();
            case DISABLES -> EclipsesDisableConfig.values();
            case ALL -> List.of();
        };
        return ConfigOptionWrapper.createFor(configs);
    }

    private final class TabListener implements IButtonActionListener {
        private final Tab target;

        private TabListener(Tab target) {
            this.target = target;
        }

        @Override
        public void actionPerformedWithButton(ButtonBase button, int mouseButton) {
            tab = target;
            reCreateListWidget();
            Objects.requireNonNull(getListWidget()).resetScrollbarPosition();
            initGui();
        }
    }

    private enum Tab {
        ALL("all", null),
        GENERIC("generic", Config.Type.GENERIC),
        FIXES("fixes", Config.Type.FIX),
        LISTS("lists", Config.Type.LIST),
        TWEAKS("tweaks", Config.Type.TWEAK),
        HOTKEYS("hotkeys", Config.Type.HOTKEY),
        DISABLES("disables", Config.Type.DISABLE);

        private final String name;
        private final Config.Type tweakerMoreType;

        Tab(String name, Config.Type tweakerMoreType) {
            this.name = name;
            this.tweakerMoreType = tweakerMoreType;
        }

        private String displayName() {
            return StringUtils.translate("tweakerall.gui.tab." + name);
        }
    }
}
