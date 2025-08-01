# PrimeCard Hub 项目规范文档

## 1. 项目概述

PrimeCard Hub 是一个多端信用卡管理平台，包括管理端、微信小程序和鸿蒙端应用。本文档定义了项目的开发规范，以确保代码质量、团队协作效率和项目可维护性。

## 2. 项目架构

### 2.1 技术栈

#### 2.1.1 管理端

- **前端框架**：Vue.js 3.x
- **UI组件库**：Element Plus
- **状态管理**：Pinia
- **路由管理**：Vue Router
- **HTTP客户端**：Axios
- **构建工具**：Vite

#### 2.1.2 后端

- **框架**：Spring Boot 2.7.x
- **ORM**：Spring Data JPA
- **安全框架**：Spring Security
- **认证方式**：JWT
- **数据库**：H2（开发）/ MySQL（生产）
- **API文档**：Springdoc OpenAPI
- **构建工具**：Maven

#### 2.1.3 C端应用

- **微信小程序**：原生小程序框架
- **鸿蒙应用**：ArkTS + ArkUI

### 2.2 项目结构

#### 2.2.1 后端项目结构

```
backend/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/primehub/primecardadmin/
│       │       ├── config/           # 配置类
│       │       ├── controller/       # 控制器
│       │       ├── dto/              # 数据传输对象
│       │       ├── entity/           # 实体类
│       │       ├── exception/        # 异常处理
│       │       ├── repository/       # 数据访问层
│       │       ├── security/         # 安全相关
│       │       ├── service/          # 服务层
│       │       │   └── impl/         # 服务实现
│       │       ├── util/             # 工具类
│       │       └── PrimeCardAdminApplication.java  # 应用入口
│       └── resources/
│           └── application.yml       # 应用配置
├── pom.xml                           # Maven配置
└── uploads/                          # 上传文件目录
```

#### 2.2.2 前端项目结构（计划）

```
admin-frontend/
├── public/              # 静态资源
├── src/                 # 源代码
│   ├── api/             # API请求
│   ├── assets/          # 资源文件
│   ├── components/      # 公共组件
│   ├── layouts/         # 布局组件
│   ├── router/          # 路由配置
│   ├── store/           # 状态管理
│   ├── styles/          # 样式文件
│   ├── utils/           # 工具函数
│   ├── views/           # 页面组件
│   ├── App.vue          # 根组件
│   └── main.js          # 入口文件
├── .eslintrc.js         # ESLint配置
├── .prettierrc          # Prettier配置
├── index.html           # HTML模板
├── package.json         # 项目依赖
└── vite.config.js       # Vite配置
```

## 3. 编码规范

### 3.1 通用规范

1. **命名规范**
   - 使用有意义的、描述性的名称
   - 避免使用缩写（除非是广泛接受的缩写）
   - 避免使用单个字符的变量名（除了循环计数器）

2. **注释规范**
   - 为复杂的业务逻辑添加注释
   - 为公共API添加文档注释
   - 注释应该解释"为什么"而不是"是什么"

3. **文件组织**
   - 每个文件应该只有一个主要的类/组件/功能
   - 相关的功能应该放在同一个目录下
   - 保持文件结构清晰和一致

### 3.2 前端规范

#### 3.2.1 Vue组件规范

1. **组件命名**
   - 组件名使用PascalCase（首字母大写的驼峰式命名）
   - 页面组件以`View`结尾（如`LoginView.vue`）
   - 通用组件以功能命名（如`DataTable.vue`）

2. **组件结构**
   - 使用`<script setup>`进行组件定义
   - 组件属性顺序：props, emits, components, setup()
   - 样式使用scoped或module模式隔离

3. **模板规范**
   - 使用双引号包裹属性值
   - 使用kebab-case（短横线连接）命名自定义事件
   - 复杂的表达式应该提取为计算属性或方法

#### 3.2.2 JavaScript/TypeScript规范

1. **类型定义**
   - 为所有变量、参数和返回值定义类型
   - 使用接口（interface）定义对象结构
   - 使用类型别名（type）定义联合类型或交叉类型

2. **导入导出**
   - 使用命名导出而不是默认导出
   - 按照字母顺序组织导入语句
   - 将第三方库的导入与本地模块的导入分开

#### 3.2.3 样式规范

1. **CSS规范**
   - 使用BEM命名规范（Block__Element--Modifier）
   - 使用变量管理颜色、字体等
   - 避免使用!important

2. **响应式设计**
   - 使用相对单位（rem, em, %）而不是绝对单位（px）
   - 使用媒体查询适配不同屏幕尺寸
   - 移动优先的设计理念

