---

# SpringBootX-Template 🚀

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.3.12.RELEASE-brightgreen)
![Java](https://img.shields.io/badge/Java-8-orange)
![License](https://img.shields.io/badge/License-MIT-blue)
![Maven](https://img.shields.io/badge/Maven-3.6%2B-yellowgreen)

**SpringBootX-Template** 是一个基于 **Spring Boot 2.3.12.RELEASE** 的企业级开发脚手架，专为 JDK 1.8 环境优化，集成了主流中间件与最佳实践，助力快速构建高可维护性应用。

---

## 功能特性 ✨

### **核心功能**
• ✅ **统一响应封装**：`Result<T>` 格式标准化，全局异常处理兼容 Spring Boot 2.3.x 的错误响应策略
• ✅ **安全认证**：JWT 集成 + Spring Security 5.3 配置，支持 RBAC 权限模型
• ✅ **数据持久化**：MyBatis-Plus 3.4.x + 动态多数据源切换（MySQL/H2）
• ✅ **缓存与锁**：Redis 6.x 缓存模板 + Redisson 分布式锁实现
• ✅ **日志管理**：Logback 日志分级，兼容 ELK 收集

### **开发提效**
• 🛠️ **API 文档**：Swagger2 集成（Springfox 2.9.2），自动生成 RESTful 接口文档
• 🛠️ **多环境配置**：`dev`/`test`/`prod` 环境隔离，支持 `spring.profiles.active` 切换
• 🛠️ **热部署支持**：DevTools 配置优化，`spring.devtools.restart.trigger-file` 指定触发文件

---

## 技术栈 🛠️

| **类别**       | **组件**                                                                 |
|----------------|--------------------------------------------------------------------------|
| **核心框架**   | Spring Boot 2.3.12.RELEASE、Spring Framework 5.2.15.RELEASE       |
| **安全框架**   | Spring Security 5.3.x                                                    |
| **持久层**     | MyBatis-Plus 3.4.3.1、Druid 1.1.21（连接池）                          |
| **缓存**       | Redis 6.x、Redisson 3.16.0                                               |
| **工具库**     | Lombok、Hutool、Jackson                                                   |
| **构建工具**   | Maven 3.6+                                                              |

---

## 环境要求 💻

• **JDK 1.8**（必须，兼容性已验证）
• **MySQL 5.7+** 或 **H2 1.4.200**
• **Redis 6.0+**
• **Maven 3.6+**

---

## 项目结构 📂

```bash
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── yourcompany/
│   │           ├── config/        # 配置类（数据源、安全、线程池等）
│   │           ├── controller/    # REST API 层（@RestController）
│   │           ├── entity/        # JPA/MyBatis-Plus 实体类
│   │           ├── mapper/        # MyBatis 数据访问层（@Mapper）
│   │           ├── service/       # 业务逻辑层（接口+实现分离）
│   │           ├── utils/        # 工具类（加密、日期处理等）
│   │           └── Application.java # 启动类
│   └── resources/
│       ├── static/      # 静态资源
│       ├── mapper/      # MyBatis XML 文件
│       ├── application.yml       # 主配置
│       └── application-dev.yml  # 开发环境配置
├── test/                # 单元测试（JUnit 4）
└── pom.xml              # Maven 依赖管理
```

---

## 快速开始 🚴

### **1. 克隆项目**
```bash
git clone https://github.com/yourname/springbootx-template.git
```

### **2. 配置数据库**
修改 `application-dev.yml`：
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/yourdb?useSSL=false&serverTimezone=Asia/Shanghai
    username: root
    password: yourpassword
    driver-class-name: com.mysql.cj.jdbc.Driver  # JDBC 8.0+ 驱动
```

### **3. 启动应用**
```bash
mvn spring-boot:run
# 或直接运行 Application.java
```

---

## 关键配置 🔧

### **Redis 连接**
```yaml
spring:
  redis:
    host: 127.0.0.1
    port: 6379
    password: yourpassword
    database: 0
```

### **Swagger 文档**
访问 `http://localhost:8080/swagger-ui.html`，需在开发环境启用：
```yaml
# application-dev.yml
springfox:
  documentation:
    swagger:
      v2:
        enabled: true
```

---

## 注意事项 ⚠️

1. **JDK 兼容性**  
   项目严格限定 JDK 1.8，升级至更高版本需调整 `pom.xml` 的 `<java.version>` 及编译器插件配置。

2. **错误响应详情**  
   Spring Boot 2.3.x 默认隐藏错误详情，如需显示需添加配置：
   ```yaml
   server:
     error:
       include-message: always
       include-binding-errors: always  # 验证错误提示
   ```

3. **依赖冲突**  
   使用 `mvn dependency:tree` 检查依赖树，避免与旧版本组件（如 Dubbo、Nacos）冲突。

---

## 参考文档 📚
• [Spring Boot 2.3 Release Notes](https://spring.io/projects/spring-boot#learn)  
• [MyBatis-Plus 文档](https://baomidou.com/)  
• [Redisson 分布式锁实现](https://github.com/redisson/redisson)  

: 开发者工具热部署配置（通过触发器文件优化开发体验）
: Spring Boot 2.3.x 错误响应策略调整
: Spring Boot 2.3.12 版本升级注意事项
: Elasticsearch 集成示例（兼容 7.6.2）
: Druid 连接池版本适配与 JDBC 驱动变更
: JDK 8 与 Spring Boot 2.x 的兼容性说明
: Spring Boot 版本与 JDK 对应关系总结
: JDK 版本修改的 Maven 配置方法