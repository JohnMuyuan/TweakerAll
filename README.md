# TweakerAll

![License: LGPL-3.0-only](https://img.shields.io/badge/license-LGPL--3.0--only-blue)
![Minecraft: 26.1.2](https://img.shields.io/badge/minecraft-26.1.2-green)
![Loader: Fabric](https://img.shields.io/badge/loader-Fabric-yellow)

> **本模组永久免费、开源（LGPL-3.0-only）。任何人向你出售本模组都是诈骗，请立刻举报。**
> 作者主页及联系方式：**YP.MK**（https://muyno.com）

**English version: [README_EN.md](README_EN.md)**

---

## 这是什么？

TweakerAll 是一个**独立的** Minecraft 客户端功能整合模组（Fabric），由 **JohnMuyuan** 个人开发维护。

它把作者日常在用的数百个客户端 tweak——视角与移动修复、物品栏与容器操作、渲染调整、快捷操作、各类 QoL 功能——收进**同一个模组**里，并配了一个**统一的配置界面**：所有功能按「通用 / 修复 / 列表 / 功能 / 热键 / 禁用项」分类，一个界面全部搞定，默认按 `X + C` 打开。

做这个模组纯粹是个人爱好：作者自己玩的时候不想装一堆零零碎碎的模组，于是花了不少心思把它们整合、修兼容、做成一个顺手的整体，顺手开源出来给有同样需求的人用。**它不属于、也不依附于任何其他模组或团队。**

## 功能概览

- **统一配置界面**：六个分类页签 + 全局「全部」页签，每类内部按功能来源分段，支持热键搜索；
- **功能（Tweaks）**：自由放置、快速放置、天使方块放置、灵魂出窍、创造模式浮空脚手架、自动补货、快速右键、精准放置等上百项开关，均可独立配置；
- **修复（Fixes）**：各类原版小毛病修复（如配方书卡屏、幽灵方块等）；
- **列表（Lists）**：物品黑名单/白名单、实体过滤等可配置列表；
- **禁用项（Disables）**：屏蔽不需要的原版行为（如禁用某些粒子、禁用锄头耕地、禁用手部晃动等）；
- **热键（Hotkeys）**：所有功能快捷键可自定义；
- 内置 **Sodium/Iris 渲染兼容修复**和「禁用 - 手部晃动」补丁，与主流渲染模组共存无冲突。

## 安装

1. 安装 Minecraft **26.1.2** 的 **Fabric Loader 0.19.3+**；
2. 安装依赖：**MaLiLib 0.28.8+（低于 0.29.0）** 和 **Fabric API**；
3. 把从 [Releases](https://github.com/JohnMuyuan/TweakerAll/releases) 下载的 `tweakerall-fabric-*.jar` 放进 `mods/` 文件夹；
4. **不要**同时安装 Tweakeroo、TweakerMore 或 Eclipse's Tweakeroo Additions——相关功能已完整包含在本模组内，同时安装会被启动器直接拦截（模组元数据中已声明冲突）。

## 问题反馈

- 使用本模组遇到问题：请发[本仓库 Issues](https://github.com/JohnMuyuan/TweakerAll/issues)，附上 Minecraft 版本、TweakerAll 版本、MaLiLib / Fabric API 版本和复现步骤；
- 反馈前请确认问题确实出在本模组（而不是某个同名单一功能模组），感谢配合。

## 从源码构建

- 需要 **JDK 25**；项目附带 Gradle Wrapper（`gradlew`），无需自行安装 Gradle；
- `libs/` 目录中的三个 LGPL-3.0 上游 jar 会在构建时被合并进最终产物（详见 [NOTICE.md](NOTICE.md)）；
- 执行 `gradlew build`，产物在 `build/libs/`。

## 致谢

本模组的底层功能实现合并自以下三个优秀的 LGPL-3.0 开源模组（构建期合并其已发布的编译产物，原始包名、翻译与许可证文件均完整保留）。**没有这些作者多年的开源工作就没有本模组，在此致以诚挚的感谢：**

| 上游项目 | 作者 | 仓库 |
|---|---|---|
| Tweakeroo | masa、Sakura-Ryoko | https://github.com/maruohon/tweakeroo · https://github.com/Sakura-Ryoko/tweakeroo |
| TweakerMore | Fallen_Breath | https://github.com/Fallen-Breath/tweakermore |
| Eclipse's Tweakeroo Additions | eclipseisoffline | https://github.com/eclipseisoffline/eclipsestweakeroo |

说明：TweakerAll 是独立维护的个人项目，与上述作者及其团队**没有任何隶属或官方关系**；也请不要就本模组的问题去打扰上游作者。

## 许可证

本模组整体以 **LGPL-3.0-only** 开源，与所合并组件的许可证一致：

- [LICENSE](LICENSE) — LGPL-3.0 全文
- [COPYING](COPYING) — GPL-3.0 全文（LGPL 要求随附）
- [NOTICE.md](NOTICE.md) — 第三方组件归属与来源说明

**再强调一次：本模组免费开源。任何收费售卖行为均与作者无关，请勿付款。**
