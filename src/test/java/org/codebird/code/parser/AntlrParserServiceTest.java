package org.codebird.code.parser;

import org.codebird.code.entity.source.ClassInfo;
import org.codebird.code.entity.source.Field;
import org.codebird.code.entity.source.JavaFile;
import org.codebird.code.entity.source.Method;
import org.codebird.code.listener.Java8ListenerImpl;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sundeep
 */
// @RunWith(SpringRunner.class)
// @SpringBootTest
public class AntlrParserServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AntlrParserServiceTest.class);
    private static final String HELLO_UNIVERSE_JAVA = "HelloUniverse.java";

    // @Autowired
    AntlrParserService parserService = new AntlrParserService();

    @Test
    public void testParserBasic() throws IOException {
        // Prepare file
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("java_test_source/HelloUniverse.java");
        Assert.assertNotNull("Input stream can't be null", is);
        File temp = null,simpleJavaFile = null;
        // Prepare temp directory
        temp = File.createTempFile("temp", null);
        Assert.assertTrue(temp.delete());
        File dir = new File(temp.getAbsolutePath());
        Assert.assertTrue(dir.mkdir());
        // Copy the test java file
        simpleJavaFile = new File(dir,HELLO_UNIVERSE_JAVA);
        Files.copy(is,simpleJavaFile.toPath());

        // Parse the source file
        Java8ListenerImpl listener = new Java8ListenerImpl(new JavaFile(simpleJavaFile.getAbsolutePath()));
        parserService.walkSourceFile(simpleJavaFile, listener);

        JavaFile javaFile = listener.getJavaFile();
        Assert.assertNotNull(javaFile);
        Assert.assertNotNull(javaFile.getClassInfoList());
        Assert.assertEquals(1, javaFile.getClassInfoList().size());

        ClassInfo classInfo = javaFile.getClassInfoList().get(0);

        List<String> importList = classInfo.getImportList();
        List<Field> fieldList = classInfo.getFieldList();
        List<Method> methodList = classInfo.getMethodList();

        // Verify the output
        Assert.assertNotNull(importList);
        Assert.assertNotNull(fieldList);
        Assert.assertNotNull(methodList);

        Assert.assertEquals(1, importList.size());
        Assert.assertEquals(3, fieldList.size());
        Assert.assertEquals(3, methodList.size());

        List<String> expectedImports = new ArrayList<>();
        expectedImports.add("java.util.Map");


    }

}
