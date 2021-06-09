// pages/clock/clock.js
const db=wx.cloud.database()
Page({
  /**
   * 页面的初始数据
   */
  data: {
    markers: [{
      id:0,
      name:"",
      address:"",
      latitude: 26.08198,
      longitude: 119.30405,
      width: 40,
      height: 40,
      mHidden:true
  }],
  locallatitude: 0, //纬度
  locallongtitude: 0, //经度
  start: 0,
  over: 0
  },
  btnTap:function(){
    this.setData({
      mHidden:!this.data.modalHidden
    })
  },
  changeModel:function(){
    this.setData({
      mHidden:!this.data.modalHidden
    })
  },
  modelCancel:function(){
    this.setData({
      mHidden:!this.data.modalHidden
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.getLocation({
      type: 'wgs84',
      success: (res) => {
        var latitude = res.latitude
        var longitude = res.longitude
        this.setData({
          locallatitude: latitude,
          locallongtitude: longitude
        })
      }
    })
  },
  clickMap(e){
    console.log("点击地图上的标记点", e.currentTarget.dataset.marker)
    let marker =  e.currentTarget.dataset.marker  //定义一个变量来接收目的地位置
    console.log(this.data.locallatitude);
    // let wd = this.data.locallatitude - 
    // let jd = this.data.locallongtitude -  
    wx.getLocation({  //获取当前位置
      type: 'wgs84',
      success (res) {
      // const latitude = res.latitude
      // const longitude = res.longitude
      // const speed = res.speed
      // const accuracy = res.accuracy
      console.log("当前位置", res)
    //   wx.openLocation({ //地图上搜索目的地    //点击目的地会调用地图
    //   latitude: marker.latitude,
    //   longitude: marker.longitude,
    //   name: marker.name,
    //   address: marker.address,
    //   scale:18
    // })
      },
      fail(res) {
        console.log("获取位置失败！" , res)
        //弹窗
        wx.showModal({
          title: '需要授权',
          content:"需要授权，请设置",
          confirmText:"去设置",
          success(res){
            console.log("弹窗点击", res)
            if(res.confirm){  //如果点击了 去设置   下面就打开 设置
              wx.openSetting()
            }
          }
        })
      }
      })
},
//打卡
start(){
  // 纬度，经度 
    //图书馆  26.075178,119.272139
   if((this.data.locallatitude-26.075178) > -0.1  & (this.data.locallongtitude-119.272139) < 0.1 ){
    wx.showModal({
      title: '提示',
      content: '打卡成功。',
      success:(res)=>{
        let key = this.getNianYuiRi()   //调用下面的方法
        console.log('时间：',key)
        console.log(this.data.locallatitude);
        //添加打卡开始时间到数据库中
        db.add({
          data: {
             key:key,
             type:"start"
          }
       }).then(res => {
          console.log('添加成功', res)
          // this.getNum()    //调用 排号信息
       }).catch(res => {
           console.log('添加失败', res)
       })
      }
    })
  }else{
    wx.showModal({
      title: '提示',
      content: '打卡失败，不在范围内。'
    })
  }
},
//获取当前的年月日   定义一个方法
getNianYuiRi(){
  let date = new Date()
  let hours = date.getHours()
  let minutes = date.getMinutes()
  let seconds = date.getSeconds()
  let key = (hours * 60) + minutes + (seconds / 60)
  return parseInt(key)
},
//获取数据库中最新的开始打卡时间
getstarttime(){
  db.where({
    "type" : "start"
  }).get({
    success:(res) => {
      var startlength = res.data.length
      // console.log(res.data[startlength-1].key);
      this.setData({
        start: res.data[startlength-1].key
      })
    }
  })
},
over(){
  wx.navigateTo({
    url: '/pages/clock/clock',
  })
},
/**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // this.formSubmit();
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
    this.formRequst();
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
  },
  over(){
    wx.navigateTo({
      url: '/pages/clock/clock',
    })
}
})