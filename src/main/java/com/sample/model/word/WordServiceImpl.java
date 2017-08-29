package com.sample.model.word;

import org.docx4j.XmlUtils;
import org.docx4j.dml.wordprocessingDrawing.Inline;
import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.BinaryPartAbstractImage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.openpackaging.parts.WordprocessingML.NumberingDefinitionsPart;
import org.docx4j.wml.*;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.math.BigInteger;
import java.util.List;


@Service("wordService")
public class WordServiceImpl implements WordService {

  public static ObjectFactory factory = new ObjectFactory();
  private static final String BULLET_TEMPLATE = "<w:numbering xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\">" +
      "<w:abstractNum w:abstractNumId=\"0\">" +
      "<w:nsid w:val=\"12D402B7\"/>" +
      "<w:multiLevelType w:val=\"hybridMultilevel\"/>" +
      "<w:tmpl w:val=\"AECAFC2E\"/>" +
      "<w:lvl w:ilvl=\"0\" w:tplc=\"04090001\">" +
      "<w:start w:val=\"1\"/>" +
      "<w:numFmt w:val=\"bullet\"/>" +
      "<w:lvlText w:val=\"\uF0B7\"/>" +
      "<w:lvlJc w:val=\"left\"/>" +
      "<w:pPr>" +
      "<w:ind w:left=\"360\" w:hanging=\"360\"/>" +
      "</w:pPr>" +
      "<w:rPr>" +
      "<w:rFonts w:ascii=\"Symbol\" w:hAnsi=\"Symbol\" w:hint=\"default\"/>" +
      "</w:rPr>" +
      "</w:lvl>" +
      "</w:abstractNum>" +
      "<w:num w:numId=\"1\">" +
      "<w:abstractNumId w:val=\"0\"/>" +
      "</w:num>" +
      "</w:numbering>";

  @Override
  public DocxStyle getMainCell() {
    DocxStyle mainCell = new DocxStyle();
    mainCell.setVerticalAlignment(STVerticalJc.CENTER);
    mainCell.setHorizontalAlignment(JcEnumeration.CENTER);
    mainCell.setFontSize("20");
    return mainCell;
  }

  @Override
  public DocxStyle getHeader() {
    DocxStyle header = new DocxStyle();
    header.setBold(true);
    header.setHorizontalAlignment(JcEnumeration.CENTER);
    header.setVerticalAlignment(STVerticalJc.CENTER);
    header.setBackground("dddddd");
    header.setFontSize("20");
    return header;
  }

  @Override
  public DocxStyle getHeaderWhite() {
    DocxStyle headerWhite = new DocxStyle();
    headerWhite.setBold(true);
    headerWhite.setHorizontalAlignment(JcEnumeration.LEFT);
    headerWhite.setVerticalAlignment(STVerticalJc.CENTER);
    headerWhite.setFontSize("22");
    return headerWhite;
  }

  @Override
  public DocxStyle getCellLeft() {
    DocxStyle mainCellLeft = new DocxStyle();
    mainCellLeft.setBold(true);
    mainCellLeft.setVerticalAlignment(STVerticalJc.CENTER);
    mainCellLeft.setHorizontalAlignment(JcEnumeration.LEFT);
    mainCellLeft.setFontSize("20");
    mainCellLeft.setBackground("dddddd");
    return mainCellLeft;
  }

  @Override
  public DocxStyle getTaRight() {
    DocxStyle taRight = new DocxStyle();
    taRight.setHorizontalAlignment(JcEnumeration.RIGHT);
    taRight.setFontSize("20");
    return taRight;
  }

  @Override
  public DocxStyle getTaRightCenter() {
    DocxStyle taRightCenter = new DocxStyle();
    taRightCenter.setVerticalAlignment(STVerticalJc.CENTER);
    taRightCenter.setHorizontalAlignment(JcEnumeration.RIGHT);
    taRightCenter.setFontSize("20");
    return taRightCenter;
  }

  @Override
  public DocxStyle getNormal() {
    DocxStyle normal = new DocxStyle();
    normal.setFontSize("20");
    return normal;
  }

