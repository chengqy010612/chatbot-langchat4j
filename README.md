# LangChat4J 聊天机器人项目

本项目基于 **langchat4j** 实现了一个聊天机器人，拥有以下关键特性：

* **基础聊天功能**：支持与用户进行自然语言对话。
* **聊天记忆**：在单次对话中保留上下文，提升对话连贯性。
* **记忆持久化**：将对话历史保存到本地/数据库，以便未来检索和分析。
* **提示词管理**：支持自定义系统、用户、助手提示词。
* **Function Calling**：通过 langchat4j 的 Function Calling 能力，调用外部或自定义函数。
* **向量数据库整合**：集成 Pinecone 向量数据库，用于语义检索。
* **流式输出**：实时输出模型生成结果，提高用户体验。


## 前端地址

* 前端仓库: [https://github.com/chengqy010612/chatbot-langchat4j-frontend](https://github.com/chengqy010612/chatbot-langchat4j-frontend)

## 视频参考

* 参考视频: [https://www.bilibili.com/video/BV1cpLTz1EVp/](https://www.bilibili.com/video/BV1cpLTz1EVp/)

---

## 目录

* [背景与动机](#背景与动机)
* [技术选型](#技术选型)
* [功能特性](#功能特性)
* [快速开始](#快速开始)

    * [环境要求](#环境要求)
    * [安装与配置](#安装与配置)
    * [运行示例](#运行示例)
* [项目结构](#项目结构)
* [配置说明](#配置说明)
* [使用说明](#使用说明)
* [扩展与贡献指南](#扩展与贡献指南)
* [许可证](#许可证)

---

## 背景与动机

随着对话式 AI 应用的普及，开发一个具备上下文记忆、插件调用、长时记忆管理等能力的机器人愈发重要。本项目基于 langchat4j 做了一些应用，帮助开发者快速创建高质量对话机器人。

## 技术选型

| 组件         | 说明                              |
| ---------- | ------------------------------- |
| Java 17+   | 项目语言及运行时环境                      |
| langchat4j | 核心对话框架，支持 Function Calling、流式输出 |
| 向量数据库      | 推荐 Pinecone/Weaviate/Milvus 等   |
| 持久化存储      | 可选文件系统、SQLite、PostgreSQL 等      |
| 日志与监控      | SLF4J + Logback                 |

## 功能特性

1. **基础聊天**

    * 接收用户输入，调用 LLM 模型（如 OpenAI GPT）并返回响应。
2. **聊天记忆**

    * 会话级别记忆：会保留当前对话上下文。
    * 长期记忆：将重要片段持久化，支持后续检索。
3. **提示词管理**

    * 支持系统、用户、助手多角色提示词。
    * 可动态插入、修改提示模板。
4. **Function Calling**

    * 声明式定义函数接口。
    * 支持自动或手动触发函数调用。
5. **向量检索**

    * 将消息或文档转为向量并存入数据库。

    * 实现基于相似度的上下文补全。 \$17. **RAG 功能**

    * 结合向量检索，实时从知识库检索相关文档或信息，并将检索结果作为上下文，辅助生成更准确的回答。

    * 实现逐步推送模型token，提升交互体验。

## 快速开始

### 环境要求

* Java 17 或更高版本
* Maven 或 Gradle
* 网络连通以访问 LLM API

### 安装与配置

1. 克隆本仓库：

   ```bash
   git clone https://github.com/yourusername/langchat4j-bot.git
   cd langchat4j-bot
   ```
2. 编辑 `src/main/resources/application.yml`：

   ```yaml
   openai:
     apiKey: "YOUR_OPENAI_API_KEY"
   vectorDb:
     type: "pinecone"
     endpoint: "YOUR_PINECONE_ENDPOINT"
     apiKey: "YOUR_PINECONE_API_KEY"
   memory:
     persistence: "sqlite"
     dbPath: "./data/memory.db"
   ```
3. 安装依赖并打包：

    * Maven：

      ```bash
      mvn clean package
      ```
    * Gradle：

      ```bash
      gradle build
      ```

### 运行示例

```bash
java -jar target/langchat4j-bot.jar
```

启动后访问 `http://localhost:8080/chat`，即可通过 Web 界面或 API 交互。

## 项目结构

```
langchat4j-bot/
├── src/
│   ├── main/
│   │   ├── java/           # 核心代码
│   │   └── resources/      # 配置文件
│   └── test/               # 单元测试
├── pom.xml / build.gradle  # 构建配置
└── README.md               # 项目说明
```

## 配置说明

* `application.yml`：全局配置文件，包含 API Key、数据库等。
* `PromptTemplates.java`：提示词模板管理。
* `FunctionRegistry.java`：函数调用接口注册。

## 使用说明

1. **发送消息**：调用 `/chat` 接口，传入 JSON `{ "message": "你好" }`。
2. **获取历史**：调用 `/history`，返回当前会话上下文。
3. **检索记忆**：调用 `/memory/search?query=xxx`，返回相关持久化记忆。

## 扩展与贡献指南

欢迎提出 Issue 或 Pull Request：

1. Fork 本仓库
2. 新建分支：`git checkout -b feature/xxx`
3. 提交代码并推送：`git push origin feature/xxx`
4. 在 GitHub 上发起 Pull Request

请确保所有新增功能有相应测试，并遵循项目编码规范。

## 许可证

本项目采用 MIT 许可证，详见 [LICENSE](LICENSE)。
