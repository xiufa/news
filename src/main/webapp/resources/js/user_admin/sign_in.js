$(document).ready(function () {
    $("#userId").blur(function () {
        let userId=$("#userId").val()
        $.ajax({
            type:"GET",
            url:'/checkUserId',
            async: true,
            data:{"userID":userId},
            dataType: "json",
            success:function (data) {
                let s=data.success
                if(s){

                }else{
                    alert("用户不存在")
                    $("#userID").empty()
                }
            },
            error:function () {
                console.log("请求失败")
            }
        })
    })
    $("#send-btn").click(function () {
        let userId=$("#userId").val()
        let password=$('#password').val()
        $.ajax({
            type:"GET",
            url:'/userSignIn',
            async:true,
            data:{"userId":userId,"password":password},
            dataType:"json",
            success:function (data) {
                let s=data.success
                if(s){

                }else{
                    alert("用户名或密码错误")
                    $("#userID").empty()
                    $("#password").empty()
                }
            },
            error:function () {
                alert("请求失败，请重试")
            }
        })
    })
})