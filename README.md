# java-jungsuk-exercise
Java의 정석 예제 풀이

Markdown 연습
출처 : [마크다운(Markdown) 사용법][markdownlink] 를 보면서 혼자 실습해보는 README.md

[markdownlink]: https://gist.github.com/ihoneymon/652be052a0727ad59601

마크다운 : 텍스트기반 마크업 언어. HTML로 변환 가능
README.md : 깃험의 저장소 Repository에 관한 정보 기재, 마크다운 문서(.md) = 설치방법, 소스코드 설명, 이슈 등

헤더
Tis ia an H1
=============

This is an H2
-------------

# This is a H1

## This is a H2

### This is a H3

#### This is a H4

##### This is a H5

###### This is a H6

> This is a first blockqute.
> > This is a second blockqute.
> > > This is a third blockqute.

> ### This is a H3
> > #### This is a H4

순서 있는 목록 (1)
1. 첫번째
2. 두번째
3. 이렇게 쓰면 자동으로 목록이 되나?

순서 있는 목록 (2)

1. 첫번째
3. 세번째
2. 두번째

순서 없는 목록

* 첫번째
  * 두번째
    * 세번째


+ 첫번째
  + 두번째
    + 세번째


- 첫번째
  - 두번째
    - 세번째

   
* 첫번째
  - 두번째
    + 세번째
      + 네번째


코드

This is a normal paragraph:

    This is a code block.
  
end code block.

코드블럭
<pre><code>{code}</code></pre>

<pre>
<code>
public class BootSpringBootApplication { 
  public static void main(String[] args) {
    System.out.println("Hello World");
  }
}
</code>
</pre>

```
public class BootSpringBootApplication {
  public static void main(String[] args) {
    System.out.println("Hello World~");
  }
}
```

```java
public class BootSpringBootApplication {
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }
}
```

수평선
* * *
***
*****
- - - 
-----------------------------------

링크
Link : [Google][googlelink]

[googlelink]: https://google.com "Go google"

외부링크 : <https://www.naver.com/>
이메일링크 : <address@naverm.com>


*single asterisks*
_single underscores_
**double asterisks**
__double underscores__
~~cancelline~~

문장 중간에 사용할 경우에는 **띄어쓰기**를 하는 것이 좋다.

이미지

![RubberDuck](https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Rubber_Duck_%288374802487%29.jpg/270px-Rubber_Duck_%288374802487%29.jpg)

![RubberDuck](https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Rubber_Duck_%288374802487%29.jpg/270px-Rubber_Duck_%288374802487%29.jpg "RubberDuck")

러버덕 **너무**귀엽다.. 나도 러버덕 실제로 봐보고 싶었는데ㅠㅠ 한번도 못 봤네...ㅠㅠ 요즘도 *러버덕* 설치되어 있나? 내년에도 있을까?

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Rubber_Duck_%288374802487%29.jpg/270px-Rubber_Duck_%288374802487%29.jpg" width="450px" height="300px" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Rubber_Duck_%288374802487%29.jpg/270px-Rubber_Duck_%288374802487%29.jpg" width="40%" height="30%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>


줄바꿈   

줄 바꿈을 하기 위해서는 문장 마지막에서 3칸이상을 띄어쓰기해야 한다.           이렇게         

