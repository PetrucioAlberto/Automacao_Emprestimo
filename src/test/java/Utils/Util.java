package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Util  {

    public static String buscarDadosClientes(int linha, int coluna) throws IOException {
        // Open the Excel file
        FileInputStream arquivo = new FileInputStream("ArquivoExcel/MassaDeTeste.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

        // Get the first sheet of the Excel file
        Sheet sheet = workbook.getSheetAt(0);

        // Get the row and cell specified by the method arguments
        Row row = sheet.getRow(linha);
        Cell cell = row.getCell(coluna);

        // Get the string value of the cell and close the Excel file
        String valorCelula = cell.getStringCellValue();
        arquivo.close();

        return valorCelula;
    }


}
