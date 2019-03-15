<h1>氧育智能园大数据项目</h1>
<br>
<ul>
    <li>
        项目描述
        该项目用于根据园区位置信息，获取周边小区、异业商户、竞争商户基本信息。基于这些信息，经大数据计算，
        可以分析得出适合对象园区的招生策略、最优开店方略、精准广告推送等方案，帮助园区利益最大化。
   </li>
   <li>
        项目技术框架
        后端框架：Springboot <br>
        持久化框架：Mybatis <br>
        数据库：postgres <br>
        爬虫框架：Crawler4j <br>
        HTML解析框架：Jsoup
   </li>
   <li>
        项目环境搭建
        安装homebrew:执行/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
        <br>
        安装maven:执行brew update && install maven
        <br>
        进入项目根目录  
        拉取项目依赖：执行mvn install
        <br>
        maven启动springboot:执行mvn springboot:run
</ul>