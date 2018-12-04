# 绑定
JavaFX绑定同步两个值：当依赖变量更改时，其他变量更改。  
要将属性绑定到另一个属性，请调用bind()方法，该方法在一个方向绑定值。 
例如，当属性A绑定到属性B时，属性B的更改将更新属性A，但不可以反过来。  

## 绑定选项
JavaFX提供了许多绑定选项，以便在域对象和GUI控件中的属性之间进行同步。  
我们可以在JavaFX的Properties 
API中使用以下三种绑定策略：
* Java Bean上的双向绑定
* 与Fluent API的高级绑定
* 使用javafx.beans.binding定义绑定对象进行低级绑定。