  @Override
  public DocxStyle getTitle() {
    DocxStyle title = new DocxStyle();
    title.setFontSize("56");
    title.setHorizontalAlignment(JcEnumeration.CENTER);
    title.setBold(true);
    title.setBorderLeft(true);
    title.setBorderRight(true);
    title.setBorderBottom(true);
    title.setTop(200);
    title.setBottom(50);
    return title;
  }

  @Override
  public DocxStyle getNumberTitle() {
    DocxStyle numberTitle = new DocxStyle();
    numberTitle.setFontSize("56");
    numberTitle.setHorizontalAlignment(JcEnumeration.CENTER);
    numberTitle.setBold(true);
    numberTitle.setBorderLeft(true);
    numberTitle.setBorderRight(true);
    numberTitle.setBorderBottom(true);
    numberTitle.setTop(800);
    numberTitle.setBottom(800);
    return numberTitle;
  }

  @Override
  public DocxStyle getSubTitle() {
    DocxStyle subTitle = new DocxStyle();
    subTitle.setFontSize("36");
    subTitle.setHorizontalAlignment(JcEnumeration.CENTER);
    subTitle.setBorderTop(true);
    subTitle.setBorderRight(true);
    subTitle.setBorderBottom(true);
    subTitle.setBorderLeft(true);
    subTitle.setBottom(200);
    return subTitle;
  }

  @Override
  public DocxStyle getTitleBgLeft() {
    DocxStyle titleBgLeft = new DocxStyle();
    titleBgLeft.setFontSize("4");
    titleBgLeft.setBackground("ebaf0b");
    titleBgLeft.setFontColor("ebaf0b");
    titleBgLeft.setBorderTop(true);
    titleBgLeft.setBorderRight(true);
    titleBgLeft.setBorderBottom(true);
    titleBgLeft.setBorderLeft(true);
    return titleBgLeft;
  }

  @Override
  public DocxStyle getTitleBgRight() {
    DocxStyle titleBgRight = new DocxStyle();
    titleBgRight.setFontSize("4");
    titleBgRight.setBackground("c95150");
    titleBgRight.setFontColor("c95150");
    titleBgRight.setBorderTop(true);
    titleBgRight.setBorderRight(true);
    titleBgRight.setBorderBottom(true);
    titleBgRight.setBorderLeft(true);
    return titleBgRight;
  }

  @Override
  public DocxStyle getSignTitle() {
    DocxStyle signTitle = new DocxStyle();
    signTitle.setFontSize("36");
    signTitle.setHorizontalAlignment(JcEnumeration.CENTER);
    signTitle.setBold(true);
    signTitle.setTop(200);
    signTitle.setBottom(200);
    return signTitle;
  }

  @Override
  public DocxStyle getSignDesc() {
    DocxStyle signDesc = new DocxStyle();
    signDesc.setFontSize("28");
    signDesc.setTop(200);
    signDesc.setBottom(3600);
    signDesc.setBorderBottom(true);
    return signDesc;
  }

  @Override
  public DocxStyle getSignDate() {
    DocxStyle signDate = new DocxStyle();
    signDate.setHorizontalAlignment(JcEnumeration.CENTER);
    signDate.setFontSize("28");
    signDate.setTop(200);
    signDate.setBottom(3000);
    signDate.setBorderTop(true);
    signDate.setBorderBottom(true);
    return signDate;
  }

  @Override
  public DocxStyle getSignBoard() {
    DocxStyle signBoard = new DocxStyle();
    signBoard.setHorizontalAlignment(JcEnumeration.RIGHT);
    signBoard.setFontSize("32");
    signBoard.setTop(200);
    signBoard.setBottom(400);
    signBoard.setBorderTop(true);
    signBoard.setBorderBottom(true);
    return signBoard;
  }

  @Override
  public DocxStyle getSignMember() {
    DocxStyle signMember = new DocxStyle();
    signMember.setHorizontalAlignment(JcEnumeration.RIGHT);
    signMember.setFontSize("24");
    signMember.setBorderTop(true);
    signMember.setBorderBottom(true);
    return signMember;
  }

