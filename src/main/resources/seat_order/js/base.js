User = {
    //用于存放用户
    user : null,
    userTypes : null,
    //登录
    login : function(juser){
        user = juser;
        //将用户信息存储
        sessionStorage.setItem("user", JSON.stringify(juser));
    },
    //存入用户权限
    setuserType : function(userTypes){
        //将用户类型存进去
        sessionStorage.setItem("userType", JSON.stringify(userTypes));
    },
    //登出
    logout : function () {
        user = null;
        //删除用户的存储信息
        sessionStorage.removeItem("user");
    },
    //回显
    getUser : function () {
        //获取存储的用户信息
        var juser = sessionStorage.getItem("user");
        var userType = sessionStorage.getItem("userType");
        if(juser == null || juser == "undefined"){
            return false;
        }
        if(userType == null || userType == "undefined"){
            return false;
        }
        User.user = JSON.parse(juser);
        User.userTypes = JSON.parse(userType);
        return true;
    }
}
$(document).ready(function () {
    User.getUser();
    alert("Hi," + User.user.username);
    $("#over").delegate('#logout', 'click', function () {
        layer.confirm('是否退出?', {
            icon : 3,
            title : '提示'
        }, function (index) {
            logout();
            layer.close(index);
        });
    });
});