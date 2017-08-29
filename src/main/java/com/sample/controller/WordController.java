package com.sample.controller;

import com.sample.model.word.DocxStyle;
import com.sample.model.word.WordService;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Tr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sample.model.word.WordServiceImpl.factory;


@RestController
@RequestMapping("/api/word")
public class WordController {

  @Autowired
  WordService wordService;

  @RequestMapping(value = "/sample")
  public void university() throws Exception {

    WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();

    DocxStyle header = wordService.getHeader();
    DocxStyle normal = wordService.getNormal();

    wordService.addParagraph(wordMLPackage.getMainDocumentPart(), factory, "워드 출력 샘플", true);
    Tbl tblSample = wordService.getTable();
    Tr trSampleHeader = factory.createTr();
    wordService.addTc(trSampleHeader, "No", "1000", header, 1, null, false, wordMLPackage);
    wordService.addTc(trSampleHeader, "이름", "1000", header, 1, null, false, wordMLPackage);
    wordService.addTc(trSampleHeader, "생년월일", "2000", header, 1, null, false, wordMLPackage);
    wordService.addTc(trSampleHeader, "대학", "2500", header, 1, null, false, wordMLPackage);
    wordService.addTc(trSampleHeader, "전공", "2500", header, 1, null, false, wordMLPackage);
    tblSample.getEGContentRowContent().add(trSampleHeader);

    Tr trSampleRow1 = factory.createTr();
    wordService.addTc(trSampleRow1, "1", "1000", normal, 1, null, false, wordMLPackage);
    wordService.addTc(trSampleRow1, "홍길동", "1000", normal, 1, null, false, wordMLPackage);
    wordService.addTc(trSampleRow1, "900628", "2000", normal, 1, null, false, wordMLPackage);
    wordService.addTc(trSampleRow1, "서울대학교", "2500", normal, 1, null, false, wordMLPackage);
    wordService.addTc(trSampleRow1, "컴퓨터공학과", "2500", normal, 1, null, false, wordMLPackage);
    tblSample.getEGContentRowContent().add(trSampleRow1);

    Tr trSampleRow2 = factory.createTr();
    wordService.addTc(trSampleRow2, "2", "1000", normal, 1, null, false, wordMLPackage);
    wordService.addTc(trSampleRow2, "김철수", "1000", normal, 1, null, false, wordMLPackage);
    wordService.addTc(trSampleRow2, "911212", "2000", normal, 1, null, false, wordMLPackage);
    wordService.addTc(trSampleRow2, "고려대학교", "2500", normal, 1, null, false, wordMLPackage);
    wordService.addTc(trSampleRow2, "컴퓨터공학과", "2500", normal, 1, null, false, wordMLPackage);
    tblSample.getEGContentRowContent().add(trSampleRow2);

    Tr trSampleRow3 = factory.createTr();
    wordService.addTc(trSampleRow3, "3", "1000", normal, 1, null, false, wordMLPackage);
    wordService.addTc(trSampleRow3, "임꺽정", "1000", normal, 1, null, false, wordMLPackage);
    wordService.addTc(trSampleRow3, "921022", "2000", normal, 1, null, false, wordMLPackage);
    wordService.addTc(trSampleRow3, "서울대학교", "2500", normal, 1, null, false, wordMLPackage);
    wordService.addTc(trSampleRow3, "의상디자인학과", "2500", normal, 1, null, false, wordMLPackage);
    tblSample.getEGContentRowContent().add(trSampleRow3);

    Tr trSampleRow4 = factory.createTr();
    wordService.addTc(trSampleRow4, "4", "1000", normal, 1, null, false, wordMLPackage);
    wordService.addTc(trSampleRow4, "김나나", "1000", normal, 1, null, false, wordMLPackage);
    wordService.addTc(trSampleRow4, "870202", "2000", normal, 1, null, false, wordMLPackage);
    wordService.addTc(trSampleRow4, "고려대학교", "2500", normal, 1, null, false, wordMLPackage);
    wordService.addTc(trSampleRow4, "유아교육학과", "2500", normal, 1, null, false, wordMLPackage);
    tblSample.getEGContentRowContent().add(trSampleRow4);

    wordMLPackage.getMainDocumentPart().addObject(tblSample);

    // 출력을 원하는 경로를 지정해서 수정하시기 바랍니다.
    wordMLPackage.save(new java.io.File("D:/dev/resources/sample.docx"));
  }
}
