# CoinDesk 面試題目
> 用於國泰面試 Java 後端用
> 
> 本專案架構為簡潔架構 Clean Architectre
> 使用 Spring Boot 和 Maven 開發
> 總共包含 API 共六支
> 本專案包含單元測試
> - [sql 語法](src/main/resources/db/data.sql) 於本專案內供 H2 初始化資料庫
> - [Postman](CUBE.postman_collection.json) 包含本次測試 API
----------
## 開發環境
- intelliJ
- jdk1.8.0_202
- Maven
### dependency 
- Spring Data JPA
- Spring Boot: 2.7.17
- H2
----------
## API 功能
- **新增幣別對應資料**
- **更新幣別對應資料**
- **刪除幣別對應資料**
- **取得所有幣別對應資料**
- **呼叫 Coindesk 取得資料**
- **呼叫 Coindesk 取得資料並轉換**
----------
## 單元測試
- adapter 層的 ControllerImpl
- application 層的 UseCaseImpl
- domain 層的 Domain
----------
## 其他資訊
- [sql 語法](src/main/resources/db/data.sql) 於本專案內供 H2 初始化資料庫
- [Postman](CUBE.postman_collection.json) 包含本次測試 API
