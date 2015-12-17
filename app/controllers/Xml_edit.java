package controllers;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Xml_edit {
	private static File fileObject;
	private static NodeList rootChildren;
	private static Document document = null;
	private static Element root = null;
	public static void main(String args[]) throws SAXException, IOException, ParserConfigurationException{
		String filePath = args[0];
		domCommentRead(filePath);
	}
	public static void fileRead(String file){
		fileObject = new File(file);
		System.out.println("FilePath:"+fileObject.getAbsolutePath());
		if(!fileObject.exists()){
			try {
				fileObject.createNewFile();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}
	public static void domCommentRead(String file) throws SAXException, IOException, ParserConfigurationException {
		try {
			fileRead(file);
			DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			document = docBuilder.parse(fileObject);
			root = document.getDocumentElement();
			//ルート要素のノード名を取得する
			//System.out.println("ノード名：" +root.getNodeName());
			//ルート要素の子ノードを取得する
			rootChildren = root.getChildNodes();
			//System.out.println("子要素の数：" + rootChildren.getLength());
			//System.out.println("------------------");
			for(int i=0; i < rootChildren.getLength(); i++) {
				Node node = rootChildren.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element)node;
					if (element.getNodeName().equals("comment")) {
						NodeList personChildren = node.getChildNodes();
						for (int j=0; j < personChildren.getLength(); j++) {
							Node personNode = personChildren.item(j);
							if (personNode.getNodeType() == Node.ELEMENT_NODE) {
								if (personNode.getNodeName().equals("name")) {
									//System.out.println("名前：" + personNode.getTextContent());
								} else if (personNode.getNodeName().equals("value")) {
									//System.out.println("コメント:" + personNode.getTextContent());
								}
							}
						}
						//System.out.println("------------------");
					}
				}
			}
        } catch (SAXException e) {
        	System.out.println(e);
        } catch (IOException e) {
        	System.out.println(e);
        }
	}
	public static void domCommentAdd(String file, String name, String comment) throws SAXException, IOException, ParserConfigurationException, TransformerException{
		System.out.println("domAdd");
		Date date = new Date();
		String nowdate = date.toString();
		domCommentRead(file);
		Element comment_element = document.createElement("comment");
		root.appendChild(comment_element);
		Element name_element = document.createElement("name");
		comment_element.appendChild(name_element);
		Text textContents = document.createTextNode(name);
		name_element.appendChild(textContents);
		Element value_element = document.createElement("value");
		comment_element.appendChild(value_element);
		Text textContents02 = document.createTextNode(comment);
		value_element.appendChild(textContents02);
		Element date_element = document.createElement("date");
		comment_element.appendChild(date_element);
		Text textContents03 = document.createTextNode(nowdate);
		date_element.appendChild(textContents03);
		
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		FileOutputStream os = new FileOutputStream(fileObject);
		StreamResult result = new StreamResult(os);
		transformer.transform(source, result);	
		
		fileObject = null;
		rootChildren = null;
		document = null;
		root = null;
	}
	public static List<String> domBlogRead(String file) throws SAXException, IOException, ParserConfigurationException {
		List<String> blog = new ArrayList<String>();
		try {
			fileRead(file);
			DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			document = docBuilder.parse(fileObject);
			root = document.getDocumentElement();
			//ルート要素のノード名を取得する
			//System.out.println("ノード名：" +root.getNodeName());
			//ルート要素の子ノードを取得する
			rootChildren = root.getChildNodes();
			//System.out.println("子要素の数：" + rootChildren.getLength());
			System.out.println("------------------");
			for(int i=0; i < rootChildren.getLength(); i++) {
				Node node = rootChildren.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element)node;
					if (element.getNodeName().equals("article")) {
						NodeList personChildren = node.getChildNodes();
						for (int j=0; j < personChildren.getLength(); j++) {
							Node personNode = personChildren.item(j);
							if (personNode.getNodeType() == Node.ELEMENT_NODE) {
								if(personNode.getNodeName().equals("id")) {
									blog.add(personNode.getTextContent());
									System.out.println("id:" + personNode.getTextContent());
								}else if(personNode.getNodeName().equals("title")) {
									blog.add(personNode.getTextContent());
									System.out.println("タイトル：" + personNode.getTextContent());
								} else if (personNode.getNodeName().equals("maintext")) {
									blog.add(personNode.getTextContent());
									System.out.println("本文:" + personNode.getTextContent());
								}
							}
						}
						System.out.println("------------------");
					}
				}
			}
        } catch (SAXException e) {
        	System.out.println(e);
        } catch (IOException e) {
        	System.out.println(e);
        }
		fileObject = null;
		rootChildren = null;
		document = null;
		root = null;
		return blog;
	}
	public static void domBlogChange(String file,String id, String title, String main_text) throws SAXException, IOException, ParserConfigurationException, TransformerException{
		System.out.println("domBlogChange");
		System.out.println("@@id:"+id);
		Element target_element = null;
		Node parent_node = null;
		Node title_node = null;
		Node main_node = null;
		try {
			fileRead(file);
			DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			document = docBuilder.parse(fileObject);
			root = document.getDocumentElement();
			rootChildren = root.getChildNodes();
			for(int i=0; i < rootChildren.getLength(); i++) {
				Node node = rootChildren.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element)node;
					if (element.getNodeName().equals("article")) {
						NodeList personChildren = node.getChildNodes();
						boolean flag = false;
						for (int j = 0; j < personChildren.getLength(); j++) {
							Node personNode = personChildren.item(j);
							if (personNode.getNodeType() == Node.ELEMENT_NODE) {
								if (personNode.getNodeName().equals("id")) {
									String get_id = personNode.getTextContent();
									if(Integer.parseInt(get_id) == Integer.parseInt(id)){
										//System.out.println("OK!: "+ Integer.parseInt(get_id) +"=="+ Integer.parseInt(id));
										target_element = element;
										parent_node = node;
										flag = true;
									}
								}else if (personNode.getNodeName().equals("title")) {
									if(flag){
										//System.out.println("title");
										title_node = personNode;
									}
								}else if (personNode.getNodeName().equals("maintext")) {
									if(flag){
										//System.out.println("maintext");
										main_node = personNode;
									}
								}
							}
						}
					}
				}
			}
        } catch (SAXException e) {
        	System.out.println(e);
        } catch (IOException e) {
        	System.out.println(e);
        }
		
		System.out.println("@@target_element:"+target_element);
		//System.out.println(parent_node);
		//System.out.println(title_node);
		//System.out.println(main_node);
		if(target_element != null){
			parent_node.removeChild(title_node);
			parent_node.removeChild(main_node);
			System.out.println("@@input_title:"+title);
			Element name_element = document.createElement("title");
			target_element.appendChild(name_element);
			Text textContents = document.createTextNode(title);
			name_element.appendChild(textContents);
			
			Element value_element = document.createElement("maintext");
			target_element.appendChild(value_element);
			textContents = document.createTextNode(main_text);
			value_element.appendChild(textContents);

			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			FileOutputStream os = new FileOutputStream(fileObject);
			StreamResult result = new StreamResult(os);
			transformer.transform(source, result);	
			
		}
		fileObject = null;
		rootChildren = null;
		document = null;
		root = null;
	}
	public static void domBlogAdd(String file) throws SAXException, IOException, ParserConfigurationException, TransformerException{
		System.out.println("domBlogChange");
		Date date = new Date();
		String nowdate = date.toString();
		Node root_node = null;
		int ids = 1;
		try {
			fileRead(file);
			DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			document = docBuilder.parse(fileObject);
			root = document.getDocumentElement();
			root_node = root;
			rootChildren = root.getChildNodes();
			System.out.println(rootChildren.getLength());
			for(int i=0; i < rootChildren.getLength(); i++) {
				Node node = rootChildren.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element)node;
					if (element.getNodeName().equals("article")) {
						NodeList personChildren = node.getChildNodes();
						for (int j=0; j < personChildren.getLength(); j++) {
							Node personNode = personChildren.item(j);
							if (personNode.getNodeType() == Node.ELEMENT_NODE) {
								System.out.println(personNode.getNodeName());
								if(personNode.getNodeName().equals("id")) {
									int get_id = Integer.parseInt(personNode.getTextContent());
									if(get_id >= ids){
										ids = get_id+1;
									}
								}
							}
						}
					}
				}
			}
        } catch (SAXException e) {
        	System.out.println(e);
        } catch (IOException e) {
        	System.out.println(e);
        }
		Element article_element = document.createElement("article");
		root_node.appendChild(article_element);
		
		Element id_element = document.createElement("id");
		article_element.appendChild(id_element);
		Text textContents = document.createTextNode(String.valueOf(ids));
		id_element.appendChild(textContents);
		
		Element date_element = document.createElement("date");
		article_element.appendChild(date_element);
		textContents = document.createTextNode(nowdate);
		date_element.appendChild(textContents);
		
		Element name_element = document.createElement("title");
		article_element.appendChild(name_element);
		textContents = document.createTextNode("新しい記事");
		name_element.appendChild(textContents);
			
		Element value_element = document.createElement("maintext");
		article_element.appendChild(value_element);
		textContents = document.createTextNode("ここに文字を入力してください。");
		value_element.appendChild(textContents);
		
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		FileOutputStream os = new FileOutputStream(fileObject);
		StreamResult result = new StreamResult(os);
		transformer.transform(source, result);	

		fileObject = null;
		rootChildren = null;
		document = null;
		root = null;
	}
	
	public static void domBlogDelete(String file,String id) throws SAXException, IOException, ParserConfigurationException, TransformerException{
		System.out.println("domBlogDelete");
		Node root_node = null;
		Node delete_node = null;
		try {
			fileRead(file);
			DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			document = docBuilder.parse(fileObject);
			root = document.getDocumentElement();
			root_node = root;
			rootChildren = root.getChildNodes();
			for(int i=0; i < rootChildren.getLength(); i++) {
				Node node = rootChildren.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element)node;
					if (element.getNodeName().equals("article")) {
						NodeList personChildren = node.getChildNodes();
						for (int j = 0; j < personChildren.getLength(); j++) {
							Node personNode = personChildren.item(j);
							if (personNode.getNodeType() == Node.ELEMENT_NODE) {
								if(personNode.getNodeName().equals("id")) {
									String get_id = personNode.getTextContent();
									System.out.println(String.valueOf(Integer.parseInt(get_id))+" "+String.valueOf(Integer.parseInt(id)));
									if(Integer.parseInt(get_id) == Integer.parseInt(id)){
										delete_node = node;
									}
								}
							}
						}
					}
				}
			}
        } catch (SAXException e) {
        	System.out.println(e);
        } catch (IOException e) {
        	System.out.println(e);
        }
		System.out.println(delete_node);
		if(delete_node != null){
			root_node.removeChild(delete_node);
		}
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		FileOutputStream os = new FileOutputStream(fileObject);
		StreamResult result = new StreamResult(os);
		transformer.transform(source, result);
		fileObject = null;
		rootChildren = null;
		document = null;
		root = null;
	}
}