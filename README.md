<h1>氧育智能园大数据项目</h>
<br>
<ul>
    <li>
        <h3>项目描述</h3>
        该项目用于根据园区位置信息，获取周边小区、异业商户、竞争商户基本信息。基于这些信息，经大数据计算，
        可以分析得出适合对象园区的招生策略、最优开店方略、精准广告推送等方案，帮助园区利益最大化。
   </li>
   <li>
        <h3>项目技术框架</h3>
        后端框架：Springboot <br>
        持久化框架：Mybatis <br>
        数据库：postgres <br>
        爬虫框架：Crawler4j <br>
        HTML解析框架：Jsoup
   </li>
   <li>
        <h3>项目环境搭建</h3>
        <h4>安装homebrew:</h4> 执行/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
        <br>
        <h4>安装maven:</h4>执行brew update && install maven
        <br>
        <h4>进入项目根目录</h4>  
        <h4>拉取项目依赖：</h4>执行mvn install
        <br>
        <h4>maven启动springboot</h4>执行mvn springboot:run
</ul>