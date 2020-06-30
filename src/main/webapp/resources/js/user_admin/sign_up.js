$(document).ready(function () {
    $("#semail").blur(function () {
        let email=$("#semail").val()
        $.ajax({
            type:"GET",
            url:'/checkUserId',
            async:true,
            data:{"userId":email},
            dataType:"json",
            success:function (data) {
                let s=data.success
                if(s){
                    alert("账户已存在")
                }else{

                }
            },
            error:function () {
                console.log("请求失败")
            }
        })
        $(".form-control-submit-button").click(function () {
            let email=$('#semail').val()
            let username=$('#sname').val()
            let password=$('#spassword').val()
            let gender='未知'
            $.ajax({
                type:"GET",
                url:'/userSignUp',
                async:true,
                data:{"userId":email,"username":username,"password":password,"gender":gender},
                dataType:"json",
                success:function (data) {
                    let s=data.success
                    if(s){

                    }else{
                        alert("请稍后重试")
                    }
                },
                error:function () {
                    console.log("请求失败")
                }
            })
        })
    })
})