# mock-admin
# 介绍

待业空窗期emmmmm......

mock在测试中经常用到，能够保障自动化case的稳定性、解决上下游（第三方）服务依赖问题、构造异常数据。

该代码库为管理端，即页面增删改查所需接口的功能实现

mock-core代码库：https://github.com/Ammar-hj/mock-core

#快速开始
1、拉取代码  

        git pull

2、修改resource中application.properties配置

    创建数据库，SQL在resource目录下
    数据库/redis连接配置修改
    前端代码修改 - 暂未写前端
    核心服务地址修改
    log4j2.xml文件baseDir路径修改

3、编译产出 mvn clean package

4、启动服务
    
    nohup java -jar mock-learn-0.0.1-SNAPSHOT.jar >/dev/null 2>/dev/null &
    启动后日志会在log4j2.xml指定的路径下生成日志目录

后续

    1、增加用户区分管理能力