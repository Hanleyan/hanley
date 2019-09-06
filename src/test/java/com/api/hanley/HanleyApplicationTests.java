package com.api.hanley;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.api.hanley.dao.ActionDao;
import com.api.hanley.dao.HanziIndexDao;
import com.api.hanley.entity.dto.Action;
import com.api.hanley.entity.dto.HanziIndex;
import com.api.hanley.service.CustomerService;
import com.api.hanley.service.PowerService;
import com.api.hanley.service.impl.SolrjServiceImpl;
import com.api.hanley.util.DataUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HanleyApplicationTests {

	@Autowired
	ActionDao actionDao;
	@Autowired
	HanziIndexDao hanziIndexDao;
	@Autowired
	PowerService powerService;

	@Autowired
	CustomerService customerService;

	@Test
	public void contextLoads() {
	}

	/**
	 * 生成Excel 1 -- 实体类注解型
	 * 七行代码搞定 Excel 生成
	 * @throws Exception
	 */
	@Test
	public void createEasyExcelDemo1()throws Exception{
		//文件输出位置
		OutputStream outputStream = new FileOutputStream("D:\\work\\pic\\easyExcelDemoHanzi.xlsx");
		ExcelWriter writer = EasyExcelFactory.getWriter(outputStream);

		//写一个仅有Sheet的excel文件
		Sheet sheet1 = new Sheet(1,0,HanziIndex.class);

		//第一个sheet名称
		sheet1.setSheetName("Hanzi表");

		//写数据到writer中
		//入参1，要写入的模型数据
		//目标sheet
		writer.write(hanziIndexDao.getHanziIndexList(),sheet1);

		//将上下文最终 outputStream 写入到指定文件中
		writer.finish();

		//关闭流
		outputStream.close();
	}

	/**
	 * 生成Excel 2 -- 动态生成excel
	 * @throws Exception
	 */
	@Test
	public void createEasyExcelDemo2()throws Exception{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//文件输出位置
		OutputStream outputStream = new FileOutputStream("D:\\work\\pic\\easyExcelDemoAction3.xlsx");
		ExcelWriter writer = EasyExcelFactory.getWriter(outputStream);

		//动态添加表头
		Sheet sheet1 = new Sheet(1,0);

		//sheet名称
		sheet1.setSheetName("Action表");

		//创建一个表格，动态添加表头
		Table table1 = new Table(1);
		//无注解的模式，动态添加表头
		table1.setHead(DataUtil.createExcelTestListStringHead());

		//写数据到writer中
		//入参1，要写入的模型数据
		//目标sheet
		List<List<Object>>  lists = new ArrayList<List<Object>>();
		List<Action>  list = actionDao.getActionList();
		for (Action action:list) {
			List<Object> objectList = new ArrayList<Object>();
			objectList.add(action.getId());
			objectList.add(action.getAction());
			objectList.add(action.getActionPath());
			objectList.add(format.format(action.getCreateTime()) );
			objectList.add(format.format(action.getUpdateTime()) );
			objectList.add(action.getDelFlag());
			lists.add(objectList);
		}

		writer.write1(powerService.getActionObjectList(),sheet1,table1);  //入参lists为List<List<Object>>

		//将上下文最终 outputStream 写入到指定文件中
		writer.finish();

		//关闭流
		outputStream.close();
	}
	/**
	 * 生成Excel 3 -- 自定义表头以及内容样式
	 */
	@Test
	public void createEasyExcelDemo3()throws Exception{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//文件输出位置
		OutputStream outputStream = new FileOutputStream("D:\\work\\pic\\easyExcelDemoAction6.xlsx");
		ExcelWriter writer = EasyExcelFactory.getWriter(outputStream);

		//动态添加表头
		Sheet sheet1 = new Sheet(1,0);
		Sheet sheet2 = new Sheet(1,0);

		//sheet名称
		sheet1.setSheetName("Action表");
		sheet2.setSheetName("其他");

		//创建一个表格，动态添加表头
		Table table1 = new Table(1);
		//自定义表格样式
		table1.setTableStyle(DataUtil.createTableStyle());
		//无注解的模式，动态添加表头
		table1.setHead(DataUtil.createExcelTestListStringHead());

		//写数据到writer中
		//入参1，要写入的模型数据
		//入参2,目标sheet
		//入参3,目标Table 表头
		writer.write1(powerService.getActionObjectList(),sheet1,table1);  //入参lists为List<List<Object>>

		//合并单元格
		writer.merge(5,6,0,5);//注意下标是从 0 开始的，也就是说合并了第六行到第七行，其中的第一列到第五列，

		//将上下文最终 outputStream 写入到指定文件中
		writer.finish();

		//关闭流
		outputStream.close();
	}

	/**
	 * Java最新手机号正则验证
	 *
	 * 中国电信号段 133、149、153、173、177、180、181、189、199
	 中国联通号段 130、131、132、145、155、156、166、175、176、185、186
	 中国移动号段 134(0-8)、135、136、137、138、139、147、150、151、152、157、158、159、178、182、183、184、187、188、198
	 其他号段
	 14号段以前为上网卡专属号段，如中国联通的是145，中国移动的是147等等。
	 虚拟运营商
	 电信：1700、1701、1702
	 移动：1703、1705、1706
	 联通：1704、1707、1708、1709、171
	 卫星通信：1349
	 */
	@Test
	public void isPhone() {
		boolean flag = false;
		String phone = "12621490798";
		String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
		if (phone.length() != 11) {
			System.out.println("手机号应为11位数");
		} else {
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(phone);
			flag = m.matches();
			if (!flag) {
				System.out.println("请填入正确的手机号");
			}
		}
		System.out.println(flag);
	}

	@Test
	public void asa(){
		String str = "[   ]";
		System.out.println(str.length());
	}

	@Test
	public void LocalDateTest(){
		LocalDate today = LocalDate.now();
		System.out.println("LocalDate.now():"+today);

		LocalDate birthday = LocalDate.of(1994,10,12);
		System.out.println("LocalDate.of():"+birthday);

		LocalDate day = LocalDate.of(2019,6,3);
		System.out.println("LocalDate.of():"+day);
	}


	@Test
	public void addTosolr() throws Exception{
		this.customerService.addTosolr();
	}
}