### 3.3 后端规范

#### 3.3.1 Java规范

1. **命名规范**
   - 类名使用PascalCase（首字母大写的驼峰式命名）
   - 方法名和变量名使用camelCase（首字母小写的驼峰式命名）
   - 常量使用全大写，单词间用下划线分隔

2. **代码组织**
   - 每个类应该只有一个职责
   - 遵循SOLID原则
   - 使用依赖注入而不是直接实例化

#### 3.3.2 Spring Boot规范

1. **控制器规范**
   - 使用`@RestController`注解
   - 使用`@RequestMapping`定义API路径
   - 返回统一的响应格式（ApiResponseDTO）

2. **服务层规范**
   - 使用接口定义服务
   - 实现类使用`@Service`注解
   - 使用`@Transactional`管理事务

3. **数据访问层规范**
   - 使用Spring Data JPA的Repository接口
   - 使用命名约定或`@Query`注解定义查询
   - 避免在Repository中包含业务逻辑

#### 3.3.3 API规范

1. **RESTful API设计**
   - 使用HTTP方法表示操作（GET, POST, PUT, DELETE）
   - 使用复数名词表示资源（如`/users`而不是`/user`）
   - 使用HTTP状态码表示操作结果

2. **API文档**
   - 使用Springdoc OpenAPI注解记录API信息
   - 为每个API端点提供描述、参数说明和响应示例
   - 保持API文档与实际实现的一致性

## 4. 版本控制规范

### 4.1 Git工作流

1. **分支管理**
   - `main`：主分支，保持稳定，随时可发布
   - `develop`：开发分支，包含最新的开发代码
   - `feature/*`：功能分支，用于开发新功能
   - `bugfix/*`：修复分支，用于修复非紧急bug
   - `hotfix/*`：热修复分支，用于修复生产环境的紧急bug
   - `release/*`：发布分支，用于准备发布

2. **分支命名**
   - 功能分支：`feature/功能名称`（如`feature/user-auth`）
   - 修复分支：`bugfix/问题描述`（如`bugfix/login-validation`）
   - 热修复分支：`hotfix/问题描述`（如`hotfix/critical-security-issue`）
   - 发布分支：`release/版本号`（如`release/v1.0.0`）

### 4.2 提交规范

1. **提交信息格式**

   ```
   <type>(<scope>): <subject>
   
   <body>
   
   <footer>
   ```

2. **类型（type）**
   - `feat`：新功能
   - `fix`：修复bug
   - `docs`：文档更新
   - `style`：代码风格调整（不影响代码功能）
   - `refactor`：代码重构（不是新功能也不是修复bug）
   - `perf`：性能优化
   - `test`：添加或修改测试
   - `chore`：构建过程或辅助工具的变动

3. **范围（scope）**
   - 可选，表示修改的范围（如`auth`, `user`, `news`等）

4. **主题（subject）**
   - 简短描述，不超过50个字符
   - 使用现在时态（"add"而不是"added"）
   - 首字母不大写
   - 结尾不加句号

5. **正文（body）**
   - 可选，详细描述修改的内容
   - 使用现在时态
   - 解释为什么进行这次修改

6. **页脚（footer）**
   - 可选，用于引用相关的Issue或PR
   - 格式：`Closes #123, #456`

### 4.3 合并请求（Pull Request）规范

1. **PR标题**
   - 遵循提交信息的格式
   - 简明扼要地描述PR的目的

2. **PR描述**
   - 详细描述修改的内容和原因
   - 列出相关的Issue
   - 提供测试步骤和预期结果

3. **PR检查**
   - 确保所有自动化测试通过
   - 确保代码符合编码规范
   - 确保没有合并冲突

## 5. 测试规范

### 5.1 前端测试

1. **单元测试**
   - 使用Jest进行单元测试
   - 测试所有公共方法和组件
   - 使用模拟（mock）隔离外部依赖

2. **组件测试**
   - 测试组件的渲染和交互
   - 验证组件的props和事件
   - 测试组件的边界条件

3. **端到端测试**
   - 使用Cypress进行端到端测试
   - 测试关键用户流程
   - 模拟真实用户行为

### 5.2 后端测试

1. **单元测试**
   - 使用JUnit和Mockito进行单元测试
   - 测试所有服务方法和工具类
   - 使用模拟对象隔离外部依赖

2. **集成测试**
   - 测试控制器和数据访问层
   - 使用内存数据库进行测试
   - 验证API的请求和响应

