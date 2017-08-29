package com.sample.model.word;

import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Tr;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface WordService {
  DocxStyle getMainCell();

  DocxStyle getHeader();

  DocxStyle getCellLeft();

  DocxStyle getTaRight();

  DocxStyle getNormal();

  DocxStyle getTaRightCenter();

  DocxStyle getTitle();

  DocxStyle getTitleBgLeft();

  DocxStyle getTitleBgRight();

  DocxStyle getSubTitle();

  DocxStyle getSignTitle();

  DocxStyle getSignDesc();

  DocxStyle getSignDate();

  DocxStyle getSignBoard();

  DocxStyle getSignMember();

  DocxStyle getSignMemberLast();

  DocxStyle getList();

  DocxStyle getListEmpty();

  DocxStyle getListEmptyLeft();

  DocxStyle getListEmptyRight();

  DocxStyle getListBgLeft();

  DocxStyle getListBgRight();

  DocxStyle getNumberTitle();

  DocxStyle getHeaderWhite();

  void pageBreak(WordprocessingMLPackage wordMLPackage);

  void addTc(Tr tr, String text, String width, DocxStyle style, int horizontalMergedCells, String verticalMergedVal, boolean isBullet, WordprocessingMLPackage wordMLPackage) throws JAXBException, InvalidFormatException;

  void addTcList(Tr tr, List<String> text, String width, DocxStyle style, int horizontalMergedCells, String verticalMergedVal, boolean isBullet, WordprocessingMLPackage wordMLPackage) throws JAXBException, InvalidFormatException;

  void addParagraph(MainDocumentPart documentPart, ObjectFactory factory, String title, boolean isTitle);

  void addListParagraph(MainDocumentPart documentPart, ObjectFactory factory, String title, String depth);

  void addTitleParagraph(MainDocumentPart documentPart, ObjectFactory factory, String title, boolean isDate);

  void createBullet(String country, WordprocessingMLPackage wordMLPackage) throws InvalidFormatException, JAXBException;

  Tbl getTable();

  P newImage(WordprocessingMLPackage wordMLPackage, byte[] bytes, String filenameHint, String altText, int id1, int id2, long cx) throws Exception;
}
