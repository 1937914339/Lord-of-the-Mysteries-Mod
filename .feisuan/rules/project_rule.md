
# guimimod 模组开发规范指南
为保证模组代码质量、兼容性、可维护性与安全性，请在开发过程中严格遵循以下规范。

## 一、基础环境与工作目录
- **用户工作目录**：`E:\guimimod-template-1.21.1`
- **目录结构**：
```
guimimod-template-1.21.1
├── .github
│   └── workflows          # GitHub CI/CD 工作流配置，用于自动化构建发布
├── gradle
│   └── wrapper            # Gradle Wrapper 配置，统一团队构建环境
└── src
    └── main
        ├── java
        │   └── com
        │       └── wan
        │           └── gmmod
        │               ├── client          # 客户端专属逻辑包
        │               │   ├── gui         # 图形界面相关实现
        │               │   └── render      # 渲染相关实现
        │               ├── common          # 跨端通用逻辑包
        │               │   ├── capability  # 自定义能力（Capability）实现
        │               │   ├── event       # 事件监听实现
        │               │   ├── item        # 自定义物品实现
        │               │   ├── network     # 网络通信逻辑
        │               │   │   └── packet  # 网络包处理类
        │               │   └── registry    # 注册表统一注册逻辑
        │               └── content         # 模组业务内容实现包
        │                   ├── abilities   # 自定义能力效果实现
        │                   ├── entities    # 自定义实体实现
        │                   └── sequences   # 动画/逻辑序列实现
        ├── resources
        │   └── assets
        │       └── guimi_mod               # 模组资源根目录
        │           ├── animations          # GeckoLib 动画文件
        │           ├── geo                 # 几何模型文件
        │           ├── lang                # 多语言翻译文件
        │           ├── models              # 物品/方块模型文件
        │           │   └── item
        │           ├── neoforge
        │           │   └── biome_modifier  # 生物群系修改器配置
        │           └── textures            # 纹理贴图
        │               ├── item
        │               └── models
        │                   └── armor       # 盔甲纹理
        └── templates
            └── META-INF                   # 模组元数据模板目录
```

## 二、技术栈与构建规范
- **开发框架**：NeoForge（Minecraft 1.21.1 版本）
- **语言版本**：JDK 21（匹配 Minecraft 1.21.1 官方终端运行版本，符合模组开发要求）
- **构建工具**：Gradle，使用 NeoForge 官方 Gradle 插件 `net.neoforged.moddev` 2.0.141
- **核心依赖**：
  - NeoForge 1.21.1 核心依赖
  - `geckolib-neoforge-1.21.1`：实体/物品动画渲染依赖
  - 可选依赖：JEI 等模组 API（按需引入，遵循 `localRuntime` 配置规范，不强制依赖其他模组）
- **构建规范**：
  统一使用项目自带的 `gradlew.bat`（Windows）或 `gradlew`（Linux/macOS）执行构建，禁止直接调用系统全局 Gradle。常用构建命令如下：
  | 命令 | 用途 |
  | --- | --- |
  | `gradlew runClient` | 启动客户端开发环境 |
  | `gradlew runServer --nogui` | 启动无界面服务端开发环境 |
  | `gradlew runData` | 执行数据生成，输出资源到 `src/generated/resources` |
  | `gradlew runGameTestServer` | 运行游戏测试用例 |
  | `gradlew build` | 构建模组发布包 |
- **依赖配置规范**：
  - 编译期依赖使用 `implementation` 配置声明
  - 可选运行时依赖（仅测试用、不强制要求用户安装的依赖）使用 `localRuntime` 配置声明，禁止使用 `runtimeOnly` 声明可选依赖，避免传递给依赖本模组的其他模组
  - 本地 jar 包依赖统一放在项目根目录 `libs` 文件夹下，通过 `flatDir` 仓库引入

## 三、包结构与职责规范
| 包路径 | 职责说明 | 开发约束 |
| --- | --- | --- |
| `com.wan.gmmod.client` | 客户端专属逻辑，仅客户端运行 | 不得包含服务端逻辑，不得在 `common` 包中引用该包下的类 |
| ├─ `gui` | 图形界面实现 | 继承 NeoForge 的 `Screen` 类，处理客户端交互、界面渲染逻辑 |
| └─ `render` | 渲染逻辑实现 | 使用 GeckoLib 渲染接口，不得在服务端逻辑中调用 |
| `com.wan.gmmod.common` | 跨端通用逻辑，客户端和服务端均可运行 | 不得包含客户端专属或服务端专属的逻辑 |
| ├─ `capability` | 自定义能力（Capability）实现 | 遵循 NeoForge Capability 规范，实现客户端与服务端数据同步逻辑 |
| ├─ `event` | 事件监听实现 | 使用 NeoForge 事件总线注册事件，禁止硬编码事件优先级 |
| ├─ `item` | 自定义物品实现 | 继承 NeoForge `Item` 类，注册逻辑统一放在 `registry` 包 |
| ├─ `network` | 网络通信逻辑 | 包含 `packet` 子包的请求/响应处理类，服务端必须校验所有客户端传入参数 |
| └─ `registry` | 注册表统一注册逻辑 | 所有方块、物品、实体、音效等统一在 `RegistryEvent` 中注册，禁止分散注册 |
| `com.wan.gmmod.content` | 模组具体业务内容实现 | 包含能力效果、实体、动画序列等具体逻辑 |
| ├─ `abilities` | 自定义能力效果实现 | 与 `common.capability` 包配合，实现具体能力逻辑 |
| ├─ `entities` | 自定义实体实现 | 继承 NeoForge 实体类，配置 AI、动画、交互逻辑 |
| └─ `sequences` | 动画/逻辑序列实现 | 基于 GeckoLib 实现实体动画序列逻辑 |

