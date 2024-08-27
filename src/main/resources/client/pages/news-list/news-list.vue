<template>
<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
	<view class="content">
		<view :style='{"minHeight":"100vh","width":"100%","padding":"20rpx 0 0 0","position":"relative","background":"#ffffff","height":"100%"}'>
			<view :style='{"width":"calc(98% - 120rpx)","position":"relative","alignItems":"center","justifyContent":"space-between","display":"flex"}'>
				<view :style='{"backgroundColor":"#f5f5f5","margin":"0 30rpx 0 30rpx","color":"#333333","alignItems":"center","borderRadius":"40rpx","flex":"1","display":"flex","lineHeight":"64rpx","fontSize":"24rpx","height":"64rpx"}'>
					<text class="iconfont icon-sousuo1" :style='{"margin":"0 16rpx 0 16rpx"}'></text>
					<input v-model="searchForm.title" type="text" placeholder="标题" :style='{"background":"transparent","height":"100%"}'></input>
				</view>
				<button @tap="search" :style='{"border":"0px","padding":"0 40rpx 0 40rpx","margin":"0 20rpx 0 0px","borderRadius":"40rpx","color":"#fff","background":"#3da742","fontSize":"28rpx","lineHeight":"64rpx","height":"64rpx"}'>搜索</button>
			</view>


			<!-- 样式3 -->
			<view class="news-box3" :style='{"width":"100%","padding":"24rpx 24rpx 24rpx 24rpx","margin":"40rpx 0 40rpx 0","height":"auto","order":"10"}'>
				<view @tap="onDetailTap(product)" v-for="(product,index) in list" :key="index" class="list-item" :style='{"padding":"0px 12rpx 0px 12rpx","margin":"0 0 0 0","borderColor":"#3da74230","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","position":"relative","borderStyle":"solid","justifyContent":"space-between","height":"100rpx"}'>
					<view :style='{"width":"12rpx","padding":"0 0 0 0","margin":"44rpx 20rpx 0 0","backgroundColor":"#3da742","borderRadius":"12rpx","height":"12rpx"}' class="dian"></view>
					<view :style='{"overflow":"hidden","whiteSpace":"nowrap","color":"#333","flex":"1","width":"auto","lineHeight":"100rpx","fontSize":"28rpx","textOverflow":"ellipsis","height":"80rpx"}' class="title ">{{product.title}}</view>
					<view class="iconfont icon-gengduo1" :style='{"width":"32rpx","padding":"0 0 0 0","margin":"0px 0 0 0","lineHeight":"100rpx","fontSize":"32rpx","color":"#3da74250"}'></view>
				</view>
			</view>



		</view>
	</view>
</mescroll-uni>
</template>
<script>
	export default {
		data() {
			return {
				list:[],
				searchForm: {},
				mescroll: null, //mescroll实例对象
			}
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			}
		},
		async onShow() {
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		async onLoad(options) {
            if(options.userid) {
                this.userid=options.userid;
            } else {
                this.userid = "";
            }
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		methods:{
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},
			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				// 重置分页参数页数为1
				mescroll.resetUpScroll()
			},
			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let params = {
					page: mescroll.num,
					limit: mescroll.size
				}
				if(this.searchForm.title){
					params['title'] = '%' + this.searchForm.title + '%'
				}
				let res = {}
				if(this.userid) {
					res = await this.$api.page(`news`, params);
				} else {
					res = await this.$api.list(`news`, params);
				}
				// 如果是第一页数据置空
				if (mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);
			},
			onDetailTap(row){
				this.$utils.jump(`../news-detail/news-detail?id=${row.id}`)
			},
			// 搜索
			async search(){
				this.mescroll.num = 1
				let searchForm = {
					page: this.mescroll.num,
					limit: this.mescroll.size
				}
				if(this.searchForm.title){
					searchForm['title'] = '%' + this.searchForm.title + '%'
				}
                let res = {};
                if(this.userid) {
                    res = await this.$api.page(`news`, searchForm);
                } else {
                    res = await this.$api.list(`news`, searchForm);
                }
				// 如果是第一页数据置空
				if (this.mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				this.mescroll.endSuccess(this.mescroll.size, this.hasNext);
				this.screenBoxShow = false
			}
		}
	}
</script>