# TweakerAll third-party notice

TweakerAll — Copyright (C) 2026 JohnMuyuan (https://muyno.com).
The combined work as a whole is licensed under the GNU Lesser General Public
License v3.0 only (LGPL-3.0-only); see LICENSE for the LGPL text and COPYING
for the accompanying GPL-3.0 text.

TweakerAll is an independent mod maintained by JohnMuyuan. It is built by
merging the published compiled jars of the following LGPL-3.0 mods (placed in
libs/ at build time), then adding its own unified metadata, entrypoint wiring
and a shared configuration screen:

- Tweakeroo 0.28.6+handviewbob.2 for Minecraft 26.1.2 — masa and Sakura-Ryoko
  https://github.com/maruohon/tweakeroo — https://github.com/Sakura-Ryoko/tweakeroo
  (locally built from the Sakura-Ryoko fork with a Sodium/Iris compatibility
  and hand-bobbing patch applied; the upstream tweakeroo jar itself ships no
  license file)
- TweakerMore 3.31.0-beta.1 for Minecraft 26.1.2 — Fallen_Breath
  https://github.com/Fallen-Breath/tweakermore
- Eclipse's Tweakeroo Additions 0.7.5 for Minecraft 26.1.2 — eclipseisoffline
  https://github.com/eclipseisoffline/eclipsestweakeroo

The jars in libs/ are unmodified upstream builds (except for the patched
Tweakeroo build noted above). Corresponding source code for the merged
components is available at the upstream repositories linked above;
TweakerAll's own additions live in this repository under src/.

Their original package names, translations, configuration storage and license
files are retained in the merged artifact.
