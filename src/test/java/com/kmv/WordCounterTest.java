package com.kmv;

import com.kmv.util.FileContentDetail;
import com.kmv.util.FileUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author khosro.makari@gmail.com
 */
public class WordCounterTest {

    //unitOfWork_behaviotState_expectedResult
    @Test
    public void fileContentDetails_correctfilePath_haveResult() {
        //init
        String path = "example.txt";

        //expectedResult
        int expectedLines = 5;
        int expectedWords = 9;
        int expectedCharachters = 36;

        //act
        FileContentDetail fileContentDetail = FileUtil.getFileContentDetails(path);

        //assert
        Assert.assertEquals(expectedLines, fileContentDetail.getLines());
        Assert.assertEquals(expectedWords, fileContentDetail.getWords());
        Assert.assertEquals(expectedCharachters, fileContentDetail.getCharacters());
    }

    @Test(expected = RuntimeException.class)
    public void fileContentDetails_wrongFilePath_throwsException() {
        //init
        String path = "aaaaaaaaaaaaaaaa";

        //act
        FileUtil.getFileContentDetails(path);
    }
}
