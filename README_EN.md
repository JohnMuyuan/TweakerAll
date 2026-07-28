# TweakerAll

![License: LGPL-3.0-only](https://img.shields.io/badge/license-LGPL--3.0--only-blue)
![Minecraft: 26.1.2](https://img.shields.io/badge/minecraft-26.1.2-green)
![Loader: Fabric](https://img.shields.io/badge/loader-Fabric-yellow)

> **TweakerAll is free and open source (LGPL-3.0-only), forever.**
> **Anyone selling this mod to you is scamming you — report them and never pay.**
> Author homepage & contact: **YP.MK** (https://muyno.com)

**中文版：[README.md](README.md)**

---

## What is this?

TweakerAll is an **independent, all-in-one** client-side utility mod for Minecraft (Fabric), developed and maintained by **JohnMuyuan** as a personal hobby project.

It packs the hundreds of client tweaks the author actually plays with — view & movement fixes, inventory and container helpers, rendering adjustments, quick actions and all kinds of QoL features — into a **single mod**, driven by **one unified configuration screen**. Everything is organized into Generic / Fixes / Lists / Tweaks / Hotkeys / Disables categories, opened with `X + C` by default.

The project exists purely as a hobby: the author didn't want to juggle a pile of small single-purpose mods, so a lot of care went into merging them, fixing compatibility issues and polishing the result into one coherent whole — then open-sourcing it for anyone with the same needs. **It is not part of, and does not depend on, any other mod or team.**

## Features

- **Unified config screen**: six category tabs plus a global "All" tab, each sectioned by feature source, with keybind search;
- **Tweaks**: flexible/free placement, fast placement, angel-block placement, free camera mode, creative-mode scaffolding, auto restock, fast right click, accurate placement and many more — each toggleable and configurable on its own;
- **Fixes**: assorted vanilla annoyance fixes;
- **Lists**: configurable item blacklists/whitelists, entity filters, etc.;
- **Disables**: turn off unwanted vanilla behaviors (certain particles, hoes tilling soil, hand bobbing, ...);
- **Hotkeys**: every function's keybind is fully remappable;
- Ships with a **Sodium/Iris rendering compatibility fix** and a "disable hand bobbing" patch built in, so it coexists with mainstream rendering mods out of the box.

## Installation

1. Install **Fabric Loader 0.19.3+** for Minecraft **26.1.2**;
2. Install the dependencies: **MaLiLib 0.28.8+ (below 0.29.0)** and **Fabric API**;
3. Drop `tweakerall-fabric-*.jar` from [Releases](https://github.com/JohnMuyuan/TweakerAll/releases) into your `mods/` folder;
4. Do **NOT** also install Tweakeroo, TweakerMore or Eclipse's Tweakeroo Additions — their functionality is already fully included in this mod, and co-installation is blocked by the mod's metadata (`breaks` entries) to prevent crashes.

## Reporting issues

- Found a problem with TweakerAll? Open an issue in [this repository](https://github.com/JohnMuyuan/TweakerAll/issues) with your Minecraft version, TweakerAll version, MaLiLib / Fabric API versions and reproduction steps;
- Please make sure the issue is actually caused by TweakerAll itself (and not by some similarly-named single-feature mod) before reporting — thank you!

## Building from source

- Requires **JDK 25**; a Gradle Wrapper is included (`gradlew`), no separate Gradle install needed;
- The three LGPL-3.0 upstream jars in `libs/` are merged into the final artifact at build time (see [NOTICE.md](NOTICE.md));
- Run `gradlew build`; the output jar lands in `build/libs/`.

## Credits

TweakerAll's underlying feature implementations are merged from the following three excellent LGPL-3.0 open-source mods (their published compiled jars are merged at build time; original package names, translations and license files are fully retained). **None of this would exist without these authors' years of open-source work — heartfelt thanks to all of them:**

| Upstream project | Author(s) | Repository |
|---|---|---|
| Tweakeroo | masa, Sakura-Ryoko | https://github.com/maruohon/tweakeroo · https://github.com/Sakura-Ryoko/tweakeroo |
| TweakerMore | Fallen_Breath | https://github.com/Fallen-Breath/tweakermore |
| Eclipse's Tweakeroo Additions | eclipseisoffline | https://github.com/eclipseisoffline/eclipsestweakeroo |

Note: TweakerAll is an independently maintained personal project and is **not affiliated with, endorsed by, or officially connected to** the authors or teams above in any way. Please do not bother the upstream authors with issues about TweakerAll.

## License

TweakerAll as a whole is licensed under **LGPL-3.0-only**, matching the licenses of the merged components:

- [LICENSE](LICENSE) — LGPL-3.0 full text
- [COPYING](COPYING) — GPL-3.0 full text (required to accompany the LGPL)
- [NOTICE.md](NOTICE.md) — third-party attribution and provenance

**Once more, with feeling: this mod is free and open source. Any paid "sale" of it has nothing to do with the author — do not pay.**
