package com.jt.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName(value="tb_cart")
public class Cart extends BasePojo{
	@TableId(type=IdType.AUTO)
		private Integer id;
		//@TableField(value="user_id")  //驼峰规则跟数据库匹配
		private Integer userId;
		//@TableField(value="item_id")
		private Integer itemId;
		//@TableField(value="item_title")
		private String itemTitle;
		//@TableField(value="item_image")
		private String itemImage;
		//@TableField(value="item_price")
		private Integer itemPrice;
		private Integer num;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public Integer getItemId() {
			return itemId;
		}
		public void setItemId(Integer itemId) {
			this.itemId = itemId;
		}
		public String getItemTitle() {
			return itemTitle;
		}
		public void setItemTitle(String itemTitle) {
			this.itemTitle = itemTitle;
		}
		public String getItemImage() {
			return itemImage;
		}
		public void setItemImage(String itemImage) {
			this.itemImage = itemImage;
		}
		public Integer getItemPrice() {
			return itemPrice;
		}
		public void setItemPrice(Integer itemPrice) {
			this.itemPrice = itemPrice;
		}
		public Integer getNum() {
			return num;
		}
		public void setNum(Integer num) {
			this.num = num;
		}
		
	
	
}
