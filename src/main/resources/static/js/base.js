User = {
    //用于存放用户
    user: null,
    /*userTypes : null,*/
    //登录
    login: function (juser) {
        user = juser;
        //将用户信息存储
        sessionStorage.removeItem("user");
        sessionStorage.setItem("user", JSON.stringify(juser));
    },
    //存入用户权限
    /* setuserType : function(userTypes){
         //将用户类型存进去
         sessionStorage.setItem("userType", JSON.stringify(userTypes));
     },*/
    //登出
    logout: function () {
        user = null;
        //删除用户的存储信息
        sessionStorage.removeItem("user");
    },

    //回显
    getUser: function () {
        //获取存储的用户信息
        var juser = sessionStorage.getItem("user");
        if (juser == null || juser == "undefined") {
            $.ajax({
                type: "POST",//请求方式
                url: "/login/getUserFromSession",//发送请求的地址
                async: false,//请求为同步请求
                success: function (res) {//成功时调用的回调函数
                    // 返回操作是否成功
                    if (res.code === 100) {
                        var a = res.data.user;
                        sessionStorage.removeItem("user");
                        sessionStorage.setItem("user", JSON.stringify(a));
                        User.user = JSON.parse(sessionStorage.getItem("user"));
                    } else {
                        return null;
                    }
                },
                error: function () {//失败时被调用的函数
                    alert("您的开始使用时间应在预约时的15分钟之内!");
                }
            });
        } else {
            User.user = JSON.parse(juser);
        }
        return true;
    }
}
$(document).ready(function () {
    User.getUser();
    $("#over").delegate('#logout', 'click', function () {
        layer.confirm('是否退出?', {
            icon: 3,
            title: '提示'
        }, function (index) {
            logout();
            layer.close(index);
        });
    });
});