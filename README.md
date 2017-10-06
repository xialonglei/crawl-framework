spring+mybatis+maven
# crawl-framework
一个低功能的小型爬虫框架，功能很简陋，主要功能如下：
1. <p> 支持多级爬取(url->urls->内容)，并且父级网页可以向子类网页传递参数（这个现在只支持两级）</p>
2. <p> 没有界面的，需要在Bootstrap类中自己配置抓取规则，最终爬取的数据进入MySQL数据库</p>
3. <p> 现在只能解析html页面，不支持json、xml等格式，解析html页面的工具为jsoup</p>
4. <p> 需要自己建立数据库表</p>
5. <p> 配置完抓取规则，需要自己编写数据入库程序</p>

* 需要在com.xll.importdb下建立一个新的类，类名：实体类名+Import 
* 重写assemblyStoreDatas方法，不需要从零开始写，只需要将入库的实体类换成自己想要入库的实体类，不需要写代码 
* 针对非String类型的字段，需要自己加上field.getType().getCanonicalName().equals("java.lang.Boolean")来赋值 
* 只需要针对Bootstrap、PageCrawlThread类进行修改，其他的类不需要修改，PageCrawlThread类只需要修改(改成自己入库类) 

```
//开始执行入库
DubboSchemaImport dubboSchemaExport = new DubboSchemaImport();
dubboSchemaExport.assemblyStoreDatas(pageCrawlRule , content);
```
6. <p> 程序我爬取了阿里dubbo_schema，下面是dubbo_schema的DDL</p>

```
CREATE TABLE `dubbo_schema` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `attri` varchar(64) DEFAULT '' COMMENT '属性',
  `url_para` varchar(64) DEFAULT '' COMMENT '对应URL参数',
  `attri_type` varchar(32) DEFAULT '' COMMENT '类型',
  `is_write` bit(1) DEFAULT b'0' COMMENT '是否必填 （1：是，0：否）',
  `default_value` varchar(1000) DEFAULT '' COMMENT '缺省值',
  `func` varchar(64) DEFAULT '' COMMENT '作用',
  `descript` varchar(255) DEFAULT '' COMMENT '描述',
  `compatible_ability` varchar(64) DEFAULT '' COMMENT '兼容性',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `title` (`title`,`attri`)
) ENGINE=InnoDB AUTO_INCREMENT=194 DEFAULT CHARSET=utf8;
```
7. 启动程序Bootstrap，就能将dubbo_schema数据入库到dubbo_schema表中，这里有一个不好的地方就是我有些字段没有表明not null，自己可以修改下加上默认值
  
