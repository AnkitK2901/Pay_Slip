import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;

public class SalarySlip {
    public SalarySlip(int id, String name, int workingDays, double dailyWage, double deductions, double bonuses,
            String type, double salary) throws FileNotFoundException {
        double netSalary = salary + bonuses - deductions;
        long timestamp = System.currentTimeMillis();
        String pdfDest = "SalarySlip_" + timestamp + ".pdf";

        // Format the timestamp to dd/MM/yyyy HH:mm:ss in UTC+05:30 (Delhi/Kolkata)
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        String formattedDate = sdf.format(new Date(timestamp));

        StringBuilder htmlString = new StringBuilder("<!DOCTYPE html>\r\n"
                + "<html lang=\"en\">\r\n"
                + "<head>\r\n"
                + "    <meta charset=\"UTF-8\">\r\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
                + "    <title>Salary Slip</title>\r\n"
                + "    <style>\r\n"
                + "        body {\r\n"
                + "            font-family: 'Arial', sans-serif;\r\n"
                + "            background-color: #f8f9fa;\r\n"
                // + " background-color: red;\r\n"
                + "            padding: 20px;\r\n"
                + "            display: flex;\r\n"
                + "            justify-content: center;\r\n"
                + "            align-items: center;\r\n"
                + "        }\r\n"
                + "        .container {\r\n"
                + "            background: white;\r\n"
                + "            padding: 30px;\r\n"
                + "            width: 600px;\r\n"
                + "            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);\r\n"
                + "            border-radius: 10px;\r\n"
                + "        }\r\n"
                + "        h2 {\r\n"
                + "            text-align: center;\r\n"
                + "            color: #007bff;\r\n"
                + "        }\r\n"
                + "        .details p {\r\n"
                + "            font-size: 16px;\r\n"
                + "            margin: 10px 0;\r\n"
                + "        }\r\n"
                + "        .salary {\r\n"
                + "            font-size: 20px;\r\n"
                + "            font-weight: bold;\r\n"
                + "            text-align: center;\r\n"
                + "            color: #28a745;\r\n"
                + "        }\r\n"
                + "        hr {\r\n"
                + "            border: 1px solid #ddd;\r\n"
                + "        }\r\n"
                + "    </style>\r\n"
                + "</head>\r\n"
                + "<body>\r\n"
                + "    <div class='container'>\r\n"
                + "        <h2>PaySlip - 2025</h2>\r\n"
                + "        <hr>\r\n"
                + "        <div class='details'>\r\n"
                + "            <p><strong>ID:</strong> " + id + "</p>\r\n"
                + "            <p><strong>Name:</strong> " + name + "</p>\r\n");

        if (!type.equals("P")) {
            htmlString.append("            <p><strong>No. of Days Worked:</strong> " + workingDays + "</p>\r\n")
                    .append("            <p><strong>Daily Wages:</strong> ₹" + dailyWage + "</p>\r\n");
        }

        htmlString.append("            <p><strong>Deduction:</strong> ₹" + deductions + "</p>\r\n"
                + "            <p><strong>Bonus:</strong> ₹" + bonuses + "</p>\r\n"
                + "            <p><strong>Type:</strong> " + type + "</p>\r\n"
                + "            <p><strong>Salary:</strong> ₹" + salary + "</p>\r\n"
                + "        </div>\r\n"
                + "        <hr>\r\n"
                + "        <p class='salary'><strong>Net Salary:</strong> ₹" + netSalary + "</p>\r\n"
                + "        <p style='text-align: right; font-size: 12px;'>Generated on: " + formattedDate + "</p>\r\n"
                + "    </div>\r\n"
                + "</body>\r\n"
                + "</html>\r\n");

        // Convert HTML to PDF
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setFontProvider(new DefaultFontProvider(true, true, true));

        HtmlConverter.convertToPdf(htmlString.toString(), new FileOutputStream(pdfDest), converterProperties);

        // Open the created PDF file automatically
        openPDF(pdfDest);
    }

    private void openPDF(String filePath) {
        try {
            File pdfFile = new File(filePath);
            if (pdfFile.exists() && Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(pdfFile);
            } else {
                System.out.println("Desktop is not supported. Open the PDF manually: " + filePath);
            }
        } catch (IOException e) {
            System.out.println("Error opening PDF: " + e.getMessage());
        }
    }
}