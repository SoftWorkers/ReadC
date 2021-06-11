// pages/rank/rank.js
const db=wx.cloud.database()
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    user:"",
    user1:"",
    user2:"",
    user3:"",
    user4:"",
    user5:"",
    user6:""
  },
  jumpPwd(event){
    wx.navigateTo({
      url: '../pwd/pwd',
    })
  },
  getData(){
    let loginAccount = app.userName
    console.log(loginAccount)
    db.collection("read").where({
      loginAccount:"211806230"
    }).get({
        success:res=>{
           console.log("获取数据成功", res)
            this.setData({
              user:res.data[0]
            })
        },
    })
    db.collection("read").where({
      loginAccount:"211806242"
    }).get({
        success:res=>{
           console.log("获取数据成功", res)
            this.setData({
              user1:res.data[0]
            })
        },
    })
    db.collection("read").where({
      loginAccount:"211808672"
    }).get({
        success:res=>{
           console.log("获取数据成功", res)
            this.setData({
              user2:res.data[0]
            })
        },
    })
    db.collection("read").where({
      loginAccount:"211806139"
    }).get({
        success:res=>{
           console.log("获取数据成功", res)
            this.setData({
              user3:res.data[0]
            })
        },
    })
    db.collection("read").where({
      loginAccount:"211806157"
    }).get({
        success:res=>{
           console.log("获取数据成功", res)
            this.setData({
              user4:res.data[0]
            })
        },
    })
    db.collection("read").where({
      loginAccount:"211806184"
    }).get({
        success:res=>{
           console.log("获取数据成功", res)
            this.setData({
              user5:res.data[0]
            })
        },
    })
    db.collection("read").where({
      loginAccount:"211806131"
    }).get({
        success:res=>{
           console.log("获取数据成功", res)
            this.setData({
              user6:res.data[0]
            })
        },
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getData()
    console.log(this.data.user)
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})