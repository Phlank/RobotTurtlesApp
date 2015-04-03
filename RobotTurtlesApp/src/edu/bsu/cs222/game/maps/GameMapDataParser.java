package edu.bsu.cs222.game.maps;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class GameMapDataParser {

	private Document document;

	public Document parsePlayerMapData(InputStream inputStream) {
		DocumentBuilder db = documentBuilder();
		try {
			document = db.parse(inputStream);
		} catch (SAXException | IOException | NullPointerException e) {
			System.out.println("ERROR");
		}
		return document;
	}

	public Document parsePlayerMapDataForTest(String filename) {
		String file = new File(filename).getAbsolutePath();
		DocumentBuilder db = documentBuilder();
		try {
			document = db.parse(file);
		} catch (SAXException | IOException | NullPointerException e) {
			System.out.println("ERROR");
		}
		return document;
	}

	private DocumentBuilder documentBuilder() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			return dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println("Exception");
		}
		return null;
	}
}
