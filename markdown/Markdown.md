# atx-style 一级标题
## 二级标题
###### 六级标题

Setext-style 一级标题
======
二级标题
---------------
***
-----
______


白日依山尽，

黄河入海流。（句号后面没有空格）

欲穷千里目，

更上一层楼。  
（句号后面有两个空格）

后面俩字**加黑**

__文本加黑__

_文本斜体_

~~删除文本~~

后面俩字*斜体*

***斜体加黑***

<font size=4>我是变大的字</font>

<small>字体变小</small>

<big>字体变大</big>

- Red
- Green
- Blue(-后面有空格)

* Red
+ Green

1. Red
2. Green

> 这是一段引用  //在>后面有一个空格
>
>     这是引用的代码块形式 //在>后面又五个空格

>代码例子：
>
    protected void onCreat(Bundle savedInstanceState){
        super.onCraet(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

>一级引用
>>二级引用
>>>三级引用
...
>### 引用块内的标题（#后有空格）

图片:![一张照片](https://mazhuang.org/favicon.ico "favion")
图片:![一张照片](./test.png)
行内式链接:[百度一下](www.baidu.com "带名字，也可以不要")

引用式链接:[ Github ][1]
[1]: www.github.com  "百度一下"

### 表格：
|编号|姓名（左）|年龄（右）|性别（中）|
|---|:----|---:|:----:|
|0|张三|28|男|
|1|李四|29|女|

### 任务列表：
- [ ] 洗碗
- [ ] 清洗油烟机
- [ ] 拖地

### 自动链接:
https://github.com

<example@gmail.com>

### 表情
:smile: :camel: :blush: :cry:



# 流程图
---

    代码块方式一（利用Tab）
    #include<stdio.h>
    int main(void){
        printf("This is my markdown notes");
        return 0;
    }

```
代码块方式二（利用```）
#include<stdio.h>
int main(void){
    printf("This is my markdown notes");
    return 0;
}
```
这是一个示例:`实例效果`

&nbsp;你好，1/4中文
&ensp;你好，半个中文
&emsp;你好，一个中文，2个字符
你好

&#160;Hello
&#8194;Hello
&#8195;Hello

\反斜线
*星号
_下划线
{},[]
\#必须要有\
+
\-必须要有\
.
!

&#10084;
&#10003;
&#9728;
&#9775;
&#8724;
&#9835;
&#1;
https://unicode-table.com/cn/


<font color=#0099ff size=20 face="黑体">你好</font>

$\sqrt{x^{2}}$:引用公式，行内公式
行间公式:$$\sqrt{x^{7}}$$

$$
{
e^x =\lim_{n\to\infty} \left(1+\frac{x}{n} \right)^n
\qquad (1)
}
$$


### 流程图
-----
``` flow
st=>start: 开始:>www.baidu.com
op1=>operation: My operation
c=>condition: Yes or No?
e=>end: 结束

st->op1->c
c(yes)->e
c(no)->op1
```

### 时序图
-----
```seq
A->>B: 调用
B->>A: 回调
```


***
你好[^1]，你好笨[^2]
[^1]:敬语
[^2]:有褒义，有贬义，看具体语境




|名称|交换机|相连接口|IP地址|
|---|---|---|---|
|计算机1|SwA|F0/1|192.168.1.11/24|
|计算机2|SwA|F0/2|192.168.1.12/24|
|计算机3|SwA|F0/3|192.168.1.13/24|
|计算机4|SwB|F0/1|192.168.1.21/24|
|计算机5|SwB|F0/2|192.168.1.22/24|
|计算机6|SwB|F0/3|192.168.1.23/24|


|网段号|子网掩码|网关|IP地址|VLAN ID|备注|
|---|---|---|---|---|---|
|192.168.1.0|255.255.255.0|192.168.1.1|192.168.1.2|101|PC0所在网段|
|192.168.2.0|255.255.255.0|192.168.2.1|192.168.2.2|102|PC1所在网段|
|192.168.1.0|255.255.255.0|192.168.1.1|192.168.1.3|101|PC2所在网段|
|192.168.2.0|255.255.255.0|192.168.2.1|192.168.2.3|102|PC3所在网段|


|名称|接口|IP地址|
|---|---|---|
|PC1|COM1||
|PC2|FastEthernet|172.1.2.2/24|
|R1|S2/0|172.1.1.1/24|
|R2|S2/0|172.1.1.2/24|
|R2|F0/0|172.1.2.1/24|