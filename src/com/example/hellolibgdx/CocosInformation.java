package com.example.hellolibgdx;

/**
 * 存储从CocosStudio提取出来的元素信息
 * @author Administrator
 *
 */
public class CocosInformation {
	public float positionX;//位置信息
	public float positionY;
	public float scaleX;//缩放信息
	public float scaleY;
	public float originX;//锚点信息
	public float originY;
	public float rotation;//旋转角
	public float width;//图片宽度与长度
	public float height;
	public CocosInformation() {
	}
	public CocosInformation(float positionX, float positionY, float scaleX,
			float scaleY, float originX, float originY, float rotation) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.scaleX = scaleX;
		this.scaleY = scaleY;
		this.originX = originX;
		this.originY = originY;
		this.rotation = rotation;
	}
	public CocosInformation(float positionX, float positionY, float scaleX,
			float scaleY, float originX, float originY, float rotation,float width,float height) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.scaleX = scaleX;
		this.scaleY = scaleY;
		this.originX = originX;
		this.originY = originY;
		this.rotation = rotation;
		this.width = width;
		this.height = height;
	}
	public float getPositionX() {
		return positionX;
	}
	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}
	public float getPositionY() {
		return positionY;
	}
	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}
	public float getScaleX() {
		return scaleX;
	}
	public void setScaleX(float scaleX) {
		this.scaleX = scaleX;
	}
	public float getScaleY() {
		return scaleY;
	}
	public void setScaleY(float scaleY) {
		this.scaleY = scaleY;
	}
	public float getOriginX() {
		return originX;
	}
	public void setOriginX(float originX) {
		this.originX = originX;
	}
	public float getOriginY() {
		return originY;
	}
	public void setOriginY(float originY) {
		this.originY = originY;
	}
	public float getRotaion() {
		return rotation;
	}
	public void setRotaion(float rotaion) {
		this.rotation = rotaion;
	}
	public float getRotation() {
		return rotation;
	}
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "CocosInformation [positionX=" + positionX + ", positionY="
				+ positionY + ", scaleX=" + scaleX + ", scaleY=" + scaleY
				+ ", originX=" + originX + ", originY=" + originY
				+ ", rotation=" + rotation + ", width=" + width + ", height="
				+ height + "]";
	}
}
