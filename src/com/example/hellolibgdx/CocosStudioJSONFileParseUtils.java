package com.example.hellolibgdx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
/**
 * ���ڴ�CocoStudio��������������ȡԪ�ص���Ϣ
 * @author Administrator
 *
 */
public class CocosStudioJSONFileParseUtils {
	public static Map<String, CocosInformation> getCocosInformationFromJSONFile(
			String internalFileName) {
		Map<String, CocosInformation> cocosInformationMap = new HashMap<String, CocosInformation>();
		System.out.println("--------------->��ʼ����: " +internalFileName);
		long startTime = System.currentTimeMillis();
		FileHandle handle = Gdx.files.internal(internalFileName);//��ȡassets�е��ļ�������
		String jsonStr = handle.readString();
//		System.out.println("------------------->����0: " + (System.currentTimeMillis() - startTime));
		// ����JSON�ַ���
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		String widgetTreeStr = jsonObject.getString("widgetTree");
		JSONObject widgetTreeObject = JSONObject.parseObject(widgetTreeStr);
		String childrenStr = widgetTreeObject.getString("children");
		// System.out.println(childrenStr);
		JSONArray jsonArray = JSONArray.parseArray(childrenStr);
		int size = jsonArray.size();
//		System.out.println("------------------->����1: " + (System.currentTimeMillis() - startTime));
		for (int i = 0; i < size; ++i) {
			JSONObject jObject = jsonArray.getJSONObject(i);
			String optionsStr = jObject.getString("options");
			JSONObject optionsObject = JSONObject.parseObject(optionsStr);
			String name = optionsObject.getString("name");
			float rotation = -Float.parseFloat(optionsObject
					.getString("rotation"));
			float scaleX = Float.parseFloat(optionsObject.getString("scaleX"));
			float scaleY = Float.parseFloat(optionsObject.getString("scaleY"));
			float positionX = Float.parseFloat(optionsObject.getString("x"));
			float positionY = Float.parseFloat(optionsObject.getString("y"));
			float originX = Float.parseFloat(optionsObject
					.getString("anchorPointX"));
			float originY = Float.parseFloat(optionsObject
					.getString("anchorPointY"));
			float width = Float.parseFloat(optionsObject
					.getString("width"));
			float height = Float.parseFloat(optionsObject
					.getString("height"));
			CocosInformation cocosInformation = new CocosInformation(positionX,
					positionY, scaleX, scaleY, originX, originY, rotation,width,height);
			cocosInformationMap.put(name, cocosInformation);
//			System.out.println("--------------------------------------");
		}
		System.out.println("------------------->�������,��ʱ: " + (System.currentTimeMillis() - startTime) + " ms");
		return cocosInformationMap;
	}
	// public static Map<String, CocosInformation>
	// getCocosInformationFromJSONFile(
	// String jsonFileURL) {
	// // ����JSON�ļ�����JSON�ַ���
	// BufferedReader reader;
	// Map<String, CocosInformation> cocosInformationMap = new HashMap<String,
	// CocosInformation>();
	//
	// try {
	// reader = new BufferedReader(new FileReader(new File(jsonFileURL)));
	// StringBuffer buffer = new StringBuffer();
	// String line;
	// try {
	// while ((line = reader.readLine()) != null) {
	// buffer.append(line);
	// }
	// } catch (IOException e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// reader.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// }
	//
	// // System.out.println(buffer.toString());
	//
	// String jsonStr = buffer.toString();
	//
	// // ����JSON�ַ���
	// JSONObject jsonObject = JSONObject.parseObject(jsonStr);
	// String widgetTreeStr = jsonObject.getString("widgetTree");
	// JSONObject widgetTreeObject = JSONObject.parseObject(widgetTreeStr);
	// String childrenStr = widgetTreeObject.getString("children");
	// // System.out.println(childrenStr);
	// JSONArray jsonArray = JSONArray.parseArray(childrenStr);
	// int size = jsonArray.size();
	//
	// for (int i = 0; i < size; ++i) {
	// JSONObject jObject = jsonArray.getJSONObject(i);
	// String optionsStr = jObject.getString("options");
	// JSONObject optionsObject = JSONObject.parseObject(optionsStr);
	//
	// String name = optionsObject.getString("name");
	//
	// float rotation = -Float.parseFloat(optionsObject
	// .getString("rotation"));
	//
	// float scaleX = Float.parseFloat(optionsObject
	// .getString("scaleX"));
	// float scaleY = Float.parseFloat(optionsObject
	// .getString("scaleY"));
	//
	// float positionX = Float
	// .parseFloat(optionsObject.getString("x"));
	// float positionY = Float
	// .parseFloat(optionsObject.getString("y"));
	//
	// float originX = Float.parseFloat(optionsObject
	// .getString("anchorPointX"));
	// float originY = Float.parseFloat(optionsObject
	// .getString("anchorPointY"));
	//
	// CocosInformation cocosInformation = new CocosInformation(
	// positionX, positionY, scaleX, scaleY, originX, originY,
	// rotation);
	// cocosInformationMap.put(name, cocosInformation);
	//
	// System.out.println("--------------------------------------");
	// }
	// } catch (FileNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return cocosInformationMap;
	// }
	public static Map<String, CocosInformation> getCocosInformationFromJSONFile(
			File file) {
		// ����JSON�ļ�����JSON�ַ���
		BufferedReader reader;
		Map<String, CocosInformation> cocosInformationMap = new HashMap<String, CocosInformation>();
		try {
			reader = new BufferedReader(new FileReader(file));
			StringBuffer buffer = new StringBuffer();
			String line;
			try {
				while ((line = reader.readLine()) != null) {
					buffer.append(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// System.out.println(buffer.toString());
			String jsonStr = buffer.toString();
			// ����JSON�ַ���
			JSONObject jsonObject = JSONObject.parseObject(jsonStr);
			String widgetTreeStr = jsonObject.getString("widgetTree");
			JSONObject widgetTreeObject = JSONObject.parseObject(widgetTreeStr);
			String childrenStr = widgetTreeObject.getString("children");
			// System.out.println(childrenStr);
			JSONArray jsonArray = JSONArray.parseArray(childrenStr);
			int size = jsonArray.size();
			for (int i = 0; i < size; ++i) {
				JSONObject jObject = jsonArray.getJSONObject(i);
				String optionsStr = jObject.getString("options");
				JSONObject optionsObject = JSONObject.parseObject(optionsStr);
				String name = optionsObject.getString("name");
				float rotation = Float.parseFloat(optionsObject
						.getString("rotation"));

				float scaleX = Float.parseFloat(optionsObject
						.getString("scaleX"));
				float scaleY = Float.parseFloat(optionsObject
						.getString("scaleY"));
				float positionX = Float
						.parseFloat(optionsObject.getString("x"));
				float positionY = Float
						.parseFloat(optionsObject.getString("y"));
				float originX = Float.parseFloat(optionsObject
						.getString("anchorPointX"));
				float originY = Float.parseFloat(optionsObject
						.getString("anchorPointY"));
				CocosInformation cocosInformation = new CocosInformation(
						positionX, positionY, scaleX, scaleY, originX, originY,
						-rotation);
				cocosInformationMap.put(name, cocosInformation);
				System.out.println("--------------------------------------");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cocosInformationMap;
	}
	public static void changePositionInCocosStudioToLibgdx(Image image) {
		float cocostudioX = image.getX();
		float cocostudioY = image.getY();

		float originX = image.getOriginX();
		float originY = image.getOriginY();

		float libgdxX = cocostudioX - originX;
		float libgdxY = cocostudioY - originY;

		image.setPosition(libgdxX, libgdxY);
	}
}