  @Override
  public DocxStyle getSignMemberLast() {
    DocxStyle signMemberLast = new DocxStyle();
    signMemberLast.setHorizontalAlignment(JcEnumeration.RIGHT);
    signMemberLast.setFontSize("24");
    signMemberLast.setBorderTop(true);
    signMemberLast.setBottom(200);
    return signMemberLast;
  }

  @Override
  public DocxStyle getList() {
    DocxStyle list = new DocxStyle();
    list.setFontSize("36");
    list.setBold(true);
    list.setHorizontalAlignment(JcEnumeration.CENTER);
    return list;
  }

  @Override
  public DocxStyle getListEmpty() {
    DocxStyle listEmpty = new DocxStyle();
    listEmpty.setFontSize("36");
    listEmpty.setBorderTop(true);
    listEmpty.setBorderRight(true);
    listEmpty.setBorderBottom(true);
    listEmpty.setBorderLeft(true);
    return listEmpty;
  }

  @Override
  public DocxStyle getListEmptyLeft() {
    DocxStyle listEmptyLeft = new DocxStyle();
    listEmptyLeft.setFontSize("36");
    listEmptyLeft.setBorderTop(true);
    listEmptyLeft.setBorderBottom(true);
    listEmptyLeft.setBorderLeft(true);
    return listEmptyLeft;
  }

  @Override
  public DocxStyle getListEmptyRight() {
    DocxStyle listEmptyRight = new DocxStyle();
    listEmptyRight.setFontSize("36");
    listEmptyRight.setBorderTop(true);
    listEmptyRight.setBorderBottom(true);
    listEmptyRight.setBorderRight(true);
    return listEmptyRight;
  }

  @Override
  public DocxStyle getListBgLeft() {
    DocxStyle listBgLeft = new DocxStyle();
    listBgLeft.setFontSize("36");
    listBgLeft.setBackground("ebaf0b");
    listBgLeft.setBorderTop(true);
    listBgLeft.setBorderRight(true);
    listBgLeft.setBorderBottom(true);
    listBgLeft.setBorderLeft(true);
    return listBgLeft;
  }

  @Override
  public DocxStyle getListBgRight() {
    DocxStyle listBgRight = new DocxStyle();
    listBgRight.setFontSize("36");
    listBgRight.setBackground("c95150");
    listBgRight.setBorderTop(true);
    listBgRight.setBorderRight(true);
    listBgRight.setBorderBottom(true);
    listBgRight.setBorderLeft(true);
    return listBgRight;
  }

  @Override
  public void pageBreak(WordprocessingMLPackage wordMLPackage) {
    Br breakobj = new Br();
    breakobj.setType(STBrType.PAGE);
    P paragraph = factory.createP();
    paragraph.getContent().add(breakobj);
    wordMLPackage.getMainDocumentPart().getJaxbElement().getBody().getContent().add(paragraph);
  }

  @Override
  public void addTc(Tr tr, String text, String width, DocxStyle style, int horizontalMergedCells, String verticalMergedVal, boolean isBullet, WordprocessingMLPackage wordMLPackage) throws JAXBException, InvalidFormatException {
    Tc tc = factory.createTc();
    TcPr tcPr = new TcPr();
    TblWidth tblwidth = new TblWidth();
    tblwidth.setType("dxa");
    tblwidth.setW(new BigInteger(width));
    tcPr.setTcW(tblwidth);
    tc.setTcPr(tcPr);
    setCellVMerge(tc, verticalMergedVal);
    setCellHMerge(tc, horizontalMergedCells);
    if (style != null) {
      if (isBullet) {
        addCellBullet(tc, text, wordMLPackage);
      } else {
        addCellStyle(tc, text, style);
      }
    } else {
      tc.getEGBlockLevelElts().add(wordMLPackage.getMainDocumentPart().createParagraphOfText(text));
    }
    tr.getEGContentCellContent().add(tc);
  }

