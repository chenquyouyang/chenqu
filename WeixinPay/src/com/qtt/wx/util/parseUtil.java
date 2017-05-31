package com.qtt.wx.util;

import java.io.Writer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * 用于解析简单xml格式字符串
 * @author cdw
 *
 */
public class parseUtil {
	
	private static XStream Wxstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;

				@SuppressWarnings("unchecked")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}
				
				@Override
				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});
	
	public static String getElement(String data,String elm)
	{
		String retval = "";
		String end_elm = "</"+elm.substring(1);
		int pos1 = data.indexOf(elm);
		if ( pos1 < 0 )
		{
			return null;
		}
		int pos2 = data.indexOf(end_elm,pos1);
		if ( pos2 < 0 )
		{
			return null;
		}
		retval = data.substring(pos1+elm.length(),pos2);
		return retval;
	}
	
	//xml字符串转对象
	public static <T> T toBean(String xmlStr, Class<T> cls) {
        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(cls);
        @SuppressWarnings("unchecked")
        T t = (T) xstream.fromXML(xmlStr);
        return t;
    }
	
	//对象转xml，并添加cdata标签
	public static String toXml(Object obj) {
		Wxstream.processAnnotations(obj.getClass()); // 识别obj类中的注解
        /*
         // 以压缩的方式输出XML
         StringWriter sw = new StringWriter();
         xstream.marshal(obj, new CompactWriter(sw));
         return sw.toString();
         */
        // 以格式化的方式输出XML
        return Wxstream.toXML(obj);
    }
	
}
