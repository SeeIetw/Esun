# Esun

esun 資料夾為前端專案使用 Vue.js 框架做開發，可在使用 npm run serve 指令啟動伺服器，port 為 6999，可在 vue.config.js 中做更改。

Esunapi 資料夾為後端專案使用 springboot + mybatis-plus 在 Intellij 上開發，port 為 8080。
其中 mybatis-plus 框架透過繼承 BaseMapper 類別來完成簡易的 CRUD 以及防範 SQL injection，可以從 log 中看到。
由於簡易 CRUD 都被繼承了，我只需要實作一個 Stored Procedure。

Database Configuration 在 Esunapi/src/main/resources 資料夾中的 application.yml 可以設定。