  @Override
  public void addTcList(Tr tr, List<String> texts, String width, DocxStyle style, int horizontalMergedCells, String verticalMergedVal, boolean isBullet, WordprocessingMLPackage wordMLPackage) throws JAXBException, InvalidFormatException {
    Tc tc = factory.createTc();
    TcPr tcPr = new TcPr();
    TblWidth tblwidth = new TblWidth();
    tblwidth.setType("dxa");
    tblwidth.setW(new BigInteger(width));
    tcPr.setTcW(tblwidth);
    tc.setTcPr(tcPr);
    setCellVMerge(tc, verticalMergedVal);
    setCellHMerge(tc, horizontalMergedCells);
    if (texts != null && texts.size() > 0) {
      for (String text : texts) {
        if (isBullet) {
          addCellBullet(tc, text, wordMLPackage);
        } else {
          if (style != null) {
            addCellStyle(tc, text, style);
          } else {
            tc.getEGBlockLevelElts().add(wordMLPackage.getMainDocumentPart().createParagraphOfText(text));
          }
        }
      }
    } else {
      tc.getEGBlockLevelElts().add(wordMLPackage.getMainDocumentPart().createParagraphOfText(""));
    }
    tr.getEGContentCellContent().add(tc);
  }


  @Override
  public Tbl getTable() {
    TblWidth width = new TblWidth();
    width.setType("auto");
    width.setW(new BigInteger("0"));


    CTTblPrBase.TblStyle tblStyle = new CTTblPrBase.TblStyle();
    tblStyle.setVal("TableGrid");

    Tbl tbl = factory.createTbl();
    TblPr tblPr = new TblPr();
    tblPr.setTblW(width);

    tblPr.setTblStyle(tblStyle);
    tblPr.setTblInd(width);
    tbl.setTblPr(tblPr);
    return tbl;
  }

  @Override
  public void addParagraph(MainDocumentPart documentPart, ObjectFactory factory, String title, boolean isTitle) {
    RPr titleRPr = getRPr(factory, "맑은 고딕", "000000", "32", STHint.DEFAULT, true, false, false, false);
    RPr subtitleRPr = getRPr(factory, "맑은 고딕", "000000", "24", STHint.EAST_ASIA, true, false, false, false);

    P paragraph = factory.createP();
    Text text = factory.createText();
    R run = factory.createR();

    PPr paragraphProperties = factory.createPPr();
    Jc justification = factory.createJc();
    justification.setVal(JcEnumeration.CENTER);
    paragraphProperties.setJc(justification);

    text.setValue(title);
    text.setSpace("preserve");

    run.getContent().add(text);
    if (isTitle) {
      paragraph.setPPr(paragraphProperties);
      run.setRPr(titleRPr);
    } else {
      run.setRPr(subtitleRPr);
    }
    paragraph.getContent().add(run);
    documentPart.addObject(paragraph);
  }

  @Override
  public void addListParagraph(MainDocumentPart documentPart, ObjectFactory factory, String title, String depth) {
    RPr listOneRPr = getRPr(factory, "맑은 고딕", "000000", "28", STHint.DEFAULT, true, false, false, false);
    RPr listTwoRPr = getRPr(factory, "맑은 고딕", "000000", "22", STHint.DEFAULT, true, false, false, false);
    RPr listThirdRPr = getRPr(factory, "맑은 고딕", "000000", "22", STHint.DEFAULT, false, false, false, false);

    P paragraph = factory.createP();
    Text text = factory.createText();
    R run = factory.createR();

    text.setValue(title);
    text.setSpace("preserve");

    run.getContent().add(text);
    if (depth.equals("0")) {
      run.setRPr(listOneRPr);
    } else if (depth.equals("1")) {
      run.setRPr(listTwoRPr);
    } else {
      run.setRPr(listThirdRPr);
    }
    paragraph.getContent().add(run);
    documentPart.addObject(paragraph);
  }

