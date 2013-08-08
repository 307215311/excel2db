excel2db
========

excel导入数据库工具

通过XML的配置，映射EXCEL列与数据库表字段的关系。

XML的 Schema 声明请参考DOCUMENTATION\EXCEL2DB.xsd中。

E2D类是程序的入口。

通过实现ValueHandler接口的todo方法，可以对EXCEL列数据库进行自定义处理。

