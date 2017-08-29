1. PDF 저장시 사용하는 라이브러리 (jquery같은것은 생략)
  "html2canvas": "0.4.1",
  "jspdf": "1.3.2",
  "bluebird": "3.4.7"
  
  PDF 출력은 https://parall.ax/products/jspdf 사이트에서 추가적인 설명을 받을 수 있습니다.
  저희 pdf 같은경우는 저 jspdf 라이브러리 기능을 많이 사용하지 않고
  HTML2CANVAS(https://html2canvas.hertzen.com)를 이용해서 html 을 canvas로 변환후에 image로 추출하여서
  jsPdf에 이미지를 넣는 방식으로 되있습니다.
  작업중 아래와 같은 소스가 있는데 하단의 소스는 그대로 canvas 변환후 image 추출시 퀄리티가 낮아지므로 퀄리티를 올린 소스입니다.
  다만 문제가 있다면 scaleBy부분의 숫자를 올릴수록 퀄리티는 높아지지만 마찬가지로 pdf의 용량도 같이 증가합니다.
  이점 유의하시면서 사용해주시면 될것같습니다.
  
      var dom = $(".catalogue-container")[0];
      var scaleBy = 3;
      var canvas = document.createElement('canvas');
      canvas.width = width * scaleBy;
      canvas.height = height * scaleBy;
      canvas.style.width = width + 'px';
      canvas.style.height = height + 'px';
      var context = canvas.getContext('2d');
      context.scale(scaleBy, scaleBy);
    
2. 워드 출력 기능은 docx4j 라는 라이브러리를 사용
   홈페이지 : https://www.docx4java.org/trac/docx4j
   github : https://github.com/plutext/docx4j
   
   간략한 소스 리뷰는 model 폴더에 
   DocxStyle 에서 사용할 속성들을 정의해줍니다. 예를 들어서 정렬 볼드, 이탤릭 등의 기능등을 정의해준 후에
   WordServiceImpl에서 정의된 속성들을 조합하여 css를 정의하듯이 자기가 원하는 스타일의 종류를 정의하여서 사용하면 됩니다.
   샘플 소스에서는 2개의 스타일만을 사용하였는데, 첨부된 파일에는 기존에 사용했었던 여러 종류의 스타일도 함께 첨부되어 있습니다.
   그리고 WordController에서 최하단 부분에 주석을 걸었는데 워드파일을 다운받을실 경로를 지정해주시면 됩니다.
   
   
  