  @Override
  public void addTitleParagraph(MainDocumentPart documentPart, ObjectFactory factory, String title, boolean isDate) {
    RPr dateRPr = getRPr(factory, "맑은 고딕", "000000", "36", STHint.DEFAULT, true, false, false, false);
    RPr univTitleRPr = getRPr(factory, "맑은 고딕", "000000", "44", STHint.DEFAULT, true, false, false, false);

    P paragraph = factory.createP();
    Text text = factory.createText();
    R run = factory.createR();
    PPr paragraphProperties = factory.createPPr();
    Jc justification = factory.createJc();
    justification.setVal(JcEnumeration.CENTER);
    paragraphProperties.setJc(justification);

    text.setValue(title);
    run.getContent().add(text);
    if (isDate) run.setRPr(dateRPr);
    else run.setRPr(univTitleRPr);
    paragraph.getContent().add(run);
    paragraph.setPPr(paragraphProperties);
    documentPart.addObject(paragraph);
  }

  @Override
  public void createBullet(String country, WordprocessingMLPackage wordMLPackage) throws InvalidFormatException, JAXBException {

    P p = factory.createP();
    org.docx4j.wml.Text t = factory.createText();
    t.setValue(country);
    R run = factory.createR();
    run.getContent().add(t);

    p.getContent().add(run);
    PPr ppr = factory.createPPr();

    p.setPPr(ppr);
//    PPrBase.Ind indent = factory.createPPrBaseInd();
//    indent.setLeft(BigInteger.valueOf(500));
//    indent.setRight(BigInteger.ZERO);
//    ppr.setInd(indent);
    // Create and add <w:numPr>
    PPrBase.NumPr numPr = factory.createPPrBaseNumPr();
    ppr.setNumPr(numPr);


    // The <w:numId> element
    PPrBase.NumPr.NumId numIdElement = factory.createPPrBaseNumPrNumId();
    numPr.setNumId(numIdElement);
    numIdElement.setVal(BigInteger.valueOf(1));

    NumberingDefinitionsPart ndp = new NumberingDefinitionsPart();
    wordMLPackage.getMainDocumentPart().addTargetPart(ndp);
    ndp.setJaxbElement((Numbering) XmlUtils.unmarshalString(BULLET_TEMPLATE));
    wordMLPackage.getMainDocumentPart().addObject(p);
  }

  public void addCellBullet(Tc tc, String text, WordprocessingMLPackage wordMLPackage) throws InvalidFormatException, JAXBException {
    P p = factory.createP();
    org.docx4j.wml.Text t = factory.createText();
    t.setValue(text);
    R run = factory.createR();
    run.getContent().add(t);
    p.getContent().add(run);
    PPr ppr = factory.createPPr();
    p.setPPr(ppr);
    PPrBase.NumPr numPr = factory.createPPrBaseNumPr();
    ppr.setNumPr(numPr);
    RPr runProperties = factory.createRPr();
    setFontSize(runProperties, "20");
    run.setRPr(runProperties);

    // The <w:numId> element
    PPrBase.NumPr.NumId numIdElement = factory.createPPrBaseNumPrNumId();
    numPr.setNumId(numIdElement);
    numIdElement.setVal(BigInteger.valueOf(1));
    NumberingDefinitionsPart ndp = new NumberingDefinitionsPart();
    wordMLPackage.getMainDocumentPart().addTargetPart(ndp);
    ndp.setJaxbElement((Numbering) XmlUtils.unmarshalString(BULLET_TEMPLATE));
    tc.getContent().add(p);
  }

  private void setCellVMerge(Tc tableCell, String mergeVal) {
    if (mergeVal != null) {
      TcPr tableCellProperties = tableCell.getTcPr();
      if (tableCellProperties == null) {
        tableCellProperties = new TcPr();
        tableCell.setTcPr(tableCellProperties);
      }
      TcPrInner.VMerge merge = new TcPrInner.VMerge();
      if (!"close".equals(mergeVal)) {
        merge.setVal(mergeVal);
      }
      tableCellProperties.setVMerge(merge);
    }
  }

  private void setCellHMerge(Tc tableCell, int horizontalMergedCells) {
    if (horizontalMergedCells > 1) {
      TcPr tableCellProperties = tableCell.getTcPr();
      if (tableCellProperties == null) {
        tableCellProperties = new TcPr();
        tableCell.setTcPr(tableCellProperties);
      }

      TcPrInner.GridSpan gridSpan = new TcPrInner.GridSpan();
      gridSpan.setVal(new BigInteger(String.valueOf(horizontalMergedCells)));

      tableCellProperties.setGridSpan(gridSpan);
      tableCell.setTcPr(tableCellProperties);
    }
  }

