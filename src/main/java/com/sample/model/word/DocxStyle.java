package com.sample.model.word;

import org.docx4j.wml.JcEnumeration;
import org.docx4j.wml.STVerticalJc;

public class DocxStyle {
  public boolean bold;
  public boolean italic;
  public boolean underline;
  public String fontSize;
  public String fontColor;
  public String fontFamily;

  // cell margins
  public int left;
  public int bottom;
  public int top;
  public int right;

  public String background;
  public STVerticalJc verticalAlignment;
  public JcEnumeration horizontalAlignment;

  public boolean borderLeft;
  public boolean borderRight;
  public boolean borderTop;
  public boolean borderBottom;
//  private boolean noWrap;

  public boolean isBold() {
    return bold;
  }

  public void setBold(boolean bold) {
    this.bold = bold;
  }

  public boolean isItalic() {
    return italic;
  }

  public void setItalic(boolean italic) {
    this.italic = italic;
  }

  public boolean isUnderline() {
    return underline;
  }

  public void setUnderline(boolean underline) {
    this.underline = underline;
  }

  public String getFontSize() {
    return fontSize;
  }

  public void setFontSize(String fontSize) {
    this.fontSize = fontSize;
  }

  public String getFontColor() {
    return fontColor;
  }

  public void setFontColor(String fontColor) {
    this.fontColor = fontColor;
  }

  public String getFontFamily() {
    return fontFamily;
  }

  public void setFontFamily(String fontFamily) {
    this.fontFamily = fontFamily;
  }

  public String getBackground() {
    return background;
  }

  public void setBackground(String background) {
    this.background = background;
  }

  public STVerticalJc getVerticalAlignment() {
    return verticalAlignment;
  }

  public void setVerticalAlignment(STVerticalJc verticalAlignment) {
    this.verticalAlignment = verticalAlignment;
  }

  public JcEnumeration getHorizontalAlignment() {
    return horizontalAlignment;
  }

  public void setHorizontalAlignment(JcEnumeration horizontalAlignment) {
    this.horizontalAlignment = horizontalAlignment;
  }

  public boolean isBorderLeft() {
    return borderLeft;
  }

  public void setBorderLeft(boolean borderLeft) {
    this.borderLeft = borderLeft;
  }

  public boolean isBorderRight() {
    return borderRight;
  }

  public void setBorderRight(boolean borderRight) {
    this.borderRight = borderRight;
  }

  public boolean isBorderTop() {
    return borderTop;
  }

  public void setBorderTop(boolean borderTop) {
    this.borderTop = borderTop;
  }

  public boolean isBorderBottom() {
    return borderBottom;
  }

  public void setBorderBottom(boolean borderBottom) {
    this.borderBottom = borderBottom;
  }

  public int getLeft() {
    return left;
  }

  public void setLeft(int left) {
    this.left = left;
  }

  public int getBottom() {
    return bottom;
  }

  public void setBottom(int bottom) {
    this.bottom = bottom;
  }

  public int getTop() {
    return top;
  }

  public void setTop(int top) {
    this.top = top;
  }

  public int getRight() {
    return right;
  }

  public void setRight(int right) {
    this.right = right;
  }
}
