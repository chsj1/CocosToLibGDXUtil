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
	TextureRegion bgRegion;//����ͼƬ
	Image bgImage;
	
	@Override
	public void create() {
		stage = new Stage(480, 800, false);
		texture = new Texture(Gdx.files.internal("data/lengjiao.png"));
		image = new Image(texture);
		//��json�ļ��е�������ȡ��������Map����ʽ����
		Map<String,CocosInformation> map = CocosStudioJSONFileParseUtils.getCocosInformationFromJSONFile("json/HelloWorld.json");
		CocosInformation cocosInformation = map.get("lengjiao");//��ȡ��Ϊlengjiao��Ԫ�ص�������Ϣ
//		float positionX = cocosInformation.getPositionX();//��ȡx�������
//		float positionY = cocosInformation.getPositionY();//��ȡy������
//		float rotation = cocosInformation.getRotaion();//��ȡ��ת��
//		float originX = cocosInformation.getOriginX();//��ȡê����Ϣ
//		float originY = cocosInformation.getOriginY();
//		float scaleX = cocosInformation.getScaleX();//��ȡ������Ϣ
//		float scaleY = cocosInformation.getScaleY();
//		float width = cocosInformation.getWidth();//��ȡ���
//		float height = cocosInformation.getHeight();//��ȡ�߶�
		//��Ԫ�صĸ�����Ϣ���ý�ȥ
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
		Gdx.gl.glClearColor(1, 1, 1, 1);// ���ñ���Ϊ��ɫ
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);// ����
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
