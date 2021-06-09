// pages/login/login.js
const db=wx.cloud.database()
Page({
  data: {
    loginAccount: 0,
    passwd: ''
  },
  jumpPage(event){
    wx.navigateTo({
      url: '../num/num',
    })
  },
  jumpPa(event){
    wx.navigateTo({
      url: '../home/home',
    })
  },
  //获取用户名
  getName(event){
    console.log('获取输入的用户名',event.detail.value)
    this.setData({
      loginAccount:event.detail.value
    })
  },
  getPasswd(event){
    console.log('获取输入的用户名',event.detail.value)
    this.setData({
      passwd:event.detail.value
    })
  },
  login(){
    let loginAccount = this.data.loginAccount
    let passwd = this.data.passwd
    console.log('账号', loginAccount, '密码', passwd)

    //校验账号
    if(loginAccount.length < 9){
        wx.showToast({
           icon:'none',
          title: '学号至少9位',
        })
        return
    }
    //登录操作
    db.collection("read").where({
      loginAccount:loginAccount
    }).get({
        success(res){
            console.log("获取数据成功", res)
            let user = res.data[0]
            console.log("user", user)
            //密码校验
            if(passwd == user.passwd){
                console.log('登录成功')
                wx.showToast({
                  title: '登录成功',
                })
                wx.navigateTo({
                  url: '../home/home',
                })
            }else{
                console.log('登录失败')
                wx.showToast({
                  icon:'none',
                  title: '账号或密码不正确',
                })
            }
        },
        fail(res){
            console.log("获取数据失败", res)
        }
    })
  }
})