package com.codecrane.core.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * ExcelReader Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>三月 20, 2016</pre>
 */
@Slf4j
public class ExcelReaderTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: readExcel(String fileName)
     */
    @Test
    public void testReadExcel() throws Exception {

        /*
        try {
            List<Map<String,String>> excelData = ExcelReader.readExcel("/Users/crane/Desktop/收视率-20160407-V1.0.xls");

            int rowNum = 1;
            for (Map<String,String> data : excelData){
                log.debug("--------- row "+rowNum+"---------");
                for( String key: data.keySet() ){
                    log.debug("key:"+key+" value:"+data.get(key));
                }
                rowNum++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        */

    }

    /**
     * Method: read(FileInputStream fis, String extension)
     */
    @Test
    public void testRead() throws Exception {


    }

    /**
     * Method: readWorkbook(Workbook wb)
     */
    @Test
    public void testReadWorkbook() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getCellValue(Cell cell)
     */
    @Test
    public void testGetCellValue() throws Exception {
//TODO: Test goes here... 
    }


    /**
     * Method: formatDate(Date d, String sdf)
     */
    @Test
    public void testFormatDate() throws Exception {

    }

} 
