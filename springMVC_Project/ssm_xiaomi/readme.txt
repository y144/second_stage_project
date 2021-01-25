
SSM整合步骤:
1)新建maven工程,添加相关的依赖
2)整改目录结构,修改web.xml版本
3)添加可视化
4)添加所有的静态资源,拷贝到webapp目录下
5)在resources目录中添加SqlMapConfig.xml,db.properties,applicationContex_dao.xml,applicationContext_service.xml,springmvxc.xml文件的创建
6)开发以上所有的配置文件
7)在web.xml文件中进行spring,springmvc框架的注册
8)在web.xml添加字符编码过滤器
9)添加pojo和mapper文件.这时借助于mybatis的逆向工程自动生成
10)添加service的业务实现接口和实现类
11)添加controller的实现,先实现登录功能
12)进行功能测试

