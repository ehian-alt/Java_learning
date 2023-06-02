# XML

XML 被设计用来传输和存储数据。

HTML 被设计用来显示数据。

XML 指可扩展标记语言（eXtensible Markup Language）。

### 语法
XML 的语法规则很简单，且很有逻辑。

* XML声明

XML 声明文件的可选部分，如果存在需要放在文档的第一行，如下所示  
`<?xml version="1.0" encoding="utf-8" ?>`

* XML 文档必须有根元素, 比如下面实例的`Students`
* 所有的 XML 元素都必须有一个关闭标签 `</>`
* XML 标签对大小写敏感
* XML 必须正确嵌套
* XML 属性值必须加引号, 比如下面的`type`是属性, `person` 是属性值
* XML 元素指的是从（且包括）开始标签直到（且包括）结束标签的部分。  
  一个元素可以包含：
  * 其他元素
  * 文本
  * 属性
  * 或混合以上所有...
```xml
<?xml version="1.0" encoding="utf-8" ?>

<Students>  <!--根元素-->
    <student type = "person">   <!-- 这里的 person 必须加引号-->
        <id>0</id>          <!-- 这是一个元素 -->
        <name>张三</name>     <!-- 这是一个元素 -->
        <age>22</age>        <!-- 这也是一个元素 -->
    </student>          <!-- 从<student> 到 </student> 也是一个元素 -->
    
    <student>
        <id>1</id>
        <name>李四</name>
        <age>20</age>
    </student>
</Students>
```

### XML 命名规则
XML 元素必须遵循以下命名规则：

* 名称可以包含字母、数字以及其他的字符
* 名称不能以数字或者标点符号开始
* 名称不能以字母 xml（或者 XML、Xml 等等）开始
* 名称不能包含空格

**可使用任何名称，没有保留的字词。**

### 文档约束DTD

DTD三种使用方式

* 内部DTD
* 外部DTD
* 公共DTD

## XML 解析

* DOM  (document?)  
* SAX  (其次)
* JDOM
* DOM4J (性能最高)

### DOM4J 解析

```java

```

运行结果如下:

### DOM 解析

```java
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Dom {
    // 用Dom 解析XML文件
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //1、获得document构建  工厂对象
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //2、获得documentBuilder对象
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        //3、获得document对象
        Document document = documentBuilder.parse("E:\\IDEA\\Java_Project\\Hello_Java\\src\\XML\\XMLtest.xml");
        //4、获得节点集合
        NodeList students = document.getElementsByTagName("Students");
        //5、获得根节点
        Node root = students.item(0);
        //6、获得子节点
        NodeList nodes = root.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            //获得子节点不仅仅包含student还包含了空格
//            System.out.println(nodes.item(i));
            Node node = nodes.item(i);
            // == 1代表当前node是一个节点而不是文本
            if (node.getNodeType()==1){
                System.out.println(node.getNodeName());
                //获得student子节点
                NodeList childNodes = node.getChildNodes();
                // 获得包括id,name, age节点
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node node_info = childNodes.item(j);
                    //是节点信息则输出
                    if (node_info.getNodeType()==1){
                        System.out.println("  "+node_info.getNodeName()+"  " + node_info.getTextContent());
                    }
                }
            }
        }
    }
}
```

运行结果如下:

    student
    id  0
    name  张三
    age  22
    student
    id  1
    name  李四
    age  20

### SAX解析

```java
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;


// 使用SAX解析
public class SAX_test {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // 1、获得工厂对象
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // 2、基于工厂获得解析器对象
        SAXParser saxParser = factory.newSAXParser();
        // 3、使用解析器解析xml   第二个参数DefaultHandler需要继承重写
        saxParser.parse(new File("E:\\IDEA\\Java_Project\\Hello_Java\\src\\XML\\XMLtest.xml"), new Myhandler());
    }
}

class Myhandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("文档解析开始");
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName+"---标签解析开始");
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length);
        System.out.println("解析文本值为: " + str);
        super.characters(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName+"---标签解析结束");
        super.endElement(uri, localName, qName);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("文档解析结束");
        super.endDocument();
    }
}
```

运行结果如下:

    文档解析开始
    Students---标签解析开始
    解析文本值为:
    
    student---标签解析开始
    解析文本值为:
    
    id---标签解析开始
    解析文本值为: 0
    id---标签解析结束
    解析文本值为:
    
    name---标签解析开始
    解析文本值为: 张三
    name---标签解析结束
    解析文本值为:
    
    age---标签解析开始
    解析文本值为: 22
    age---标签解析结束
    解析文本值为:
    
    student---标签解析结束
    解析文本值为:
    
    
    student---标签解析开始
    解析文本值为:
    
    id---标签解析开始
    解析文本值为: 1
    id---标签解析结束
    解析文本值为:
    
    name---标签解析开始
    解析文本值为: 李四
    name---标签解析结束
    解析文本值为:
    
    age---标签解析开始
    解析文本值为: 20
    age---标签解析结束
    解析文本值为:
    
    student---标签解析结束
    解析文本值为:
    
    Students---标签解析结束
    文档解析结束
    
    Process finished with exit code 0

