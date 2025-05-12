# 文件管理、操作工具的模块

## 一、模块简介
该模块欲整合并提供了一系列文件管理与操作的工具类，涵盖文件的创建、读写、复制、移动、删除、压缩、解压等功能。同时，还提供了文件路径管理及大小计算的工具。

## 二、使用说明

### 1.根据Gradle版本或项目配置自行决择在合适的位置添加仓库地址
```groovy
maven {
    // jitpack仓库
    url 'https://jitpack.io' 
}
```

### 2.在 `build.gradle` (Module 级) 中添加依赖：
```groovy
dependencies {
    implementation 'com.github.moyuxinyi:file-util:1.0.0'
}
```

```kotlin
dependencies {
    implementation("com.github.moyuxinyi:file-util:1.0.0")
}
```

## 三、目录结构
```text
com/
└── zt/
    └── file/
        ├── entity/
        │   └── FileEntity.java           // 文件信息实体
        ├── io/
        │   ├── FileUtil.java             // 基础文件工具类（获取 File 对象、存在性、扩展名等）
        │   ├── FileOperation.java        // 文件创建、读取、写入、重命名、删除操作
        │   ├── FileCopyMove.java     // 文件/目录复制与移动操作
        │   ├── FileSizeUtil.java         // 文件/目录大小计算及格式化
        │   ├── FileListUtil.java         // 目录文件列表读取及行读取操作
        │   └── FileIOUtil.java           // 文件 IO 操作工具（流写入）
        │── path/
        │   └── AppFilePathUtil.java      // 获取应用文件路径的工具类
        └── zip/
            ├── StandardZipUtil.java      // 基于 java.util.zip 的标准压缩和解压功能（不支持加密）
            └── EncryptedZipUtil.java     // 基于`Zip4j`库封装最新版本提供加密压缩、分卷压缩和带进度回调的解压操作
```

**更多的使用方式还请参考源码**

## 四、版本变更记录

### V1.0.0 (2025-03-31)
- 初始版本，提供基础文件管理、路径管理、压缩解压等工具类