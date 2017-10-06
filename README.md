# crawl-framework
一个低功能的小型爬虫框架，功能很简陋，主要功能如下：
<p> 支持多级爬取(url->urls->内容)，并且父级网页可以向子类网页传递参数（这个现在只支持两级）</p>
<p> 没有界面的，需要在Bootstrap类中自己配置抓取规则，最终爬取的数据进入MySQL数据库</p>
<p> 现在只能解析html页面，不支持json、xml等格式，解析html页面的工具为jsoup</p>
<p> 需要自己建立数据库表</p>
<p> 配置完抓取规则，需要自己编写数据入库程序</p>
*   需要在com.xll.importdb下建立一个新的类，类名：实体类名+Import
*   重写assemblyStoreDatas方法，不需要从零开始写，只需要将入库的实体类换成自己想要入库的实体类，不需要写代码
*   针对非String类型的字段，需要自己加上field.getType().getCanonicalName().equals("java.lang.Boolean")来赋值
*   只需要针对Bootstrap、PageCrawlThread类进行修改，其他的类不需要修改，PageCrawlThread类只需要修改(改成自己入库类)
```
//开始执行入库
DubboSchemaImport dubboSchemaExport = new DubboSchemaImport();
dubboSchemaExport.assemblyStoreDatas(pageCrawlRule , content);
```
  
