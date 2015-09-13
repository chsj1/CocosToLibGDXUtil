package com.example.hellolibgdx;

import java.util.Map;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MyGame implements ApplicationListener {
	Stage stage;
	Image image;
	Texture texture;
	
	TextureAtlas atlas;
	TextureRegion bgRegion;//背景图片
	Image bgImage;
	
	@Override
	public void create() {
		stage = new Stage(480, 800, false);
		texture = new Texture(Gdx.files.internal("data/lengjiao.png"));
		image = new Image(texture);
		//将json文件中的数据提取出来，以Map的形式返回
		Map<String,CocosInformation> map = CocosStudioJSONFileParseUtils.getCocosInformationFromJSONFile("json/HelloWorld.json");
		CocosInformation cocosInformation = map.get("lengjiao");//获取名为lengjiao的元素的数据信息
//		float positionX = cocosInformation.getPositionX();//获取x轴的坐标
//		float positionY = cocosInformation.getPositionY();//获取y轴坐标
//		float rotation = cocosInformation.getRotaion();//获取旋转角
//		float originX = cocosInformation.getOriginX();//获取锚点信息
//		float originY = cocosInformation.getOriginY();
//		float scaleX = cocosInformation.getScaleX();//获取缩放信息
//		float scaleY = cocosInformation.getScaleY();
//		float width = cocosInformation.getWidth();//获取宽度
//		float height = cocosInformation.getHeight();//获取高度
		//把元素的各个信息设置进去
		image.setPosition(cocosInformation.getPositionX(), cocosInformation.getPositionY());
		image.setRotation(cocosInformation.getRotaion());
		image.setOrigin(cocosInformation.getOriginX(), cocosInformation.getOriginY());
		image.setScale(cocosInformation.getScaleX() - 0.3f, cocosInformation.getScaleY() - 0.3f);
		System.out.println("rotation: " + cocosInformation.getRotaion());
		
		atlas = new TextureAtlas(Gdx.files.internal("data/loading.atlas"));
		bgRegion = atlas.findRegion("bg");
		bgImage = new Image(bgRegion);
		
		stage.addActor(bgImage);
		stage.addActor(image);
		Gdx.input.setInputProcessor(stage);
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}
	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);// 设置背景为白色
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);// 清屏
		stage.act();
		stage.draw();
	}
	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}
}