  private void setCellColor(Tc tableCell, String color) {
    if (color != null) {
      TcPr tableCellProperties = tableCell.getTcPr();
      if (tableCellProperties == null) {
        tableCellProperties = new TcPr();
        tableCell.setTcPr(tableCellProperties);
      }
      CTShd shd = new CTShd();
      shd.setFill(color);
      tableCellProperties.setShd(shd);
    }
  }

  private void setVerticalAlignment(Tc tableCell, STVerticalJc align) {
    if (align != null) {
      TcPr tableCellProperties = tableCell.getTcPr();
      if (tableCellProperties == null) {
        tableCellProperties = new TcPr();
        tableCell.setTcPr(tableCellProperties);
      }

      CTVerticalJc valign = new CTVerticalJc();
      valign.setVal(align);

      tableCellProperties.setVAlign(valign);
    }
  }

  private void setFontSize(RPr runProperties, String fontSize) {
    if (fontSize != null && !fontSize.isEmpty()) {
      HpsMeasure size = new HpsMeasure();
      size.setVal(new BigInteger(fontSize));
      runProperties.setSz(size);
      runProperties.setSzCs(size);
    }
  }

  private void setFontFamily(RPr runProperties, String fontFamily) {
    if (fontFamily != null) {
      RFonts rf = runProperties.getRFonts();
      if (rf == null) {
        rf = new RFonts();
        runProperties.setRFonts(rf);
      }
      rf.setAscii(fontFamily);
    }
  }

  private void setFontColor(RPr runProperties, String color) {
    if (color != null) {
      Color c = new Color();
      c.setVal(color);
      runProperties.setColor(c);
    }
  }

  private static void setHorizontalAlignment(P paragraph, JcEnumeration hAlign) {
    if (hAlign != null) {
      PPr pprop = new PPr();
      Jc align = new Jc();
      align.setVal(hAlign);
      pprop.setJc(align);
      paragraph.setPPr(pprop);
    }
  }

  private static void addBoldStyle(RPr runProperties) {
    BooleanDefaultTrue b = new BooleanDefaultTrue();
    b.setVal(true);
    runProperties.setB(b);
  }

  private RPr getRPr(ObjectFactory factory, String fontFamily,
                     String colorVal, String fontSize, STHint sTHint, boolean isBlod,
                     boolean isUnderLine, boolean isItalic, boolean isStrike) {
    RPr rPr = factory.createRPr();
    RFonts rf = new RFonts();
    rf.setHint(sTHint);
    rf.setAscii(fontFamily);
    rf.setHAnsi(fontFamily);
    rPr.setRFonts(rf);

    BooleanDefaultTrue bdt = factory.createBooleanDefaultTrue();
    rPr.setBCs(bdt);
    if (isBlod) {
      rPr.setB(bdt);
    }
    if (isItalic) {
      rPr.setI(bdt);
    }
    if (isStrike) {
      rPr.setStrike(bdt);
    }
    if (isUnderLine) {
      U underline = new U();
      underline.setVal(UnderlineEnumeration.SINGLE);
      rPr.setU(underline);
    }

    Color color = new Color();
    color.setVal(colorVal);
    rPr.setColor(color);

    HpsMeasure sz = new HpsMeasure();
    sz.setVal(new BigInteger(fontSize));
    rPr.setSz(sz);
    rPr.setSzCs(sz);
    return rPr;
  }

