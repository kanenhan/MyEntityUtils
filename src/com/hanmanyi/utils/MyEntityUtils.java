package com.hanmanyi.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
/**
 * @author:hanmanyi
 * @time:Feb 2, 2015 10:25:11 AM
 */
/**
 * ���ݿ��ת����javaBean����С����(�����˺ܳ�ʱ��),
 * 1 bean���԰�ԭʼ���ݿ��ֶξ���ȥ���»���,����д��������ĸ�ȵ�.
 * 2 ���ɵ�bean�������ݿ���ֶ�˵��.
 * 3 ��λ�Լ������޸Ĵ˹����õ���Ŀ��ȥ.
 */
public class MyEntityUtils {
	private String tablename = "";
	private String[] colnames;
	private String[] colTypes;
	private int[] colSizes; // ������С
	private int[] colScale; // ����С������
	private boolean importUtil = false;
	private boolean importSql = false;
	private boolean importMath = false;

	/**
	 * @param args
	 * ��λ���Լ���
	 */
	public void tableToEntity(String tName) {
		tablename = tName;
		//������Connection��ȡ,�Լ���취����.
		Connection conn = null;
		conn = getConnection();
		String strsql = "SELECT * FROM " + tablename;//+" WHERE ROWNUM=1" ��һ�м�¼;
		try {
			System.out.println(strsql);
			
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(strsql);
			pstmt.executeQuery();
			ResultSetMetaData rsmd = (ResultSetMetaData) pstmt.getMetaData();
			int size = rsmd.getColumnCount(); // ���ж�����
			colnames = new String[size];
			colTypes = new String[size];
			colSizes = new int[size];
			colScale = new int[size];
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				rsmd.getCatalogName(i + 1);
				colnames[i] = rsmd.getColumnName(i + 1).toLowerCase();
				colTypes[i] = rsmd.getColumnTypeName(i + 1).toLowerCase();
				colScale[i] = rsmd.getScale(i + 1);
				//System.out.println(rsmd.getCatalogName(i+1));
				if ("datetime".equals(colTypes[i])) {
					importUtil = true;
				}
				if ("image".equals(colTypes[i]) || "text".equals(colTypes[i])) {
					importSql = true;
				}
				if(colScale[i]>0){
					importMath = true;
				}
				colSizes[i] = rsmd.getPrecision(i + 1);
			}
			String content = parse(colnames, colTypes, colSizes);
			try {
				FileWriter fw = new FileWriter(initcap(tablename) + ".java");
				PrintWriter pw = new PrintWriter(fw);
				pw.println(content);
				pw.flush();
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ��������(����ʵ�����������)
	 */
	private String parse(String[] colNames, String[] colTypes, int[] colSizes) {
		StringBuffer sb = new StringBuffer();
		sb.append("\r\nimport java.io.Serializable;\r\n");
		if (importUtil) {
			sb.append("import java.util.Date;\r\n");
		}
		if (importSql) {
			sb.append("import java.sql.*;\r\n\r\n");
		}
		if(importMath){
			sb.append("import java.math.*;\r\n\r\n");
		}
		//��ע��
		processColnames(sb);
		sb.append("public class " + initcap(tablename) + " implements Serializable {\r\n");
		processAllAttrs(sb);
		processAllMethod(sb);
		sb.append("}\r\n");
		//System.out.println(sb.toString());
		return sb.toString();

	}
	/**
	 * ��������,�ѿո��»���'_'ȥ��,ͬʱ���»��ߺ������ĸ��д
	 * Ҫ����������3���ַ�������,��ȥ��'_'��,����"_"������ĸ��д.
	 * ͬʱ�����ݿ�����,������д��ע�����Ա�鿴,
	 * @param sb
	 */
	private void processColnames(StringBuffer sb) {
		sb.append("\r\n/** " + tablename + "\r\n");
		String colsiz="";
		String colsca="";
		for (int i = 0; i < colnames.length; i++) {
			colsiz = colSizes[i]<=0? "" : (colScale[i]<=0? "("+colSizes[i]+")" : "("+colSizes[i]+","+colScale[i]+")");
			sb.append("\t" + colnames[i].toUpperCase() +"	"+colTypes[i].toUpperCase()+ colsiz+"\r\n");
			char[] ch = colnames[i].toCharArray();
			char c ='a';
			if(ch.length>3){
				for(int j=0;j <ch.length; j++){
					c = ch[j];
					if(c == '_'){
						if (ch[j+1]>= 'a' && ch[j+1] <= 'z') {
							ch[j+1]=(char) (ch[j+1]-32);
						}
					}
				}
			}
			String str = new String(ch);
			colnames[i] = str.replaceAll("_", "");
		}
		sb.append("*/\r\n");
	}
	/**
	 * �������еķ���
	 * 
	 * @param sb
	 */
	private void processAllMethod(StringBuffer sb) {
		for (int i = 0; i < colnames.length; i++) {
			sb.append("\tpublic void set" + initcap(colnames[i]) + "("
					+ oracleSqlType2JavaType(colTypes[i],colScale[i],colSizes[i]) + " " + colnames[i]
					+ "){\r\n");
			sb.append("\t\tthis." + colnames[i] + "=" + colnames[i] + ";\r\n");
			sb.append("\t}\r\n");

			sb.append("\tpublic " + oracleSqlType2JavaType(colTypes[i],colScale[i],colSizes[i]) + " get"
					+ initcap(colnames[i]) + "(){\r\n");
			sb.append("\t\treturn " + colnames[i] + ";\r\n");
			sb.append("\t}\r\n");
		}
	}

	/**
	 * �����������
	 * 
	 * @return
	 */
	private void processAllAttrs(StringBuffer sb) {
		sb.append("\tprivate static final long serialVersionUID = 1L;\r\n");
		for (int i = 0; i < colnames.length; i++) {
			sb.append("\tprivate " + oracleSqlType2JavaType(colTypes[i],colScale[i],colSizes[i]) + " "
					+ colnames[i] + ";\r\n");
		}
		sb.append("\r\n");
	}

	/**
	 * �������ַ���������ĸ�ĳɴ�д
	 * @param str
	 * @return
	 */
	private String initcap(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);
	}

	/**
	 * Oracle
	 * @param sqlType
	 * @param scale
	 * @return
	 */
	private String oracleSqlType2JavaType(String sqlType, int scale,int size) {
		if (sqlType.equals("integer") ||sqlType.equals("tinyint")) {
			return "Integer";
		} else if (sqlType.equals("long")|| sqlType.equals("bigint")) {
			return "Long";
		} else if (sqlType.equals("float")
				|| sqlType.equals("float precision")
				|| sqlType.equals("double")
				|| sqlType.equals("double precision")
				) {
			return "BigDecimal";
		}else if (sqlType.equals("number")
				||sqlType.equals("decimal")
				|| sqlType.equals("numeric")
				|| sqlType.equals("real")) {
			return scale==0? (size<10? "Integer" : "Long") : "BigDecimal";
		}else if (sqlType.equals("varchar")
				|| sqlType.equals("varchar2")
				|| sqlType.equals("char")
				|| sqlType.equals("nvarchar")
				|| sqlType.equals("nchar")) {
			return "String";
		} else if (sqlType.equals("datetime")
				|| sqlType.equals("date")
				|| sqlType.equals("timestamp")) {
			return "Date";
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyEntityUtils t = new MyEntityUtils();
		t.tableToEntity("t_course");
	}

	public Connection getConnection(){
		 // ����������
        String driver = "com.mysql.jdbc.Driver";

        // URLָ��Ҫ���ʵ����ݿ���scutcs
        String url = "jdbc:mysql://192.168.5.100:3306/ciires?useUnicode=true&characterEncoding=UTF-8";

        // MySQL����ʱ���û���
        String user = "root"; 

        // MySQL����ʱ������
        String password = "root";
        
        Connection conn = null;

        try { 
         // ������������
         Class.forName(driver);

         // �������ݿ�
         conn = DriverManager.getConnection(url, user, password);
         if(!conn.isClosed()) 
          System.out.println("Succeeded connecting to the Database!");
        } catch(ClassNotFoundException e) {
         System.out.println("Sorry,can`t find the Driver!"); 
         e.printStackTrace();
        } catch(SQLException e) {
         e.printStackTrace();
        } catch(Exception e) {
         e.printStackTrace();
        } 
        return conn;
	}
	
}
