# CoinDesk 面試題目
> 用於國泰面試 Java 後端用
> 
> 這是一個使用 Spring Boot 和 Maven 開發的 Java 專案
----------
## 開發環境
- **開發工具**：intelliJ
- **Java**: jdk1.8.0_202
- **構建工具**: Maven
- **Postman**
### dependency 
- Spring Data JPA
- Spring Boot: 2.7.17
- H2
----------
## 功能
- **新增幣別對應資料**
- **更新幣別對應資料**
- **刪除幣別對應資料**
- **取得所有幣別對應資料**

- **呼叫 Coindesk 取得資料**
- **呼叫 Coindesk 取得資料並轉換**
----------
## 其他資訊
- [sql 語法](src/main/resources/db/data.sql) 於本專案內供 H2 初始化資料庫
- [Postman](CUBE.postman_collection.json) 包含本次測試 API
