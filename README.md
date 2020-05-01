API：
注册的json样例：

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
    	"guest_id":"17080211",
    	"msg_type":100
    }