1.程序启动
	String XMLPATH = "D:\\workspace_my\\EXCEL2DB\\DOCUMENTATION\\EXCEL2DB.xml";		//XML路径
	String EXCELPATH = "D:\\workspace_my\\EXCEL2DB\\DOCUMENTATION\\EXCEL2DB.xlsx";	//xlsx路径
	new E2D(XMLPATH,EXCELPATH);		//程序启动

2.XML配置说明，请见EXCEL2DB.xsd文件 

3.特别说明
3.1 EXCEL的列需要用下标指定，以0作为第一列的下标
3.2 EXCEL不允许包含header信息
3.3 XML文件中，所有数据库字段均需要用string，程序自动忽略大小写
3.4 XML文件中，如果需要映射外键列，必须将isfk置为true
3.5 EXCEL中的数字列内容，必须转成文本类型（转换过程详见4.1）


4.问题列表
4.1避免excel科学技术法
  Excel 数值改字符  
  1.先把EAN 列改成 —数值— 型, 右击列选择 设置单元格格式 ， 在分类分类里面选择 —数值— 。  改得时候如果有 —小数位数—就把它改成0   
  2.选择所有要改的 数据 ， 把它 —复制—  到一个记事本里。 再把 EAN 列的数据删除掉。  你可以把 选择一列 然后DELETE（方向键上面）   
  3.选择原来的EAN 列，  把EAN 列改成 —文本— 型, 在分类分类里面选择 —文本— 。  
  4.再把原来 复制 到 记事本 的数据， 复制回Excel表格里的Ean列。   OK！！！！ 
  5.在下次要打这些东西之前，  前在那一列的 设置单元格格式 中， 把 分类改成 文本型。