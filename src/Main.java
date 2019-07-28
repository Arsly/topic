//_01_匯入pdf所需檔案
import org.apache.pdfbox.pdmodel.*;
//_02_匯入pdf文字解析工具
import org.apache.pdfbox.text.PDFTextStripper;
//_03_記憶體調適
import org.apache.pdfbox.io.MemoryUsageSetting;
//_04_呼叫檔案工具
import java.io.File;

public class Main {
    public static void main(String[] args) {
        //指定檔案位置，解析文件放在專案根目錄
        File pdffile = new File("./test.pdf");
        try {
            //使用PDDocument設定document，載入pdf文件內容，setupMainMemoryOnly啟動檔案上限功能，不受檔案大小限制
            PDDocument document = PDDocument.load(pdffile,MemoryUsageSetting.setupMainMemoryOnly());
            //使用PDFTextStripper設定Stripper為文字解析工具
            PDFTextStripper Stripper = new PDFTextStripper();
            //解析進行時，依照內容由上到下排序
            Stripper.setSortByPosition(true);
            //設定Res，使用Stripper取得pdf文件
            String Res = Stripper.getText(document);
            //Res為解析出的文字內容
            System.out.println(Res);
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}