  public void addCellStyle(Tc tc, String content, DocxStyle style) {

    if (style != null) {

      P paragraph = factory.createP();

      Text text = factory.createText();
      text.setValue(content);
      text.setSpace("preserve");

      R run = factory.createR();
      run.getContent().add(text);

      paragraph.getContent().add(run);

      setHorizontalAlignment(paragraph, style.getHorizontalAlignment());

      RPr runProperties = factory.createRPr();

      if (style.isBold()) {
        addBoldStyle(runProperties);
      }

      setFontSize(runProperties, style.getFontSize());
      setFontColor(runProperties, style.getFontColor());
      setFontFamily(runProperties, style.getFontFamily());

      if (style.getTop() > 0 || style.getBottom() > 0 || style.getLeft() > 0 || style.getRight() > 0) {
        setCellMargins(tc, style.getTop(), style.getRight(), style.getBottom(), style.getLeft());
      }
      setCellColor(tc, style.getBackground());
      setVerticalAlignment(tc, style.getVerticalAlignment());
      if (style.isBorderLeft() || style.isBorderRight() || style.isBorderTop() || style.isBorderBottom()) {
        setCellBorders(tc, style.isBorderTop(), style.isBorderRight(), style.isBorderBottom(), style.isBorderLeft());
      }
      run.setRPr(runProperties);

      tc.getContent().add(paragraph);
    }
  }

  private void setCellMargins(Tc tableCell, int top, int right, int bottom, int left) {
    TcPr tableCellProperties = tableCell.getTcPr();
    if (tableCellProperties == null) {
      tableCellProperties = new TcPr();
      tableCell.setTcPr(tableCellProperties);
    }
    TcMar margins = new TcMar();

    if (bottom > 0) {
      TblWidth bW = new TblWidth();
      bW.setType("dxa");
      bW.setW(BigInteger.valueOf(bottom));
      margins.setBottom(bW);
    }

    if (top > 0) {
      TblWidth tW = new TblWidth();
      tW.setType("dxa");
      tW.setW(BigInteger.valueOf(top));
      margins.setTop(tW);
    }

    if (left > 0) {
      TblWidth lW = new TblWidth();
      lW.setType("dxa");
      lW.setW(BigInteger.valueOf(left));
      margins.setLeft(lW);
    }

    if (right > 0) {
      TblWidth rW = new TblWidth();
      rW.setType("dxa");
      rW.setW(BigInteger.valueOf(right));
      margins.setRight(rW);
    }

    tableCellProperties.setTcMar(margins);
  }

  private void setCellBorders(Tc tableCell, boolean borderTop, boolean borderRight,
                              boolean borderBottom, boolean borderLeft) {

    TcPr tableCellProperties = tableCell.getTcPr();
    if (tableCellProperties == null) {
      tableCellProperties = new TcPr();
      tableCell.setTcPr(tableCellProperties);
    }

    CTBorder border = new CTBorder();
    border.setColor("auto");
//    border.setColor("0000FF");
    border.setSz(new BigInteger("20"));
    border.setSpace(new BigInteger("0"));
    border.setVal(STBorder.NONE);

    TcPrInner.TcBorders borders = new TcPrInner.TcBorders();
    if (borderBottom) {
      borders.setBottom(border);
    }
    if (borderTop) {
      borders.setTop(border);
    }
    if (borderLeft) {
      borders.setLeft(border);
    }
    if (borderRight) {
      borders.setRight(border);
    }
    tableCellProperties.setTcBorders(borders);
  }

  @Override
  public P newImage(WordprocessingMLPackage wordMLPackage, byte[] bytes, String filenameHint, String altText, int id1, int id2, long cx) throws Exception {
    BinaryPartAbstractImage imagePart = BinaryPartAbstractImage.createImagePart(wordMLPackage, bytes);
    Inline inline = imagePart.createImageInline(filenameHint, altText, id1, id2, cx, false);
    // Now add the inline in w:p/w:r/w:drawing
    ObjectFactory factory = Context.getWmlObjectFactory();
    P p = factory.createP();
    R run = factory.createR();
    p.getContent().add(run);
    PPr paragraphProperties = factory.createPPr();
    Jc justification = factory.createJc();
    justification.setVal(JcEnumeration.CENTER);
    paragraphProperties.setJc(justification);

    p.setPPr(paragraphProperties);
    Drawing drawing = factory.createDrawing();
    run.getContent().add(drawing);
    drawing.getAnchorOrInline().add(inline);
    return p;
  }

}

