
<template>
<view>
<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
	<view class="content">
		<view class="container" :style='{"width":"100%","padding":"0px","position":"relative","background":"#ffffff","height":"auto"}'>
						<swiper :style='{"width":"100%","background":"#ffffff","height":"400rpx"}' class="swiper" :indicator-dots='true' :autoplay='true' :circular='true' indicator-active-color='#ffffff' indicator-color='#6484ff30' :duration='500' :interval='5000' :vertical='false'>
				<swiper-item :style='{"width":"100%","textAlign":"center","background":"#ffffff","height":"100%"}' v-for="(swiper,index) in swiperList" :key="index">
					<img :style='{"width":"100%","padding":"0","objectFit":"contain","background":"#3da742","display":"block","height":"100%"}' mode="aspectFill" v-if="swiper.substring(0,4)=='http'" :src="swiper"></img>
					<img :style='{"width":"100%","padding":"0","objectFit":"contain","background":"#3da742","display":"block","height":"100%"}' mode="aspectFill" v-else :src="baseUrl+swiper"></img>
				</swiper-item>
			</swiper>
									            <view :style='{"padding":"24rpx 24rpx 24rpx 24rpx","flexWrap":"wrap","background":"#ffffff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}' class="detail-content">
				<view :style='{"padding":"0 40rpx 0 40rpx","margin":"0 0 0px 0","borderColor":"#cccccc","borderRadius":"0px 0 0 0px","borderWidth":"0 0 0px 0","background":"#3da74210","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"space-between","height":"80rpx"}' class="detail-list-item price priceFavor">
					<view :style='{"width":"calc(100% - 100rpx)","display":"flex"}' class="text">
						<view :style='{"color":"#ff0000","lineHeight":"80rpx","fontSize":"32rpx"}'>￥</view>
						<view :style='{"color":"#ff0000","lineHeight":"80rpx","fontSize":"32rpx"}'>{{detail.price}}</view>
					</view>
					<view :style='{"width":"48rpx","lineHeight":"80rpx","fontSize":"48rpx","color":"#3da742","display":"block","height":"48rpx"}' v-if="storeupFlag==1" class="iconfont icon-likefill2" @click="shoucang"></view>
					<view :style='{"width":"48rpx","lineHeight":"80rpx","fontSize":"48rpx","color":"#3da742","display":"block","height":"48rpx"}' v-if="storeupFlag==0" class="iconfont icon-likeline2" @click="shoucang"></view>
				</view>

				<view :style='{"margin":"12rpx 0 12rpx 0","borderColor":"#cccccc","borderWidth":"0 0 0px 0","background":"#ffffff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="detail-list-item title">
					<view :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="lable">家具名称：</view>
					<view :style='{"padding":"0px 0 0 0","margin":"0 0 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666"}' class="text">{{detail.jiajumingcheng}}</view>
				</view>

				<view class="detail-list-item" :style='{"margin":"12rpx 0 12rpx 0","borderColor":"#cccccc","borderWidth":"0 0 0px 0","background":"#ffffff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>家具类型：</view>
					<view  class="text" :style='{"padding":"0px 0 0 0","margin":"0 0 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666"}'>{{detail.jiajuleixing}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"12rpx 0 12rpx 0","borderColor":"#cccccc","borderWidth":"0 0 0px 0","background":"#ffffff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>品牌：</view>
					<view  class="text" :style='{"padding":"0px 0 0 0","margin":"0 0 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666"}'>{{detail.pinpai}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"12rpx 0 12rpx 0","borderColor":"#cccccc","borderWidth":"0 0 0px 0","background":"#ffffff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>家具颜色：</view>
					<view  class="text" :style='{"padding":"0px 0 0 0","margin":"0 0 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666"}'>{{detail.jiajuyanse}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"12rpx 0 12rpx 0","borderColor":"#cccccc","borderWidth":"0 0 0px 0","background":"#ffffff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>家具材质：</view>
					<view  class="text" :style='{"padding":"0px 0 0 0","margin":"0 0 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666"}'>{{detail.jiajucaizhi}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"12rpx 0 12rpx 0","borderColor":"#cccccc","borderWidth":"0 0 0px 0","background":"#ffffff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>家具尺寸：</view>
					<view  class="text" :style='{"padding":"0px 0 0 0","margin":"0 0 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666"}'>{{detail.jiajuchicun}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"12rpx 0 12rpx 0","borderColor":"#cccccc","borderWidth":"0 0 0px 0","background":"#ffffff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>库存：</view>
					<view  class="text" :style='{"padding":"0px 0 0 0","margin":"0 0 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666"}'>{{detail.alllimittimes}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"12rpx 0 12rpx 0","borderColor":"#cccccc","borderWidth":"0 0 0px 0","background":"#ffffff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>收藏数量：</view>
					<view  class="text" :style='{"padding":"0px 0 0 0","margin":"0 0 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666"}'>{{detail.storeupnum}}</view>
				</view>
				<view class="detail-list-item" :style='{"margin":"12rpx 0 12rpx 0","borderColor":"#cccccc","borderWidth":"0 0 0px 0","background":"#ffffff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"width":"auto","padding":"0 20rpx 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}'>点击次数：</view>
					<view  class="text" :style='{"padding":"0px 0 0 0","margin":"0 0 0 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666"}'>{{detail.clicknum}}</view>
				</view>





				<view class="detail-list-item rich" :style='{"margin":"24rpx 0 24rpx 0","borderColor":"#cccccc","borderRadius":"8rpx 0 0 8rpx","borderWidth":"0 0 0px 0","background":"#ffffff","display":"block","width":"100%","borderStyle":"solid","height":"auto"}'>
					<view class="lable" :style='{"padding":"0 24rpx 0 24rpx","margin":"0 0 12rpx","color":"#333333","textAlign":"left","background":"#3da74210","width":"100%","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}'>家具详情</view>
					<view class="rich-text" :style='{"padding":"0px 24rpx 24rpx","margin":"0 0 0 0","lineHeight":"48rpx","color":"#666666"}'>
						<rich-text :nodes="detail.jiajuxiangqing"></rich-text>
					</view>
				</view>

				<!-- 热门信息 -->
				<view class="hot" :style='{"width":"100%","background":"#ffffff","height":"auto"}'>
					<view :style='{"padding":"0","margin":"0 0 20rpx 0","borderColor":"#1d5dca","color":"#fff","textAlign":"center","borderWidth":"0 0 0 0px","background":"url(http://clfile.zggen.cn/20231123/7cb3e8fe4fa543af86d5a417a93d5347.png) no-repeat center top","width":"calc(100% - 0px)","fontSize":"28rpx","lineHeight":"136rpx","borderStyle":"solid","fontWeight":"500","height":"100rpx"}'>热门信息</view>
					<view :style='{"padding":"20rpx 24rpx 20rpx 24rpx","flexWrap":"wrap","background":"#ffffff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
						<view v-for="item in hotList" :key="item" :style='{"width":"48%","flexWrap":"wrap","background":"#ffffff","justifyContent":"center","display":"flex","height":"auto"}' @tap="onDetailTap(item)">
							<image :style='{"width":"100%","margin":"0 0 12rpx 0","objectFit":"cover","borderRadius":"8rpx","display":"inline-block","height":"200rpx"}' :src="baseUrl + (item.jiajutupian?item.jiajutupian.split(',')[0]:'')" alt=""></image>
							<view :style='{"border":"0px solid #cdf6f2","padding":"0 8rpx 0 8rpx","margin":"0 0 12rpx 0","whiteSpace":"nowrap","color":"#333333","textAlign":"center","overflow":"hidden","borderRadius":"16rpx","background":"#ffffff","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","textOverflow":"ellipsis","height":"48rpx"}'>{{item.jiajumingcheng}}</view>
							<!-- <view :style='{"width":"100%","padding":"0 8rpx 0 8rpx","lineHeight":"24rpx","fontSize":"28rpx","color":"#999999","textAlign":"right"}'>2022-02-02</view> -->
						</view>
					</view>
				</view>

				<view class="time-content" :style='{"width":"100%","padding":"0","margin":"0 0 24rpx 0","height":"auto"}'>
					<view class="comoment-header" :style='{"border":"2rpx solid #3da74250","boxShadow":"0px 0px 0px #cccccc","background":"#ffffff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
						<view :style='{"padding":"0 24rpx 0 24rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333"}'>评论</view>
						<view :style='{"padding":"0 20rpx 0 20rpx","background":"#3da742","display":"flex"}' @click="onCommentTap" class="btn-comment-content" style="display: flex;align-items: center;">
							<view :style='{"margin":"0 8rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#ffffff"}' class="iconfont icon-xinzeng1"></view>
							<view :style='{"color":"#ffffff","lineHeight":"80rpx","fontSize":"28rpx"}'>添加评论</view>
						</view>
					</view>
				
					<view :style='{"boxShadow":"0 0px 0px #cccccc","padding":"0","margin":"24rpx 0 0 0","borderRadius":"8rpx 0 0 8rpx","background":"#ffffff","width":"100%","height":"auto"}' v-for="(item,index) in commentList" v-bind:key="index" class="cu-item comment-item">
						<view :style='{"width":"100%","display":"block","height":"auto"}'>
							<image :style='{"width":"100rpx","margin":"0 0 0 0","borderRadius":"100rpx","display":"inline-block","height":"100rpx"}' v-if="item.avatarurl" mode="aspectFill" :src="baseUrl+item.avatarurl"></image>
							<view :style='{"width":"auto","lineHeight":"60rpx","fontSize":"32rpx","color":"#333333","textAlign":"center","display":"inline-block"}' class="text-grey">{{item.nickname}}</view>
						</view>
						<view :style='{"margin":"8rpx 0 8rpx 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666","textIndent":"2em"}' class="text-gray text-content text-df">
							{{item.content}}
						</view>
						<view :style='{"padding":"0 40rpx","lineHeight":"48rpx","fontSize":"28rpx","color":"#999999","textAlign":"right"}' class="margin-top-sm text-gray text-df">{{item.addtime}}</view>
						<view v-if="item.reply" :style='{"margin":"8rpx 0 8rpx 0","lineHeight":"48rpx","fontSize":"28rpx","color":"#666666","textIndent":"2em"}' class="text-gray text-content text-df">
							回复:{{item.reply}}
						</view>
					</view>
				</view>

				<view class="bottom-content bg-white tabbar border shop" :style='{"width":"100%","padding":"0","flexWrap":"wrap","background":"none","display":"flex","height":"auto"}'>

					<button :style='{"border":"0","padding":"0 20rpx 0 20rpx","margin":"0 0 0 0","color":"#fff","background":"#ffaa33","width":"auto","fontSize":"28rpx","height":"80rpx"}' v-if="detail.alllimittimes>0" @tap="onCartTap" class="cu-btn bg-orange round shadow-blur" >加入购物车</button>
					<button :style='{"border":"0","padding":"0 20rpx 0 20rpx","margin":"0 0 0 0","color":"#fff","background":"#ffaa33","width":"auto","fontSize":"28rpx","height":"80rpx"}' v-if="detail.alllimittimes>0" @tap="onBuyTap">立即购买</button>
				</view>
			</view>

		</view>
	</view>
</mescroll-uni>
</view>
</template>

<script>
	export default {
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				id: '',
                userid: '',
                hotList: [],
				detail: {},
				swiperList: [],
				commentList: [],
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 3, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				user: null,
				storeupFlag: 0,
				count: 0,
				timer: null
			}
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(options) {
			this.id = options.id;
            if(options.userid) {
                this.userid = options.userid;
            }
			// 渲染数据
			this.init();
		},
        onUnload() {
            if(this.timer) {
                clearInterval(this.timer);
            }
        },
		async onShow(options) {
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
            this.getHotList();
			this.getStoreup();
			let cleanType = uni.getStorageSync('discussjiajuxinxiCleanType')
			if(cleanType){
				uni.removeStorageSync('discussjiajuxinxiCleanType')
				this.mescroll.num = 1
				this.upCallback(this.mescroll)
			}
			let crossCleanType = uni.getStorageSync('crossCleanType')
            if(crossCleanType) {
				uni.removeStorageSync('crossCleanType')
                res = await this.$api.info('jiajuxinxi', this.id);
                this.detail = res.data;
            }
		},
		destroyed: function() {
			//window.clearInterval(this.inter);
		},
		methods: {
			// 支付
			onPayTap(){
				uni.setStorageSync('paytable','jiajuxinxi');
				uni.setStorageSync('payObject',this.detail);
				this.$utils.jump('../pay-confirm/pay-confirm?type=1')
			},
            onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
                this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
            },
          async getHotList() {
            let res;
            res = await this.$api.recommend('jiajuxinxi', {
                page: 1,
                limit: 4
            });
            this.hotList = res.data.list
          },
			// 收藏
			async getStoreup() {
				if(!this.user){
					
					return false
				}
				let params = {
					page: 1,
					limit: 1,
					refid : this.id,
					tablename : 'jiajuxinxi',
					userid: this.user.id,
					type: 1,
				}
				let res = await this.$api.list(`storeup`, params);
				this.storeupFlag = res.data.list.length;
			},
			async shoucang(){
				if(!this.user){
					
					return false
				}
				let _this = this;
				let params = {
					page: 1,
					limit: 1,
					refid : _this.detail.id,
					tablename : 'jiajuxinxi',
					userid: _this.user.id,
					type: 1,
				}
				let res = await _this.$api.list(`storeup`, params);
				if (res.data.list.length == 1) {
					let storeupId = res.data.list[0].id;
					uni.showModal({
						title: '提示',
						content: '是否取消',
						success: async function(res) {
							if (res.confirm) {
								await _this.$api.del('storeup', JSON.stringify([storeupId]));
								_this.detail.storeupnum--
								await _this.$api.update('jiajuxinxi',_this.detail)
								_this.$utils.msg('取消成功');
								_this.getStoreup();
							}
						}
					});
					return;
				}
				uni.showModal({
					title: '提示',
					content: '是否收藏',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.add('storeup', {
								userid: _this.user.id,
								name: _this.detail.jiajumingcheng,
                                inteltype: _this.detail.jiajuleixing,
								picture: _this.swiperList[0],
								refid: _this.detail.id,
								tablename: 'jiajuxinxi',
                                type: 1
							});
							_this.detail.storeupnum++
							await _this.$api.update('jiajuxinxi',_this.detail)
							_this.$utils.msg('收藏成功');
							_this.getStoreup();
						}
					}
				});
			},
			// 跨表
			onAcrossTap(tableName,crossOptAudit,statusColumnName,tips,statusColumnValue){
				if(!this.user){
					
					return false
				}
				uni.setStorageSync('crossTable','jiajuxinxi');
				uni.setStorageSync(`crossObj`, this.detail);
				uni.setStorageSync(`statusColumnName`, statusColumnName);
				uni.setStorageSync(`statusColumnValue`, statusColumnValue);
				uni.setStorageSync(`tips`, tips);
				if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
					var obj = uni.getStorageSync('crossObj');
					for (var o in obj){
						if(o==statusColumnName && obj[o]==statusColumnValue){
							this.$utils.msg(tips);
							return
						}
					}
				}
				this.$utils.jump(`../${tableName}/add-or-update?cross=true`);
			},
			// 获取详情
			async init(){
                if(this.timer) {
                    clearInterval(this.timer);
                }
				let res = await this.$api.info('jiajuxinxi', this.id);
				this.detail = res.data;
				// 轮播图片
				this.swiperList = this.detail.jiajutupian ? this.detail.jiajutupian.split(",") : [];
				//修改富文本的图片样式
				this.detail.jiajuxiangqing = this.detail.jiajuxiangqing.replace(/img src/gi,"img style=\"width:100%;\" src");
			},

			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},

			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				mescroll.resetUpScroll()
			},

			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
                let res = await this.$api.list('discussjiajuxinxi', {
					page: mescroll.num,
					limit: 10,
					refid: this.id
				});
				// 如果是第一页数据置空
				if (mescroll.num == 1) this.commentList = [];
				this.commentList = this.commentList.concat(res.data.list);
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);

            },

            async onCartTap() {
				if(!this.user){
					
					return false
				}
				if (uni.getStorageSync(`cart${this.detail.id}${this.user.id}`)) {
					this.$utils.msg('该商品已添加到购物车')
					return
				}
				await this.$api.add('cart', {
					tablename: 'jiajuxinxi',
					goodid: this.detail.id,
					goodname: this.detail.jiajumingcheng,
					goodtype: this.detail.jiajuleixing,
					picture: this.swiperList[0],
					buynumber: 1,
					userid: this.user.id,
					price: this.detail.price,
					discountprice: this.detail.vipprice
				});
				uni.setStorageSync(`cart${this.detail.id}${this.user.id}`, true);
				this.$utils.msg('添加到购物车成功')
			},
            onBuyTap() {
				if(!this.user){
					
					return false
				}
				uni.setStorageSync('orderGoods', [{
					tablename: 'jiajuxinxi',
					goodid: this.detail.id,
					goodname: this.detail.jiajumingcheng,
					goodtype: this.detail.jiajuleixing,
					picture: this.swiperList[0],
					buynumber: 1,
					price: this.detail.price,
					discountprice: this.detail.vipprice
				}])
				this.$utils.jump('../shop-order-confirm/shop-order-confirm?type=1');
			},


			onChatTap() {
				this.$utils.jump('../chat/chat')
			},
			// 下载
			download(url){
				let _this = this;
				url=_this.$base.url +  url;
				uni.downloadFile({
					url: url,
					success: (res) => {
						if (res.statusCode === 200) {
							_this.$utils.msg('下载成功');
							 window.open(url);
						}
					}
				});
			},
			//
			onCartTabTap() {
				this.$utils.tab('../shop-cart/shop-cart')
			},
			// 添加评论
			async onCommentTap() {
				if(!this.user){
					
					return false
				}
                let params = {
                    page: 1,
                    limit: 1,
					status: '已完成',
					goodid: this.detail.id
                }
                let res = await this.$api.page('orders', params);
                if (res.data.list.length == 0) {
                this.$utils.msg('请完成订单后再评论');
					return;
				}
				this.$utils.jump(`../discussjiajuxinxi/add-or-update?refid=${this.id}`)
			},
			onSHTap() {
				if(!this.user){
					
					return false
				}
				this.$refs.popup.open()
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	
	.seat-list {
		display: flex;
		align-items: center;
		flex-wrap: wrap;
		background: #FFFFFF;
		margin: 20upx;
		border-radius: 20upx;
		padding: 20upx;
		font-size: 30upx;
		.seat-item {
			width: 33.33%;
			display: flex;
			align-items: center;
			flex-direction: column;
			margin-bottom: 20upx;
	
			.seat-icon {
				width: 50upx;
				height: 50upx;
				margin-bottom: 10upx;
			}
		}
	}
	
	audio {
		display: flex;
		flex-direction: column;
	}
	
	.audio /deep/ .uni-audio-default {
		width: inherit;
	}
</style>
