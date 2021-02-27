package configurations;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.xml.XmlSuite;
public class PDFReporterConfig extends CreatePDFReport implements IReporter{
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        for(ISuite ist : suites){
            try{

                openPdfPath();
//*************//
                Map<String, ISuiteResult> resultSuiteMap = ist.getResults();
                Set<String> key = resultSuiteMap.keySet();
                for(String k : key){
                    ITestContext context = resultSuiteMap.get(k).getTestContext();
                    System.out.println("Suite Name- "+context.getName()
                            +"\n Suite Name- "+context.getSuite().getName()
                            + "\n Start Date Time for Execution- "+context.getStartDate()
                            + "\n End Date Time for Execution- "+context.getEndDate());

                    addParagraph("Suite Name- "+context.getName()
                            +"\n Failed Tests- "+context.getFailedTests().size()
                            +"\n Passed Tests- "+context.getPassedTests().size()
                            +"\n Suite Name- "+context.getSuite().getName()
                            + "\n Start Date Time for Execution- "+context.getStartDate()
                            + "\n End Date Time for Execution- "+context.getEndDate());
                    IResultMap resultMap  = context.getFailedTests();
                    Collection<ITestNGMethod> failedMethods = resultMap.getAllMethods();
                    for(ITestNGMethod imd : failedMethods){
                        System.out.println("Failed Test Case(s)"+imd.getMethodName()
                                + "\n Date- "+new Date(imd.getDate()));

                        addParagraph(" Failed Test Case(s)\n"+imd.getMethodName()
                                + "\n Date- "+new Date(imd.getDate())+ "\n");
                    }

                    IResultMap passedTest = context.getPassedTests();
                    Collection<ITestNGMethod> passedMethods = passedTest.getAllMethods();
                    for(ITestNGMethod imd1 : passedMethods){
                        System.out.println("Test Case Name "+imd1.getMethodName()

                                + "\n Date- "+new Date(imd1.getDate()));

                        addParagraph(" Passed Test Case(s)\n"+imd1.getMethodName()

                                + "\n Date- "+new Date(imd1.getDate()));
                    }
                }
//Closing PDF file
                closePdf();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}