### 资源目录规范
| 资源路径 | 用途说明 |
| --- | --- |
| `assets/guimi_mod/animations` | GeckoLib 动画文件存放目录 |
| `assets/guimi_mod/geo` | 实体/物品几何模型文件存放目录 |
| `assets/guimi_mod/lang` | 多语言翻译文件存放目录 |
| `assets/guimi_mod/models` | 物品/方块模型文件存放目录 |
| `assets/guimi_mod/neoforge/biome_modifier` | 生物群系修改器配置目录 |
| `assets/guimi_mod/textures` | 纹理贴图存放目录，按物品、盔甲等分类存放 |

## 四、代码开发规范
### 1. 命名规范
| 类型 | 命名规则 | 示例 |
| --- | --- | --- |
| 类名 | UpperCamelCase（大驼峰） | `CustomSwordItem`、`GuiModScreen` |
| 方法/变量 | lowerCamelCase（小驼峰） | `registerItems()`、`playerCapability` |
| 常量 | UPPER_SNAKE_CASE（大写下划线） | `MAX_ENTITY_COUNT` |
| 注册表键名 | 小写蛇形，前缀为模组id | `guimi_mod_custom_sword` |
| 资源文件 | 小写蛇形，禁止大写/空格 | `custom_sword.png`、`zh_cn.json` |

### 2. 类型后缀规范（阿里巴巴风格，适配模组开发）
| 后缀 | 用途说明 | 示例 |
| --- | --- | --- |
| DTO | 网络包数据传输对象 | `SyncCapabilityDTO` |
| DO | 数据持久化/配置对象 | `ModConfigDO` |
| BO | 业务逻辑封装对象 | `AbilityEffectBO` |
| VO | 视图/渲染相关对象 | `EntityRenderVO` |
| Handler | 事件/网络包处理类 | `PlayerJoinEventHandler`、`SyncPacketHandler` |

### 3. 注释规范
- 所有公开类、方法、字段必须添加 Javadoc 注释，说明用途、参数、返回值含义
- 所有注册逻辑、事件监听、网络包处理、复杂业务逻辑必须添加中文注释，说明触发条件、逻辑流程
- 禁止使用无意义的注释（如`// 赋值`、`// 循环`）

### 4. 代码风格规范
- 使用 Lombok 注解简化代码：实体类、配置类使用 `@Data`、`@NoArgsConstructor`、`@AllArgsConstructor`，禁止手动编写 getter/setter
- 日志使用 `@Slf4j` 注解，禁止使用 `System.out.println` 输出日志
- 客户端与服务端逻辑严格分离，禁止在客户端逻辑中调用服务端专属 API，反之亦然

## 五、安全与性能规范
### 1. 安全规范
- 服务端必须对所有客户端传入的参数做合法性校验，禁止信任客户端数据，防止恶意修改游戏逻辑、刷物品等漏洞
- 禁止手动拼接注册表键名、资源路径，防止注册冲突、资源加载失败，统一使用模组id作为命名空间前缀
- 禁止使用反射修改游戏核心类，除非必要且做好版本兼容处理

### 2. 性能规范
- 禁止在 ticking 事件（`ServerTickEvent`、`ClientTickEvent`、`LivingTickEvent` 等）中执行耗时操作，防止卡顿游戏
- 避免在循环中频繁创建对象，防止触发频繁 GC 导致卡顿
- 资源加载必须在对应注册事件中执行，禁止在静态初始化块中加载资源

## 六、扩展性与兼容性规范
1. **接口优先原则**：核心业务逻辑通过接口定义，实现类放在接口所在包下的 `impl` 子包中，便于后续扩展和替换实现
2. **兼容性规范**：修改游戏原生逻辑时优先使用事件钩子，避免直接继承/覆盖基类方法，减少与其他模组的冲突；遵循 NeoForge 官方 API 规范，禁止使用内部 API（Internal API），防止版本更新后失效
3. **资源规范**：所有模型、纹理、动画等资源与 Java 代码解耦，修改资源无需调整核心逻辑；资源文件统一使用 UTF-8 编码，多语言翻译文件需包含英文和中文两种语言

## 七、编码原则总结
| 原则 | 说明 |
| --- | --- |
| SOLID | 高内聚低耦合，增强代码可维护性与可扩展性 |
| DRY | 避免重复代码，提高逻辑复用性 |
| KISS | 保持代码简洁易懂，避免过度设计 |
| YAGNI | 不实现当前不需要的功能，避免冗余代码 |
| OWASP | 防范模组开发常见安全漏洞，如客户端参数校验、资源路径注入等 |

## 八、项目特定规则
1. 项目使用 Parchment 映射，修改混淆映射需遵循 Parchment 规范，不得直接使用 Mojang 原始映射
2. 数据生成任务输出到 `src/generated/resources` 目录，该目录为自动生成目录，禁止手动修改其中文件
3. 模组元数据（`mods.toml`）由 `generateModMetadata` 任务自动生成，禁止手动修改 `build/generated/sources/modMetadata` 目录下的文件
4. 项目统一使用 UTF-8 编码，所有 Java 文件、资源文件、配置文件禁止使用其他编码
5. IDEA 配置已自动开启依赖源码和 Javadoc 下载，无需手动配置

## 九、作者信息
- 代码作者：Administrator
