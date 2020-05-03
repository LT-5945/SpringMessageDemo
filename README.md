一、建表（数据库名称为CISCN）
数据库SQL脚本：
  
  `CREATE TABLE `message` (
     `msg_id` varchar(45) NOT NULL,
     `host_id` varchar(45) NOT NULL,
     `guest_id` varchar(45) NOT NULL,
     `message` varchar(45) NOT NULL,
     `msg_type` int(11) NOT NULL,
     PRIMARY KEY (`msg_id`),
     UNIQUE KEY `msg_id_UNIQUE` (`msg_id`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci`
   
  `CREATE TABLE `user` (
     `uid` varchar(45) NOT NULL,
     `username` varchar(45) NOT NULL,
     `password` varchar(45) NOT NULL,
     `phone_num` varchar(45) DEFAULT NULL,
     `friend_uid_list` varchar(45) DEFAULT NULL,
     PRIMARY KEY (`uid`),
     UNIQUE KEY `username_UNIQUE` (`username`),
     UNIQUE KEY `uid_UNIQUE` (`uid`),
     UNIQUE KEY `phone_num_UNIQUE` (`phone_num`)
   ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci`

二、生成测试样例

- 注册几个用户

- 加几个好友

- 发几个消息

API：
注册的json样例：

注意：uid，username和phoneNum都是唯一的

http://localhost:8080/signin

    {
    
    	"uid":"17080211",    	
    	"username":"py",    	
    	"password":"123",    	
    	"phoneNum":"13581955945"
    	
    }

登陆的json样例：


http://localhost:8080/login

    {
    
    	"uid":"17080213",    	
    	"password":"123"
    	
    }

加好友的json样例：

http://localhost:8080/findfriend

    {
    
	    "uid":"17080213",	    
    	"friend_uid":"17080212"
    	
    }
    
发送消息的json样例：

http://localhost:8080/send

    {
    	"host_id":"17080214",
    	"guest_id":"17080211",
    	"message":"You are a guest user!",
    	"msg_type":100
    }
    
查询消息的json样例：

http://localhost:8080/getMsg

    {
    	"host_id":"17080213",
    	"guest_id":"17080211"
    }
    
