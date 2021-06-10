// pages/clock/clock.js
const db=wx.cloud.database()
var app =getApp()
Page({
  /**
   * 页面的初始数据
   */
  data: {
    user:"",
    count:0,
    loginAccount:''
  },
  getData(){
    let loginAccount = app.userName
    console.log(loginAccount)
    db.collection("read").where({
      loginAccount:loginAccount
    }).get({
        success:res=>{
           console.log("获取数据成功", res)
            this.setData({
              user:res.data[0]
            })
        },
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getData()
  },
start(){
         let  count=this.data.user.count
         console.log(this.data.user.loginAccount)
         console.log(count)
          wx.showModal({
            title: '提示',
            content: '打卡成功。'})
            this.updatedata()               
        
        },
   updatedata(){
     this.getData()
    let  count=this.data.user.count
    let loginAccount = app.userName
    db.collection("read").where({
      loginAccount:loginAccount
    }).update({
     data:{
       count:count+1
     }
    }).then(res=>{
      console.log(res)
    })
     },
      
  onShow: function () {
 
  },
})