
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;


// Importing required classes
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;
import com.clientservice.service.*;
import com.clientservice.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.mock.web.MockMultipartFile;
import java.io.*;





@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings({"unchecked", "deprecation"})
public class FileUploadServiceMockTest
{


    @Autowired
    FileUploadService fileUploadService;




    @Test
    public void TestExample() {

        MultipartFile multipartFile = null;
        try {
            multipartFile = new MockMultipartFile("test", new FileInputStream(new File("src/test/resources/test")));

        }
        catch(Exception e)
        {

        }
        String res =  fileUploadService.uploadFile(multipartFile);
        assertThat(res.equals("success:"));
    }

}
