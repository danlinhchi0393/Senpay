package Common;



import java.util.ArrayList;

import java.util.List;

import com.codoid.products.exception.FilloException;

import com.codoid.products.fillo.Connection;

import com.codoid.products.fillo.Fillo;

import com.codoid.products.fillo.Recordset;



public class ReadExcel {

// static WebDriver driver;

 public static List<String> GetValue( String query ) throws FilloException {

  String uName, uPass;

  Fillo fillo = new Fillo();

  Connection conn = fillo.getConnection("Book1.xlsx");

  //String query1 = "Select * from Sheet1";

  Recordset record = conn.executeQuery(query);



  List<String> name = new ArrayList<>();

  List<String> pass = new ArrayList<>();

  // thêm name và pass vào mảng

  while (record.next()) {

   name.add(record.getField("username"));

   pass.add(record.getField("password"));

  }

  // mỗi vị trí i, lấy name và pass ở 2 cột tương ứng

//  for (int i = 0; i < name.size(); i++) {
//
//   uName = name.get(i);

//   uPass = pass.get(i);

  // đóng kết nối
  // System.out.print(uName);
  // System.out.print(uPass);
//  }
  record.close();

  conn.close();
return name;

 
 }
}