3. **性能测试**
   - 使用JMeter进行性能测试
   - 测试系统在高负载下的表现
   - 识别和解决性能瓶颈

## 6. 安全规范

### 6.1 认证与授权

1. **用户认证**
   - 使用JWT进行无状态认证
   - 实施密码强度策略
   - 限制登录尝试次数

2. **权限控制**
   - 基于角色的访问控制（RBAC）
   - 最小权限原则
   - 定期审查权限分配

### 6.2 数据安全

1. **敏感数据处理**
   - 使用加密算法存储密码
   - 传输中的数据使用HTTPS加密
   - 实施数据脱敏策略

2. **输入验证**
   - 验证所有用户输入
   - 防止SQL注入和XSS攻击
   - 使用参数化查询

### 6.3 安全配置

1. **安全头部**
   - 设置适当的HTTP安全头部
   - 实施内容安全策略（CSP）
   - 防止点击劫持

2. **错误处理**
   - 不暴露敏感信息
   - 记录安全事件
   - 实施适当的错误响应

## 7. 部署规范

### 7.1 环境配置

1. **环境变量**
   - 使用环境变量存储配置
   - 不在代码中硬编码敏感信息
   - 为不同环境提供不同的配置

2. **配置文件**
   - 使用YAML格式的配置文件
   - 配置文件应该版本控制
   - 敏感配置应该加密

### 7.2 CI/CD流程

1. **持续集成**
   - 每次提交都触发自动化测试
   - 代码质量检查
   - 构建和打包

2. **持续部署**
   - 自动部署到测试环境
   - 手动批准生产环境部署
   - 部署后验证

### 7.3 监控与日志

1. **应用监控**
   - 监控应用性能和可用性
   - 设置适当的告警阈值
   - 定期审查监控数据

2. **日志管理**
   - 集中式日志收集
   - 结构化日志格式
   - 日志轮转和保留策略

## 8. 文档规范

### 8.1 代码文档

1. **注释规范**
   - 使用JSDoc（前端）或Javadoc（后端）格式
   - 为公共API提供完整的文档
   - 解释复杂的算法和业务逻辑

2. **README文件**
   - 提供项目概述
   - 包含安装和运行说明
   - 列出主要功能和技术栈

### 8.2 API文档

1. **API描述**
   - 使用OpenAPI规范
   - 为每个端点提供详细描述
   - 包含请求参数和响应格式

2. **示例和测试**
   - 提供API调用示例
   - 包含常见错误和处理方法
   - 提供测试环境

## 9. 性能优化规范

### 9.1 前端优化

1. **加载优化**
   - 代码分割和懒加载
   - 资源压缩和合并
   - 使用CDN加速静态资源

2. **渲染优化**
   - 避免不必要的重渲染
   - 使用虚拟列表处理大数据集
   - 优化关键渲染路径

### 9.2 后端优化

1. **数据库优化**
   - 使用适当的索引
   - 优化查询语句
   - 实施数据库连接池

2. **缓存策略**
   - 使用Redis缓存热点数据
   - 实施多级缓存策略
   - 定期清理过期缓存

## 10. 项目管理

### 10.1 任务管理

1. **任务分配**
   - 明确任务责任人
   - 设定合理的截止日期
   - 跟踪任务进度

2. **优先级管理**
   - 使用MoSCoW方法（Must, Should, Could, Won't）
   - 定期审查和调整优先级
   - 关注高价值任务

### 10.2 沟通协作

1. **会议规范**
   - 每日站会（15分钟）
   - 迭代计划会（每两周）
   - 迭代回顾会（每两周）

2. **文档共享**
   - 使用共享文档平台
   - 保持文档的更新和一致
   - 确保文档的可访问性

## 11. 附录

### 11.1 常用工具

1. **开发工具**
   - IDE：IntelliJ IDEA（后端）、VS Code（前端）
   - 版本控制：Git
   - API测试：Postman

2. **质量工具**
   - 代码检查：ESLint（前端）、Checkstyle（后端）
   - 代码格式化：Prettier（前端）、Google Java Format（后端）
   - 测试覆盖率：Istanbul（前端）、JaCoCo（后端）

### 11.2 参考资源

1. **官方文档**
   - [Vue.js文档](https://vuejs.org/)
   - [Spring Boot文档](https://spring.io/projects/spring-boot)
   - [Element Plus文档](https://element-plus.org/)

2. **编码规范**
   - [Airbnb JavaScript风格指南](https://github.com/airbnb/javascript)
   - [Google Java风格指南](https://google.github.io/styleguide/javaguide.html)
   - [Vue风格指南](https://vuejs.org/style-guide/)