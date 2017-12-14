 
Component

	Mybatis
 	Logback
	
Getting Start 

1. Create Query on Mysql
 CREATE TABLE `mvc_board` ( `bId` bigint(20) NOT NULL AUTO_INCREMENT, `bName` varchar(20) DEFAULT NULL, `bTitle` varchar(100) DEFAULT NULL, `bContent` varchar(300) DEFAULT NULL, `bDate` datetime DEFAULT CURRENT_TIMESTAMP, `bHit` int(11) DEFAULT '0', `bGroup` int(11) DEFAULT NULL, `bStep` int(11) DEFAULT NULL, `bIndent` int(11) DEFAULT NULL, `deleteFlag` int(11) NOT NULL DEFAULT '0', PRIMARY KEY (`bId`) ) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
 
2. classpath:config/spring/context-datasource.xml 
	setting db URL, UserName, UserPassword

3. Run Test
